package com.bug.framework.authentication.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
//	@RequiresGuest
	public Employee login(AuthenticationToken authentication) {
		System.out.println("employee created1");
//		String email, String password 
		Employee employee = new Employee();
		employee.setId("35");
		employee.setName("Chatchai");
		employee.setSurname("Vichai");

		return employee;
	}

}
