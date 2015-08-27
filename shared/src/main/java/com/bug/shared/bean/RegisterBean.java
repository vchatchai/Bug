package com.bug.shared.bean;

import java.io.Serializable;

public class RegisterBean implements  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	private String email;
	private boolean accertCheck =false;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAccertCheck() {
		return accertCheck;
	}
	public void setAccertCheck(boolean accertCheck) {
		this.accertCheck = accertCheck;
	}

}
