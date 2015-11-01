package com.bug.framework.authentication.bean;

import org.apache.shiro.authc.AuthenticationToken;

public class OAuth2AuthenticationToken<String> implements AuthenticationToken {

	private String email;
	private String tokenKey;
	
	

	public OAuth2AuthenticationToken(String email, String tokenKey) {
		super();
		this.email = email;
		this.tokenKey = tokenKey;
	}

	@Override
	public String getPrincipal() {
		return email;
	}

	@Override
	public String getCredentials() {
		return tokenKey;
	}

}
