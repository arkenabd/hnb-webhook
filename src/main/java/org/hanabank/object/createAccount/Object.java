package org.hanabank.object.createAccount;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hanabank.object.createApplication.Application;

@XmlRootElement(name = "object")
@XmlAccessorType(XmlAccessType.FIELD)
public class Object {
	
	@XmlElement(name = "account")
	private Account account;
	
	@XmlElement(name = "application")
	private Application application;

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccounts(Account account) {
		this.account = account;
	}

	public Object() {

	}
	
	
}
