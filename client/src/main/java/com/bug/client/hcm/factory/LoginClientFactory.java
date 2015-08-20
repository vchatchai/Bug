package com.bug.client.hcm.factory;

import com.bug.client.hcm.view.EmailLoginView;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

public interface LoginClientFactory {
	EventBus getEventBus();

	EmailLoginView getLoginView();

	AuthenticationResource getAuthenticationResource();
 

	PlaceController getPlaceController();
}
