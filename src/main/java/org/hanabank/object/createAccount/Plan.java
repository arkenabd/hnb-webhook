package org.hanabank.object.createAccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "plan")
@XmlAccessorType(XmlAccessType.FIELD)
public class Plan {
	
	@XmlElement
	private String id;
	@XmlElement
	private String name;
	@XmlElement
	private String type;
	@XmlElement
	private String state;
	@XmlElement
	private Boolean approval_required;
	@XmlElement
	private String setup_fee;
	@XmlElement
	private String cost_per_month;
	@XmlElement
	private String trial_period_days;
	@XmlElement
	private String cancellation_period;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getApproval_required() {
		return approval_required;
	}
	public void setApproval_required(Boolean approval_required) {
		this.approval_required = approval_required;
	}
	public String getSetup_fee() {
		return setup_fee;
	}
	public void setSetup_fee(String setup_fee) {
		this.setup_fee = setup_fee;
	}
	public String getCost_per_month() {
		return cost_per_month;
	}
	public void setCost_per_month(String cost_per_month) {
		this.cost_per_month = cost_per_month;
	}
	public String getTrial_period_days() {
		return trial_period_days;
	}
	public void setTrial_period_days(String trial_period_days) {
		this.trial_period_days = trial_period_days;
	}
	public String getCancellation_period() {
		return cancellation_period;
	}
	public void setCancellation_period(String cancellation_period) {
		this.cancellation_period = cancellation_period;
	}
	public Plan() {

	}
	
	
}
