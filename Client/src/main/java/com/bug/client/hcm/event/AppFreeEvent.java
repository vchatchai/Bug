package com.bug.client.hcm.event;

import com.google.gwt.event.shared.GwtEvent;

public class AppFreeEvent extends GwtEvent<AppFreeHandler> {
	private static Type<AppFreeHandler> TYPE = new Type<AppFreeHandler>();

	public AppFreeEvent() {
	}

	/**
	 * Gets the event type associated with load events.
	 * 
	 * @return the handler type
	 */
	public static com.google.gwt.event.shared.GwtEvent.Type<AppFreeHandler> getType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AppFreeHandler handler) {
		handler.onAppFreeEvent(this);
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AppFreeHandler> getAssociatedType() {
		return TYPE;
	}
}
