package com.bug.client.spider.ui;

import com.bug.client.hcm.factory.OAuth2LoginClientFactory;
import com.bug.client.hcm.presenter.AuthenticationMessages;
import com.bug.client.hcm.view.EmailLoginView;
import com.bug.client.hcm.view.OAuth2LoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.bug.client.spider.ui.ui.MaterialLogin;
import com.bug.client.spider.ui.ui.OAuth2Login;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class OAuth2LoginClientFactoryImpl implements OAuth2LoginClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final OAuth2LoginView loginView = new OAuth2Login();
	private static final AuthenticationResource AUTHENTICATION_RESOURCE = GWT.create(AuthenticationResource.class);
	private static final AuthenticationMessages AUTHENTICATION_MESSAGES = GWT.create(AuthenticationMessages.class);

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public OAuth2LoginView getLoginView() {
		// TODO Auto-generated method stub
		return loginView;
	}

	@Override
	public AuthenticationResource getAuthenticationResource() {
		// TODO Auto-generated method stub
		return AUTHENTICATION_RESOURCE;
	}

	@Override
	public AuthenticationMessages getAuthenticationMessages() {
		// TODO Auto-generated method stub
		return AUTHENTICATION_MESSAGES;
	}

	@Override
	public PlaceController getPlaceController() {
		// TODO Auto-generated method stub
		return null;
	}

}
