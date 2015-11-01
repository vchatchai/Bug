package com.bug.shared.authentication;

public class Token {

	private AuthenticationType type;
	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AuthenticationType getType() {
		return type;
	}

	public void setType(AuthenticationType type) {
		this.type = type;
	}

}
