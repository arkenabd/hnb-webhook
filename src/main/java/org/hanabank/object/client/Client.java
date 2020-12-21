package org.hanabank.object.client;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String clientId;
	private List<String> redirectUris = new ArrayList<String>();
	private List<String> webOrigins = new ArrayList<String>();
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public List<String> getRedirectUris() {
		return redirectUris;
	}
	public void setRedirectUris(List<String> redirectUris) {
		this.redirectUris = redirectUris;
	}
	public List<String> getWebOrigins() {
		return webOrigins;
	}
	public void setWebOrigins(List<String> webOrigins) {
		this.webOrigins = webOrigins;
	}
}
