package com.bug.client.spider.ui;

import org.fusesource.restygwt.client.Defaults;

import com.bug.client.hcm.factory.LoginClientFactory;
import com.bug.client.hcm.presenter.LoginPresenter;
import com.bug.client.spider.ui.ui.MaterialLogin;
import com.google.api.gwt.oauth2.client.Auth;
import com.google.api.gwt.oauth2.client.AuthRequest;
import com.google.gwt.core.client.Callback;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import gwt.material.design.client.ui.MaterialToast;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class web implements EntryPoint {

	private LoginClientFactory clientFactory = new ClientFactoryImpl();
	private MaterialLogin loginView = null;
	private LoginPresenter loginPresenter = null;
	EventBus eventBus = new SimpleEventBus();

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		final AuthRequest req = new AuthRequest(GOOGLE_AUTH_URL, GOOGLE_CLIENT_ID).withScopes(PLUS_ME_SCOPE);

		// Calling login() will display a popup to the user the first
		// time it is
		// called. Once the user has granted access to the application,
		// subsequent calls to login() will not display the popup, and
		// will
		// immediately result in the callback being given the token to
		// use.
		Auth.get().login(req, new Callback<String, Throwable>() {
			@Override
			public void onSuccess(String token) {
				MaterialToast.alert("Success");
			}

			@Override
			public void onFailure(Throwable caught) {
				MaterialToast.alert("onFailure");
			}
		});
		Defaults.setServiceRoot(GWT.getModuleBaseURL().replace("web", "rest"));
		loginView = (MaterialLogin) clientFactory.getLoginView();

		loginPresenter = new LoginPresenter(loginView, eventBus, clientFactory.getLoginResourceClient());
		loginView.setLoginPresenter(loginPresenter);

		loginPresenter.go(RootPanel.get());
	}

	private static final String GOOGLE_AUTH_URL = "https://accounts.google.com/o/oauth2/auth";

	// This app's personal client ID assigned by the Google APIs Console
	// (http://code.google.com/apis/console).
	private static final String GOOGLE_CLIENT_ID = "770699764391-6gcvcm36h5sq2deqd7o2ngeq7lc6b5le.apps.googleusercontent.com";

	// The auth scope being requested. This scope will allow the application to
	// identify who the authenticated user is.
	private static final String PLUS_ME_SCOPE = "https://www.googleapis.com/auth/plus.me";

	// Adds a button to the page that asks for authentication from Google.
	// private void addGoogleAuth() {
	// // Since the auth flow requires opening a popup window, it must be
	// // started
	// // as a direct result of a user action, such as clicking a button or
	// // link.
	// // Otherwise, a browser's popup blocker may block the popup.
	// Button button = new Button("Authenticate with Google");
	// button.addClickHandler(new ClickHandler() {
	// @Override
	// public void onClick(ClickEvent event) {
	// final AuthRequest req = new AuthRequest(GOOGLE_AUTH_URL,
	// GOOGLE_CLIENT_ID).withScopes(PLUS_ME_SCOPE);
	//
	// // Calling login() will display a popup to the user the first
	// // time it is
	// // called. Once the user has granted access to the application,
	// // subsequent calls to login() will not display the popup, and
	// // will
	// // immediately result in the callback being given the token to
	// // use.
	// AUTH.login(req, new Callback<String, Throwable>() {
	// @Override
	// public void onSuccess(String token) {
	// Window.alert("Got an OAuth token:\n" + token + "\n" + "Token expires in "
	// + AUTH.expiresIn(req)
	// + " ms\n");
	// }
	//
	// @Override
	// public void onFailure(Throwable caught) {
	// Window.alert("Error:\n" + caught.getMessage());
	// }
	// });
	// }
	// });
	// RootPanel.get().add(button);
	// }

	public void ActivityAndPlace() {
		// Create ClientFactory using deferred binding so we can replace with
		// different
		// impls in gwt.xml
		// ClientFactory clientFactory = GWT.create(ClientFactory.class);
		// EventBus eventBus = clientFactory.getEventBus();
		// PlaceController placeController = clientFactory.getPlaceController();
		//
		// // Start ActivityManager for the main widget with our ActivityMapper
		// ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
		// ActivityManager activityManager = new ActivityManager(activityMapper,
		// eventBus);
		// activityManager.setDisplay(appWidget);
		//
		// // Start PlaceHistoryHandler with our PlaceHistoryMapper
		// AppPlaceHistoryMapper historyMapper =
		// GWT.create(AppPlaceHistoryMapper.class);
		// PlaceHistoryHandler historyHandler = new
		// PlaceHistoryHandler(historyMapper);
		// historyHandler.register(placeController, eventBus, defaultPlace);
		//
		// RootPanel.get().add(appWidget);
		// // Goes to place represented on URL or default place
		// historyHandler.handleCurrentHistory();
	}
}

