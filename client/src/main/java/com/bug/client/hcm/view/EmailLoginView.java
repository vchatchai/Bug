package com.bug.client.hcm.view;

import com.google.gwt.user.client.ui.Widget;

public interface EmailLoginView {
	public String getEmail();

	public String getPassword();

	public void setNotify(String notify);

	public String getNotify();

	public interface LoginPresenter {
		public void login();

	}

	Widget asWidget();
}
