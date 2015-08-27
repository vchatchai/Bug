package com.bug.client.spider.ui.ui;

import com.bug.client.hcm.presenter.RegisterPresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialTextBox;

public class RegisterView extends Composite implements RegisterPresenter.Display {

	private static RegisterViewUiBinder uiBinder = GWT.create(RegisterViewUiBinder.class);
	
	private RegisterPresenter registerPresente;
	
	interface RegisterViewUiBinder extends UiBinder<Widget, RegisterView> {
	}

	public RegisterView() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	

	@UiField
	MaterialTextBox emailTextBox;

	@UiField
	MaterialTextBox userNameTextBox;

	@UiField
	MaterialTextBox passwordTextBox;

	@UiField
	MaterialCheckBox acceptCheckBox;
	
	@UiField
	MaterialButton registerButton;

	

	@Override
	public void clearWidgets() {
		emailTextBox.setText("");
		userNameTextBox.setText("");
		passwordTextBox.setText("");
		acceptCheckBox.setValue(false);
	}

	@Override
	public void setPresenter(RegisterPresenter registerPresenter) {
		this.registerPresente = registerPresenter;

	}

//	@Override
//	public TextBox getUserNameTextBox() {
//		return userNameTextBox;
//	}
//
//	@Override
//	public TextBox getEmailTextBox() {
//		return emailTextBox;
//	}
//
//	@Override
//	public TextBox getPasswordTextBox() {
//		return passwordTextBox;
//	}
//
//	@Override
//	public Button getRegisterButton() {
//		return registerButton;
//	}

}