// /**
// * The message displayed to the user when the server cannot be reached or
// * returns an error.
// */
// private static final String SERVER_ERROR = "An error occurred while "
// + "attempting to contact the server. Please check your network "
// + "connection and try again.";
//
// /**
// * Create a remote service proxy to talk to the server-side Greeting service.
// */
//// private final GreetingServiceAsync greetingService =
// GWT.create(GreetingService.class);
//
//// private final Messages messages = GWT.create(Messages.class);
//
// /**
// * This is the entry point method.
// */
// public void onModuleLoad() {
// Defaults.setServiceRoot(GWT.getModuleBaseURL().replace("web", "rest"));
//
//
// MaterialLogin materialLogin = new MaterialLogin();
//
//// RootPanel.get("nameFieldContainer").add(materialLogin);
//
// RootPanel.get().add(materialLogin);
//
//
//
//
//
//
// }

// public void slashScreen(){
// MaterialSplashScreen splash = new MaterialSplashScreen();
// splash.setSplashTime(1000);
//// splash.setMain();
// splash.setLogo(MaterialResources.INSTANCE.ic_progress_cancel());
// splash.setAppName("gwt-material");
// splash.setAppDescription("Material Design Look and Feel for GWT Apps");
// splash.setColor("blue");
// splash.setTextColor("white");
// splash.show();
// }

// public void original(){
// final Button sendButton = new Button( messages.sendButton() );
// final TextBox nameField = new TextBox();
// nameField.setText( messages.nameField() );
// final Label errorLabel = new Label();
//
// // We can add style names to widgets
// sendButton.addStyleName("sendButton");
//
// // Add the nameField and sendButton to the RootPanel
// // Use RootPanel.get() to get the entire body element
// RootPanel.get("nameFieldContainer").add(nameField);
// RootPanel.get("sendButtonContainer").add(sendButton);
// RootPanel.get("errorLabelContainer").add(errorLabel);
//
// // Focus the cursor on the name field when the app loads
// nameField.setFocus(true);
// nameField.selectAll();
//
// // Create the popup dialog box
// final DialogBox dialogBox = new DialogBox();
// dialogBox.setText("Remote Procedure Call");
// dialogBox.setAnimationEnabled(true);
// final Button closeButton = new Button("Close");
// // We can set the id of a widget by accessing its Element
// closeButton.getElement().setId("closeButton");
// final Label textToServerLabel = new Label();
// final HTML serverResponseLabel = new HTML();
// VerticalPanel dialogVPanel = new VerticalPanel();
// dialogVPanel.addStyleName("dialogVPanel");
// dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
// dialogVPanel.add(textToServerLabel);
// dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
// dialogVPanel.add(serverResponseLabel);
// dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
// dialogVPanel.add(closeButton);
// dialogBox.setWidget(dialogVPanel);
//
// // Add a handler to close the DialogBox
// closeButton.addClickHandler(new ClickHandler() {
// public void onClick(ClickEvent event) {
// dialogBox.hide();
// sendButton.setEnabled(true);
// sendButton.setFocus(true);
// }
// });
//
// // Create a handler for the sendButton and nameField
// class MyHandler implements ClickHandler, KeyUpHandler {
// /**
// * Fired when the user clicks on the sendButton.
// */
// public void onClick(ClickEvent event) {
// sendNameToServer();
// }
//
// /**
// * Fired when the user types in the nameField.
// */
// public void onKeyUp(KeyUpEvent event) {
// if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
// sendNameToServer();
// }
// }
//
// /**
// * Send the name from the nameField to the server and wait for a response.
// */
// private void sendNameToServer() {
// // First, we validate the input.
// errorLabel.setText("");
// String textToServer = nameField.getText();
//// if (!FieldVerifier.isValidName(textToServer)) {
//// errorLabel.setText("Please enter at least four characters");
//// return;
//// }
//
// // Then, we send the input to the server.
// sendButton.setEnabled(false);
// textToServerLabel.setText(textToServer);
// serverResponseLabel.setText("");
//// greetin3gService.greetServer(textToServer, new AsyncCallback<String>() {
//// public void onFailure(Throwable caught) {
//// // Show the RPC error message to the user
//// dialogBox.setText("Remote Procedure Call - Failure");
//// serverResponseLabel.addStyleName("serverResponseLabelError");
//// serverResponseLabel.setHTML(SERVER_ERROR);
//// dialogBox.center();
//// closeButton.setFocus(true);
//// }
////
//// public void onSuccess(String result) {
//// dialogBox.setText("Remote Procedure Call");
//// serverResponseLabel.removeStyleName("serverResponseLabelError");
//// serverResponseLabel.setHTML(result);
//// dialogBox.center();
//// closeButton.setFocus(true);
//// }
//// });
// }
// }
//
// // Add a handler to send the name to the server
// MyHandler handler = new MyHandler();
// sendButton.addClickHandler(handler);
// nameField.addKeyUpHandler(handler);
// }
// }
