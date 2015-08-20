package com.bug.framework.authentication.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bug.module.hcm.service.EmployeeService;
import com.bug.shared.authentication.AuthenticationToken;
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
	public Employee login(AuthenticationToken authentication) {
		System.out.println("login created:begin");
		// SecurityUtils.setSecurityManager(securityManager);
		//
		Subject currentUser = SecurityUtils.getSubject();

		if (!currentUser.isAuthenticated()) {
			// // collect user principals and credentials in a gui specific
			// manner
			// // such as username/password html form, X509 certificate, OpenID,
			// // etc.
			// // We'll use the username/password example here since it is the
			// most
			// // common.
			// // UsernamePasswordToken token = new
			// // UsernamePasswordToken("lonestarr", "vespa");
			UsernamePasswordToken token = new UsernamePasswordToken(authentication.getEmail(),
					authentication.getPassword());
			//
			// // this is all you have to do to support 'remember me' (no config
			// -
			// // built in!):
			// token.setRememberMe(true);
			//
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

}
