package com.bug.client.hcm.presenter;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.bug.client.hcm.factory.OAuth2LoginClientFactory;
import com.bug.client.hcm.view.OAuth2LoginView;
import com.bug.shared.authentication.AuthenticationType;
import com.bug.shared.authentication.Token;
import com.bug.shared.hcm.Employee;
//import com.google.gwt.thirdparty.guava.common.eventbus.EventBus;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.web.bindery.event.shared.EventBus;

public class OAuth2LoginPresenter implements Presenter, OAuth2LoginView.LoginPresenter {

	private OAuth2LoginView loginView;
	private EventBus eventBus;
	private OAuth2LoginClientFactory loginResourceFactory;

	public OAuth2LoginPresenter(OAuth2LoginView loginView, EventBus eventBus,
			OAuth2LoginClientFactory loginResourceFactory) {
		super();
		this.loginView = loginView;
		this.eventBus = eventBus;
		this.loginResourceFactory = loginResourceFactory;

		bind();
	}

	private void bind() {

	}

	public void go(HasWidgets container) {
		container.clear();
		container.add(loginView.asWidget());

	}

	public void getURLLogin() {

		loginView.setNotify("getURLLogin");
		loginResourceFactory.getAuthenticationResource().googleOAuth2Login(new MethodCallback<String>() {

			public void onSuccess(Method method, String response) {
				// Window.alert(response);
				 loginView.redirectLogin(response);
//				loginView.setNotify("onSuccess"+response);
				
			}

			public void onFailure(Method method, Throwable exception) {

				// Window.alert(exception.toString());
				loginView.setNotify("onFailure"+exception.getMessage());
			}
		});
	}

	public void login() {

		String key = loginView.getTokenKey();

		System.out.println("KEY::::" + key);

		Token authenticationToken = new Token();
		authenticationToken.setType(AuthenticationType.OAUTH2);

		final AuthenticationMessages authenticationMessages = loginResourceFactory.getAuthenticationMessages();

		loginResourceFactory.getAuthenticationResource().login(authenticationToken, new MethodCallback<Employee>() {

			public void onSuccess(Method method, Employee response) {

				loginView.setNotify(authenticationMessages.errorUserPasswordFail() + response.getName());

			}

			public void onFailure(Method method, Throwable exception) {
				loginView.setNotify(authenticationMessages.errorUserPasswordFail());

			}
		});

	}

}
