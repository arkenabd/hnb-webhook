package org.hanabank.object.createAccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "extra_fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class Extra_fields {

	@XmlElement
	private String Email_Tech;
	@XmlElement
	private String phone_tech;
	@XmlElement
	private String system_id;
	@XmlElement
	private String partner_server_location;
	@XmlElement
	private String Integration;
	@XmlElement
	private String Partner_programming_language;
	@XmlElement
	private String Connection_method;
	@XmlElement
	private String Public_IP;
	
	public String getEmail_Tech() {
		return Email_Tech;
	}
	public void setEmail_Tech(String email_Tech) {
		Email_Tech = email_Tech;
	}
	public String getPhone_tech() {
		return phone_tech;
	}
	public void setPhone_tech(String phone_tech) {
		this.phone_tech = phone_tech;
	}
	public String getSystem_id() {
		return system_id;
	}
	public void setSystem_id(String system_id) {
		this.system_id = system_id;
	}
	public String getPartner_server_location() {
		return partner_server_location;
	}
	public void setPartner_server_location(String partner_server_location) {
		this.partner_server_location = partner_server_location;
	}
	public String getIntegration() {
		return Integration;
	}
	public void setIntegration(String integration) {
		Integration = integration;
	}
	public String getPartner_programming_language() {
		return Partner_programming_language;
	}
	public void setPartner_programming_language(String partner_programming_language) {
		Partner_programming_language = partner_programming_language;
	}
	public String getConnection_method() {
		return Connection_method;
	}
	public void setConnection_method(String connection_method) {
		Connection_method = connection_method;
	}
	public String getPublic_IP() {
		return Public_IP;
	}
	public void setPublic_IP(String public_IP) {
		Public_IP = public_IP;
	}
	
	public Extra_fields() {

	}
	
}
