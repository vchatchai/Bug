package com.bug.framework.authentication.bean;

import org.apache.shiro.authc.AuthenticationToken;

public class OAuth2AuthenticationToken<String> implements AuthenticationToken {

	private String url;
	private String tokenKey;

	@Override
	public String getPrincipal() {
		return url;
	}

	@Override
	public String getCredentials() {
		return tokenKey;
	}

}
