package com.bug.client.hcm.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.bug.client.common.anotation.SpringComponentResourceName;
import com.bug.shared.authentication.AuthenticationToken;
import com.bug.shared.hcm.Employee;

@SpringComponentResourceName("authenticationResource")
@Path("/authentication")
public interface AuthenticationResource extends RestService {

	@Path("/login")
	@POST
	public void login(AuthenticationToken authenticationToken, MethodCallback<Employee> callback);

}