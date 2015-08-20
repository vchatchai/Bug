/**
 * 
 */
package com.bug.module.hcm.resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.bug.AppMain;
import com.bug.shared.hcm.Employee;

/**
 * @author chatchai
 *
 */
public class EmployeeResourceTest {

	// static final String ROOT_URL = "http://localhost:8080/bug/rest/";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}
 
	@Test
	public void test() {

		Employee employee = new Employee();
		// ClientRequest request = new ClientRequest(ROOT_URL + "users/");
		// request.body("application/xml", user);
		// ClientResponse<String> response = request.post(String.class);
		// String statusXML = response.getEntity();
		// Assert.assertNotNull(statusXML);
		//

		// Response respnose =
		// ClientBuilder.newClient().target(ROOT_URL).request().get();
		System.out.println("START");

		// // 1.
		// Factory<org.apache.shiro.mgt.SecurityManager> factory = new
		// IniSecurityManagerFactory("classpath:com/bug/config/shiro.ini");
		DefaultSecurityManager securityManager = AppMain.getApplicationContext().getBean(DefaultSecurityManager.class);
		//
		// // 2.
		// SecurityManager securityManager = factory.getInstance();
		//
		// // 3.
		SecurityUtils.setSecurityManager(securityManager);

		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			// collect user principals and credentials in a gui specific manner
			// such as username/password html form, X509 certificate, OpenID,
			// etc.
			// We'll use the username/password example here since it is the most
			// common.
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");

			// this is all you have to do to support 'remember me' (no config -
			// built in!):
			token.setRememberMe(true);

			currentUser.login(token); 
		}

		System.out.println("IsAuthentication:" + currentUser.isAuthenticated());

		EmployeeResource employeeResource = (EmployeeResource) AppMain.getApplicationContext()
				.getBean("employeeResource");
		Employee e = employeeResource.createEmployee();

		System.out.println("EMPLOYEE:" + e);

	}

}
