package com.bug.framework.authentication;

import org.junit.Test;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class OAuth2SecurityRealmTest {
 
	public void googleoAuth2() {
		OAuthService service = new ServiceBuilder().provider(GoogleApi.class)
				.apiKey("770699764391-6gcvcm36h5sq2deqd7o2ngeq7lc6b5le.apps.googleusercontent.com")
				.apiSecret("hRniC5S-dsM7F1NkteWSfz5e").build();
		// Token requestToken = service.getRequestToken();
		// String authUrl = service.getAuthorizationUrl(requestToken);

		Token requestToken = service.getRequestToken();

		String authUrl = service.getAuthorizationUrl(requestToken);

		
		
		
		Verifier v = new Verifier("verifier you got from the user");
		Token accessToken = service.getAccessToken(requestToken, v); // the
																		// requestToken
																		// you
		OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.twitter.com/1/account/verify_credentials.xml");
		service.signRequest(accessToken, request); // the access token from step
													// 4
		Response response = request.send();
		System.out.println(response.getBody()); // had
												// from
												// step
												// 2

		// OAuthRequest request = new OAuthRequest(Verb.GET,
		// "http://api.twitter.com/1/account/verify_credentials.xml");
		// service.signRequest(accessToken, request); // the access token from
		// step 4
		// Response response = request.send();
		// System.out.println(response.getBody());
		// OAuth2AuthenticationToken oAuth = (OAuth2AuthenticationToken) token;

		// OAuthRequest request = new OAuthRequest(Verb.GET, "Test");
		// service.signRequest((Token) token.getCredentials(), request); // the
		// // access
		// // token
		// // from
		// // step
		// // 4
		// Response response = request.send();

	}

}
