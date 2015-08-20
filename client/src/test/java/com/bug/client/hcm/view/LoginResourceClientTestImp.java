package com.bug.client.hcm.view;

import org.fusesource.restygwt.client.MethodCallback;

import com.bug.client.hcm.webservice.AuthenticationResource;
import com.bug.shared.hcm.Employee;

public class LoginResourceClientTestImp implements AuthenticationResource {

	public void login(String email, String password, MethodCallback<Employee> callback) {
		// TODO Auto-generated method stub
		System.out.println("TEst");

	}

}
