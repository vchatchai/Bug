package com.bug.client.client;


import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialToast;

public class MaterialLogin extends Composite {

	private static MaterialLoginUiBinder uiBinder = GWT.create(MaterialLoginUiBinder.class);
	
	private HelloClient helloClient = GWT.create(HelloClient.class);

	interface MaterialLoginUiBinder extends UiBinder<Widget, MaterialLogin> {
	}

	public MaterialLogin() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnLogin")
	void onLogin(ClickEvent e){
//		RootPanel.getBodyElement().addClassName("white");
//		RootPanel.get().clear();
		
		helloClient.getHellos(new  MethodCallback<List<String>>() {
			
			@Override
			public void onSuccess(Method method, List<String> response) {
				// TODO Auto-generated method stub
				MaterialToast.alert("Success");
			}
			
			@Override
			public void onFailure(Method method, Throwable exception) {
				// TODO Auto-generated method stub
				MaterialToast.alert("Failure");
				
			}
		});
		
		
	 
	}
	
}
