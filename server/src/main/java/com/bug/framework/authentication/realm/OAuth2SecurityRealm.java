package com.bug.framework.authentication.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import com.bug.framework.authentication.bean.OAuth2AuthenticationToken;

public class OAuth2SecurityRealm extends AuthorizingRealm {

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		OAuthService service = new ServiceBuilder().provider(GoogleApi.class).apiKey("your_api_key")
				.apiSecret("your_api_secret").build();
				// Token requestToken = service.getRequestToken();
				// String authUrl = service.getAuthorizationUrl(requestToken);

		// OAuthRequest request = new OAuthRequest(Verb.GET,
		// "http://api.twitter.com/1/account/verify_credentials.xml");
		// service.signRequest(accessToken, request); // the access token from
		// step 4
		// Response response = request.send();
		// System.out.println(response.getBody());
		OAuth2AuthenticationToken oAuth = (OAuth2AuthenticationToken) token;

		OAuthRequest request = new OAuthRequest(Verb.GET, (String) oAuth.getPrincipal());
		service.signRequest((Token) token.getCredentials(), request); // the
																		// access
																		// token
																		// from
																		// step
																		// 4
		Response response = request.send();

		return null;
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return token instanceof OAuth2AuthenticationToken;
	}

}
