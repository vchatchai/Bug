package com.bug.client.spider.ui;

import com.bug.client.hcm.factory.LoginClientFactory;
import com.bug.client.hcm.presenter.AuthenticationMessages;
import com.bug.client.hcm.view.EmailLoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.bug.client.spider.ui.ui.MaterialLogin;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements LoginClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	private static final EmailLoginView loginView = new MaterialLogin();
	private static final AuthenticationResource AUTHENTICATION_RESOURCE = GWT.create(AuthenticationResource.class);
	private static final AuthenticationMessages AUTHENTICATION_MESSAGES = GWT.create(AuthenticationMessages.class);

	public ClientFactoryImpl() {

	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public EmailLoginView getLoginView() {
		return loginView;
	}

	@Override
	public PlaceController getPlaceController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthenticationResource getAuthenticationResource() {
		return AUTHENTICATION_RESOURCE;
	}

	@Override
	public AuthenticationMessages getAuthenticationMessages() {
		return AUTHENTICATION_MESSAGES;
	}

}
