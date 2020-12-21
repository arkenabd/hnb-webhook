package org.hanabank.object.createAccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "extra_fields")
@XmlAccessorType(XmlAccessType.FIELD)
public class Extra_fields_2 {

	@XmlElement
	private String Cp_pn;
	@XmlElement
	private String Cp_tech;
	@XmlElement
	private String cp_email;
	
	public String getCp_pn() {
		return Cp_pn;
	}
	public void setCp_pn(String cp_pn) {
		Cp_pn = cp_pn;
	}
	public String getCp_tech() {
		return Cp_tech;
	}
	public void setCp_tech(String cp_tech) {
		Cp_tech = cp_tech;
	}
	public String getCp_email() {
		return cp_email;
	}
	public void setCp_email(String cp_email) {
		this.cp_email = cp_email;
	}
	
	public Extra_fields_2() {
		
	}
}
