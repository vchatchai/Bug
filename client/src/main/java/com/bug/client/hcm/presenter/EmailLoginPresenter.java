package com.bug.client.hcm.presenter;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.bug.client.hcm.event.AppFreeEvent;
import com.bug.client.hcm.event.AppFreeHandler;
import com.bug.client.hcm.factory.LoginClientFactory;
import com.bug.client.hcm.view.EmailLoginView;
import com.bug.shared.authentication.AuthenticationToken;
import com.bug.shared.hcm.Employee;
//import com.google.gwt.thirdparty.guava.common.eventbus.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;

public class EmailLoginPresenter implements Presenter, EmailLoginView.LoginPresenter {

	private EmailLoginView loginView;
	private EventBus eventBus;
	private LoginClientFactory loginResourceFactory;

	public EmailLoginPresenter(EmailLoginView loginView, EventBus eventBus, LoginClientFactory loginResourceFactory) {
		super();
		this.loginView = loginView;
		this.eventBus = eventBus;
		this.loginResourceFactory = loginResourceFactory;

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

		AuthenticationToken authenticationToken = new AuthenticationToken();
		authenticationToken.setEmail(loginView.getEmail());
		authenticationToken.setPassword(loginView.getPassword());

		final AuthenticationMessages authenticationMessages = loginResourceFactory.getAuthenticationMessages();

		String email = loginView.getEmail();
		if (email == null || email.isEmpty()) {
			loginView.setNotify(authenticationMessages.errorEmailEmpty());
		} else if (!email.contains("@")) {
			loginView.setNotify(loginResourceFactory.getAuthenticationMessages().errorAtSign(loginView.getEmail()));
		} else {

			loginResourceFactory.getAuthenticationResource().login(authenticationToken, new MethodCallback<Employee>() {

				public void onSuccess(Method method, Employee response) {

				}

				public void onFailure(Method method, Throwable exception) {
					loginView.setNotify(authenticationMessages.errorUserPasswordFail() + exception.getMessage());

				}
			});
		}

		eventBus.fireEvent(new AppFreeEvent());

	}

}
