package com.bug.module.hcm.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bug.module.hcm.service.EmployeeService;
import com.bug.shared.hcm.Employee;

@Component
@Path("/Employee")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EmployeeResource {

	int count = 1;

	private EmployeeService employeeService;

	public EmployeeResource() {
		count = count + 1;
	}

	/**
	 * 
	 * @param employeeService
	 */
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GET
	@Path("create")
	@Produces("application/json")
	@RequiresPermissions(value = { "employee:create" })
	public Employee createEmployee() {
		System.out.println("employee created1");

		Employee employee = employeeService.getEmployee("35");
		
		
		return employee;

	}

}
