package org.hanabank.object.password;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Password {

	@JsonProperty
	private String type;
	@JsonProperty
	private Boolean temporary;
	@JsonProperty
	private String value;
	@JsonProperty
	private String hashedSaltedValue;
	@JsonProperty
	private String salt;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getTemporary() {
		return temporary;
	}
	public void setTemporary(Boolean temporary) {
		this.temporary = temporary;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getHashedSaltedValue() {
		return hashedSaltedValue;
	}
	public void setHashedSaltedValue(String hashedSaltedValue) {
		this.hashedSaltedValue = hashedSaltedValue;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	
	@Override
	public String toString() {
		return "Password [type=" + type + ", temporary=" + temporary + ", value=" + value + ", hashedSaltedValue="
				+ hashedSaltedValue + ", salt=" + salt + "]";
	}
}
