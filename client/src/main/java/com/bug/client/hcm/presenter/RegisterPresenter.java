package com.bug.client.hcm.presenter;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;

public class RegisterPresenter implements Presenter {

	private EventBus eventBus;
	private Display view;

	public interface Display {
		public void clearWidgets();

		public void setPresenter(RegisterPresenter registerPresenter);

//		public TextBox getUserNameTextBox();
//
//		public TextBox getEmailTextBox();
//
//		public TextBox getPasswordTextBox();
//		
//		public Button getRegisterButton();

		public Widget asWidget();
		
		

	}

	public RegisterPresenter(EventBus eventBus, Display view) {
		this.eventBus = eventBus;
		this.view = view;
		view.clearWidgets();
		view.setPresenter(this);
	}

	

	public void go(HasWidgets container) {
		container.add(view.asWidget());
	}

}
