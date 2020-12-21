package org.hanabank.service;

import java.util.List;

import org.apache.camel.Exchange;
import org.hanabank.object.findUsername.User;
import org.hanabank.object.findUsername.Users;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	public void findUsername(Exchange exchange) {
		List<User> users = (List<User>) exchange.getIn().getBody();
		String username = (String) exchange.getProperty("username");
		System.out.println("Users Data: " + users.toString());
		for (User user : users) {
			System.out.println("User Data: " + user.getUsername());
			System.out.println("Username Data: " + username);
			if (username.equalsIgnoreCase(user.getUsername())) {
				String id = user.getId();
				exchange.setProperty("id", id);
				break;
			}
		}
	}
}
