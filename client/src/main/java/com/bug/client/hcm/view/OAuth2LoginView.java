package com.bug.client.hcm.view;

import com.google.gwt.user.client.ui.Widget;

public interface OAuth2LoginView {

	public void setNotify(String notify);

	public String getNotify();

	public void redirectLogin(String response);

	public String getTokenKey();

	public interface LoginPresenter {
		public void getURLLogin();
		public void login();

	}

	Widget asWidget();


}
