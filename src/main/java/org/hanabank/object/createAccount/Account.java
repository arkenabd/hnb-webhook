package org.hanabank.object.createAccount;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
	
	@XmlElement
	private String id;
	@XmlElement
	private Date created_at;
	@XmlElement
	private Date updated_at;
	@XmlElement
	private String state;
	@XmlElement
	private String org_name;
	@XmlElement(name = "extra_fields")
	private Extra_fields extra_fields;
	@XmlElement
	private Boolean monthly_billing_enabled;
	@XmlElement
	private Boolean monthly_charging_enabled;
	@XmlElement
	private Boolean credit_card_stored;
	@XmlElement(name = "plans")
	private Plans plans;
	@XmlElement(name = "users")
	private Users users;
	
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
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public Extra_fields getExtra_fields() {
		return extra_fields;
	}
	public void setExtra_fields(Extra_fields extra_fields) {
		this.extra_fields = extra_fields;
	}
	public Boolean getMonthly_billing_enabled() {
		return monthly_billing_enabled;
	}
	public void setMonthly_billing_enabled(Boolean monthly_billing_enabled) {
		this.monthly_billing_enabled = monthly_billing_enabled;
	}
	public Boolean getMonthly_charging_enabled() {
		return monthly_charging_enabled;
	}
	public void setMonthly_charging_enabled(Boolean monthly_charging_enabled) {
		this.monthly_charging_enabled = monthly_charging_enabled;
	}
	public Boolean getCredit_card_stored() {
		return credit_card_stored;
	}
	public void setCredit_card_stored(Boolean credit_card_stored) {
		this.credit_card_stored = credit_card_stored;
	}
	public Plans getPlans() {
		return plans;
	}
	public void setPlans(Plans plans) {
		this.plans = plans;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public Account() {
		
	}
}
