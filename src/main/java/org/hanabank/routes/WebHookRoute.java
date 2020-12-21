package org.hanabank.routes;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http4.HttpOperationFailedException;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestParamType;
import org.hanabank.object.createAccount.Event;
import org.hanabank.object.token.Token;
import org.hanabank.service.ClientService;
import org.hanabank.service.PasswordService;
import org.hanabank.service.UserService;
import org.hanabank.service.completeMessageService;
import org.springframework.stereotype.Component;

@Component
public class WebHookRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		
		// TODO Auto-generated method stub
		JAXBContext jaxbContext = JAXBContext.newInstance(Event.class);
		JaxbDataFormat eventDataFormat = new JaxbDataFormat(jaxbContext);
		
				restConfiguration()
				  .contextPath("/webhook") 
				  .host("{{server.address}}")
				  .port("{{conf.port}}")
				  .component("jetty")
				  ;
				
				rest()
				  .id("ping-service")
				  .get().param().name("ping").type(RestParamType.query).endParam()
				  .to("direct:pingService")
				  
				  .post().id("3scale-webhook").consumes("application/xml")
				  .to("direct:webhook3Scale")
				  ;
				  
//		Get Access Token and Refresh Token
				
		from("timer:startInitiateAccessToken?repeatCount=1")
		.to("direct:initialAccessToken")
		;
				
		from("quartz://scheduledInitialAccessToken?cron=0+0/5+*+1/1+*+?+*")
		.to("direct:initialAccessToken")
		;
		
		from("direct:initialAccessToken")
			.log("SSO URL: {{sso.url}}")
			.removeHeader("Camel*")
			.setHeader(Exchange.HTTP_METHOD, constant("POST"))
			.setHeader(Exchange.CONTENT_TYPE, constant("application/x-www-form-urlencoded"))
			.setBody(simple("grant_type=password&username={{sso.username}}&password={{sso.password}}&client_id={{sso.clientId}}"))
			.to("https4://{{sso.url}}/auth/realms/master/protocol/openid-connect/token")
			
			.unmarshal().json(JsonLibrary.Jackson, Token.class)
			.log("This is the Access Token: ${body.getAccess_token} & This is the Refresh Token: ${body.getRefresh_token}")
			.bean("token", "setAccess_token(${body.getAccess_token})")
			.bean("token", "setRefresh_token(${body.getRefresh_token})")
			.log("Token to access Single Sign-On is saved. Automatically refresh the token when expiry is due.")
		;
		
//		Refresh the Refresh Token
//		from("quartz://refreshToken?cron=0+0+0+1/1+*+?+*&startDelayedSeconds=1")
//		.removeHeader("Camel*")
//		.setHeader("Authorization", method("token", "bearerAuth"))
//		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
//		.setHeader(Exchange.CONTENT_TYPE, constant("application/x-www-form-urlencoded"))
//		.setBody(method("token", "refreshBodyRequest"))
//		.to("https4://{{sso.url}}/auth/realms/master/protocol/openid-connect/token")	
//		
//		.unmarshal().json(JsonLibrary.Jackson, Token.class)
//		.bean("token", "setAccess_token(${body.getAccess_token})")
//		.bean("token", "setRefresh_token(${body.getRefresh_token})")
//		.log("Successfully request new refreshed token.")
//		.log("This is your new Access Token: ${body.getAccess_token}")
//		;

//		Ping Service Route
		from("direct:pingService")
		.setBody(simple("The PING from 3Scale was just succesful and here is the header: ${header.ping}"))
		.setHeader("Authorization", method("token", "bearerAuth"))
		.log("Access Token Create Account: ${header.Authorization}")
		;
		
//		Content Based Router
		from("direct:webhook3Scale").id("content-based-router-to-each-service")
		.unmarshal(eventDataFormat)
		.choice()
			.when().simple("${body.getType} == 'account' && ${body.getAction} == 'created'")
				.to("direct:accountCreated")
			.when().simple("${body.getType} == 'application' && ${body.getAction} == 'created'")
				.to("direct:applicationCreated")
		.endChoice()
		;
		
//      Create Account Flow START ----------------------------------------------------------->
//		Create Account on RedHat SSO
		from("direct:accountCreated").id("Account Created Router")
		.log("This is the account created: ${body}")
		.removeHeaders("Camel*")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader("Authorization", method("token", "bearerAuth"))
		.setProperty("username", simple("${body.getUsername}"))
		.bean(completeMessageService.class, "requiredAction")
		.marshal().json(JsonLibrary.Jackson)
		.log("JSON MESSAGE BODY: ${body}")
		.log("Access Token Create Account: ${header.Authorization}")
		.to("https4://{{sso.url}}/auth/admin/realms/3scale-realm/users")
		
//		Get RedHat SSO User Id
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
		.log("Access Token Get All Users : ${header.Authorization}")
		.to("https4://{{sso.url}}/auth/admin/realms/3scale-realm/users")
		.unmarshal("jsonData")
		.log("the new message: ${body}")
		.bean(UserService.class, "findUsername")
		.log("This is the id of the user: ${exchangeProperty[id]}")
		
//		Set Default Password for User on RedHat SSO
		.setBody(constant(null))
		.setHeader(Exchange.HTTP_METHOD, constant("PUT"))
		.bean(PasswordService.class, "setDefaultPassword")
		.marshal("password-json-data")
		.log("the message body for Password: ${body}")
		.log("Access Token Reset Password : ${header.Authorization}")
		.toD("https4://{{sso.url}}/auth/admin/realms/3scale-realm/users/${exchangeProperty[id]}/reset-password")
		;
		
//      Create Account Flow END ------------------------------------------------------------->
		
//      Create Application Flow START ----------------------------------------------------------->
		from("direct:applicationCreated").id("Application Created Router")
		.setProperty("applicationId", simple("${body.getApplicationId}"))
		.removeHeaders("Camel*")
		.setHeader("Authorization", method("token", "bearerAuth"))
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
		.setHeader(Exchange.HTTP_QUERY, simple("clientId=${exchangeProperty[applicationId]}")).delay(constant("5000"))
		.log("This is the application created: ${body}")
		.to("https4://{{sso.url}}/auth/admin/realms/3scale-realm/clients")
		.unmarshal().json(JsonLibrary.Jackson)
		.log("The data of spesific client: ${body}")
		.setProperty("idOfTheClient", simple("${body[0][id]}"))
		.log("This is the id of the client: ${exchangeProperty[idOfTheClient]}")
		
		.setBody(constant(null))
		.setHeader(Exchange.HTTP_METHOD, constant("PUT"))
		.bean(ClientService.class, "updateWebOrigins")
		.marshal("client-json-data")
		.log("the message body for Update WebOrigins: ${body}")
		.toD("https4://{{sso.url}}/auth/admin/realms/3scale-realm/clients/${exchangeProperty[idOfTheClient]}")
		;
//      Create Application Flow END ------------------------------------------------------------->
	}

	
}