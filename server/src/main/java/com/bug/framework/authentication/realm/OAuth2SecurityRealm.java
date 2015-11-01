package com.bug.framework.authentication.realm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.GoogleApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

import com.bug.framework.authentication.bean.OAuth2AuthenticationToken;
import com.bug.framework.authentication.realm.oauth2.Google2Api;
import com.bug.framework.authentication.realm.oauth2.MyConstants;

public class OAuth2SecurityRealm extends AuthorizingRealm {

	private static final String NETWORK_NAME = "Google";

	private static final String PROTECTED_RESOURCE_URL = "https://www.googleapis.com/oauth2/v2/userinfo?alt=json";

	private static final String SCOPE = "https://mail.google.com/ https://www.googleapis.com/auth/userinfo.email";

	private static final Token EMPTY_TOKEN = null;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		Set<String> roles = new HashSet<>();
		Set<Permission> permissions = new HashSet<>();
		// Collection principalsList = principals.byType(User.class);
		// for (User user : principalsList) {
		// for (Role role : user.getRoles()) {
		// roles.add(role.getName());
		// for (Iterator iterator = role.getPermissions().iterator();
		// iterator.hasNext(); ) {
		// Permission permission = iterator.next();
		// permissions.add(new WildcardPermission(permission.name()));
		// }
		// }
		// }
		Permission permission = new WildcardPermission("employee:create");

		permissions.add(permission);
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
		info.setRoles(roles);
		info.setObjectPermissions(permissions);
		setAuthenticationCachingEnabled(false);
		setCachingEnabled(false);
		// setCacheManager( );
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String apiKey = MyConstants.GOOGLE_CLIENT_ID;
		String apiSecret = MyConstants.GOOGLE_CLIENT_SECRET;
		String callbackUrl = MyConstants.GOOGLE_REDIRECT_URL;

//		OAuth2AuthenticationToken<String> auth2AuthenticationToken = (OAuth2AuthenticationToken) token;

		// Create OAuthService for Google OAuth 2.0
		OAuthService service = new ServiceBuilder().provider(Google2Api.class).apiKey(apiKey).apiSecret(apiSecret)
				.callback(callbackUrl).scope(SCOPE).build();

		Verifier verifier = null;

		Token accessToken = null;

		// Obtain the Authorization URL
		System.out.println("Fetching the Authorization URL...");
		String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
		System.out.println("Got the Authorization URL!");
		System.out.println("Now go and authorize Scribe here:");
		System.out.println();

		// Copy this URL and run in browser.
		System.out.println(authorizationUrl);
		System.out.println();

		// Copy Authorization Code in browser URL and paste to Console
		System.out.println("And paste the authorization code here");
		System.out.print(">>");
		verifier = new Verifier((String) token.getCredentials());
		System.out.println();

		// Trade the Request Token and Verfier for the Access Token
		System.out.println("Trading the Request Token for an Access Token...");
		accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
		System.out.println("Got the Access Token!");
		System.out.println("(if your curious it looks like this: " + accessToken + " )");
		System.out.println();

		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
		service.signRequest(accessToken, request);

		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(token.getPrincipal(),
				token.getCredentials(), "OAuth2AuthenticationToken");

		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getCode());
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());

		System.out.println();
		System.out.println("Thats it man! Go and build something awesome with Scribe! :)");

		return authenticationInfo;
	}

	@Override
	public boolean supports(AuthenticationToken token) {
		// TODO Auto-generated method stub
		return token instanceof OAuth2AuthenticationToken;
	}

}
