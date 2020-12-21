package org.hanabank.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.hanabank.object.client.Client;

public class ClientService {

	public void updateWebOrigins(Exchange exchange) {
		Client client = new Client();
		List<String> defaultValue = new ArrayList<String>();
		defaultValue.add("*");
		
		client.setClientId(exchange.getProperty("applicationId").toString());
		client.setRedirectUris(defaultValue);
		client.setWebOrigins(defaultValue);
//		pass.setType("password");
//		pass.setTemporary(true);
//		pass.setValue("redhat");
//		pass.setHashedSaltedValue("redhat");
//		pass.setSalt("redhat");
		exchange.getIn().setBody(client, Client.class);
	}
}
