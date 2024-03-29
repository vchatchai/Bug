package com.bug.client.hcm.factory;

import com.bug.client.hcm.presenter.AuthenticationMessages;
import com.bug.client.hcm.view.EmailLoginView;
import com.bug.client.hcm.view.OAuth2LoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface OAuth2LoginClientFactory {
	EventBus getEventBus();

	OAuth2LoginView getLoginView();

	AuthenticationResource getAuthenticationResource();

	AuthenticationMessages getAuthenticationMessages();

	PlaceController getPlaceController();
}
