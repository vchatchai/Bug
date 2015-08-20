package com.bug.client.spider.ui;

import com.bug.client.hcm.factory.LoginClientFactory;
import com.bug.client.hcm.view.LoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.bug.client.spider.ui.ui.MaterialLogin;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements LoginClientFactory {
	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(eventBus);
	// private static final HelloView helloView = new HelloViewImpl();
	// private static final GoodbyeView goodbyeView = new MaterialLogin();
	private static final LoginView loginView = new MaterialLogin();
	private static final AuthenticationResource loginResource = GWT.create(AuthenticationResource.class);

	public ClientFactoryImpl() {

	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public LoginView getLoginView() {
		return loginView;
	}

	@Override
	public PlaceController getPlaceController() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AuthenticationResource getAuthenticationResource() {
		return loginResource;
	}

}
