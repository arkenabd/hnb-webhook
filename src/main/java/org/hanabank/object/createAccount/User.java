package org.hanabank.object.createAccount;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
	
	@XmlElement
	private String id;
	@XmlElement
	private Date created_at;
	@XmlElement
	private Date updated_at;
	@XmlElement
	private String state;
	@XmlElement
	private String role;
	@XmlElement
	private String username;
	@XmlElement
	private String email;
	@XmlElement
	private String org_name;
	@XmlElement(name = "extra_fields")
	private Extra_fields_2 extra_fields;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public Extra_fields_2 getExtra_fields() {
		return extra_fields;
	}
	public void setExtra_fields(Extra_fields_2 extra_fields) {
		this.extra_fields = extra_fields;
	}
	
	public User() {
		
	}
	
}
