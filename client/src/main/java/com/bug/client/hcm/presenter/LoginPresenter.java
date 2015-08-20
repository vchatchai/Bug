package com.bug.client.hcm.presenter;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.bug.client.hcm.event.AppFreeEvent;
import com.bug.client.hcm.event.AppFreeHandler;
import com.bug.client.hcm.view.LoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
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

		loginResourceClient.login(loginView.getEmail(), loginView.getPassword(), new MethodCallback<Employee>() {

			public void onSuccess(Method method, Employee response) {
				loginView.setNotify(response.getName());

				System.out.println("Method Client:" + response.getName());
			}

			public void onFailure(Method method, Throwable exception) {
				loginView.setNotify(exception.getMessage());

				System.out.println("Method Client:" + exception.getMessage());
			}
		});

		eventBus.fireEvent(new AppFreeEvent());

	}

}
