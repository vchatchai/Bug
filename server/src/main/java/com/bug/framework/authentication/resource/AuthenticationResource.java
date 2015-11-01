package com.bug.framework.authentication.resource;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.codehaus.jackson.map.ObjectMapper;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bug.framework.authentication.bean.OAuth2AuthenticationToken;
import com.bug.framework.authentication.realm.oauth2.Google2Api;
import com.bug.framework.authentication.realm.oauth2.MyConstants;
import com.bug.module.hcm.service.EmployeeService;
import com.bug.shared.authentication.Token;
import com.bug.shared.hcm.Employee;

@Component
@Path("/authentication")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthenticationResource {

	private EmployeeService employeeService;

	@Autowired
	SecurityManager securityManager;

	public AuthenticationResource() {
	}

	/**
	 * 
	 * @param employeeService
	 */
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@POST
	@Path("/login")
	@Produces("application/json")
	@RequiresGuest
	public Employee login(Token authentication) {
		System.out.println("login created:begin");
		// SecurityUtils.setSecurityManager(securityManager);
		//
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			AuthenticationToken token = null;
			switch (authentication.getType()) {
			case OAUTH2:
				token = new OAuth2AuthenticationToken<String>(authentication.getEmail(), authentication.getPassword());

				break;
			case SIMPLE:
				token = new UsernamePasswordToken(authentication.getEmail(), authentication.getPassword());
				break;

			}

			try {
				currentUser.login(token);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("login created:end");
		// String email, String password
		Employee employee = new Employee();
		employee.setId("35");
		employee.setName("Chatchai");
		employee.setSurname("Vichai");

		return employee;
	}

	@Path("/googleOAuth2Login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@GET
	// @RequiresGuest
	public String googleOAuth2Login() {
		String apiKey = MyConstants.GOOGLE_CLIENT_ID;
		String apiSecret = MyConstants.GOOGLE_CLIENT_SECRET;
		String callbackUrl = MyConstants.GOOGLE_REDIRECT_URL;

		// Create OAuthService for Google OAuth 2.0
		OAuthService service = new ServiceBuilder().provider(Google2Api.class).apiKey(apiKey).apiSecret(apiSecret)
				.callback(callbackUrl).scope(MyConstants.SCOPE).build();

		Verifier verifier = null;

		Token accessToken = null;

		// Obtain the Authorization URL
		// System.out.println("Fetching the Authorization URL...");
		String authorizationUrl = service.getAuthorizationUrl(null);
		// System.out.println("Got the Authorization URL!:" + authorizationUrl);
		// System.out.println("Now go and authorize Scribe here:");
		System.out.println("Result:" + authorizationUrl);

		// URL url = new URL(authorizationUrl);
		// Copy this URL and run in browser.
		// System.out.println(authorizationUrl);

		// JSONString jsonString = new JSONString() {
		//
		// @Override
		// public String toJSONString() {
		// return authorizationUrl;
		// }
		// };

		Response response = Response.status(Status.OK).entity(authorizationUrl).build();
		ObjectMapper mapper = new ObjectMapper();
		try {
			authorizationUrl = mapper.writeValueAsString(authorizationUrl);
			System.out.println("Response response:" + authorizationUrl.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return authorizationUrl;

	}

}
