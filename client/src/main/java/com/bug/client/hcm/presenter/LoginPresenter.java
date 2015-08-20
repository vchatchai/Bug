package com.bug.client.hcm.presenter;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.login;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.bug.client.hcm.event.AppFreeEvent;
import com.bug.client.hcm.event.AppFreeHandler;
import com.bug.client.hcm.view.LoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.bug.shared.authentication.AuthenticationToken;
import com.bug.shared.hcm.Employee;
//import com.google.gwt.thirdparty.guava.common.eventbus.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;

public class LoginPresenter implements Presenter, LoginView.LoginPresenter {

	private LoginView loginView;
	private EventBus eventBus;
	private AuthenticationResource loginResourceClient;

	public LoginPresenter(LoginView loginView, EventBus eventBus, AuthenticationResource loginResourceClient) {
		super();
		this.loginView = loginView;
		this.eventBus = eventBus;
		this.loginResourceClient = loginResourceClient;

		bind();
	}

	private void bind() {
		eventBus.addHandler(AppFreeEvent.getType(), new AppFreeHandler() {

			public void onAppFreeEvent(AppFreeEvent event) {
				System.out.println("AppFreeHandler:" + loginView.getEmail());

			}
		});

	}

	public void go(HasWidgets container) {
		container.clear();
		container.add(loginView.asWidget());

	}

	public void login() {
		loginView.setNotify("Login");

		AuthenticationToken authenticationToken = new AuthenticationToken();
		authenticationToken.setEmail(loginView.getEmail());
		authenticationToken.setPassword(loginView.getPassword());
		loginResourceClient.login(authenticationToken, new MethodCallback<Employee>() {

			public void onSuccess(Method method, Employee response) {
				loginView.setNotify(response.getName());

			}

			public void onFailure(Method method, Throwable exception) {
				loginView.setNotify(exception.getMessage());

			}
		});

		eventBus.fireEvent(new AppFreeEvent());

	}

}
