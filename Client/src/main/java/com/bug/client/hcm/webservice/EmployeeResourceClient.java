package com.bug.client.hcm.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.bug.client.common.anotation.SpringComponentResourceName;
import com.bug.shared.hcm.Employee;

@SpringComponentResourceName("employeeResource")
@Path("/Employee")
public interface EmployeeResourceClient extends RestService {

	@Path("/create")
	@GET
	public void createEmployee(MethodCallback<Employee> callback);

}