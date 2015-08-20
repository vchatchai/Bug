package com.bug.client.hcm.view;

import org.fusesource.restygwt.client.MethodCallback;

import com.bug.client.hcm.webservice.AuthenticationResource;
import com.bug.shared.authentication.AuthenticationToken;
import com.bug.shared.hcm.Employee;

public class LoginResourceClientTestImp implements AuthenticationResource {

	public void login(AuthenticationToken authenticationToken, MethodCallback<Employee> callback) { 
	}

}
