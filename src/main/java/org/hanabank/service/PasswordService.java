package org.hanabank.service;

import org.apache.camel.Exchange;
import org.hanabank.object.password.Password;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {

	public void setDefaultPassword(Exchange exchange) {
		Password pass = new Password();
		pass.setType("password");
		pass.setTemporary(true);
		pass.setValue("redhat");
		pass.setHashedSaltedValue("redhat");
		pass.setSalt("redhat");
		exchange.getIn().setBody(pass, Password.class);
	}
}
