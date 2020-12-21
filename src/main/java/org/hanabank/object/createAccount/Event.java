package org.hanabank.object.createAccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event {
	
	@XmlElement
	@JsonIgnore
	private String action;
	@XmlElement
	@JsonIgnore
	private String type;
	@XmlElement(name = "object")
	@JsonIgnore
	private Object object;
	
	public String[] getRequiredActions() {
		return new String[]{"VERIFY_EMAIL", "UPDATE_PASSWORD"};
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	public Boolean getEnabled() {
		return true;
	}
	public Boolean getEmailVerified() {
		return false;
	}
	public String getUsername() {
		return object.getAccount().getUsers().getUser().getUsername();
	}
	public String getEmail() {
		return object.getAccount().getUsers().getUser().getEmail();
	}
//	public ArrayList<String> getRequiredAction() {
//		ArrayList<String> stringArray = new ArrayList<String>();
//		stringArray.add("VERIFY_EMAIL");
//		stringArray.add("UPDATE_PASSWORD");
//		return stringArray;
//	}
	@JsonIgnore
	public String getApplicationId() {
		return object.getApplication().getApplication_id();
	}
	
	public Event() {
		
	}
}
