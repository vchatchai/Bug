package com.bug.client.hcm.view;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.bug.client.common.factory.MessageFactory;
import com.bug.client.common.webservice.RestProxyClassStandAlone;
import com.bug.client.common.webservice.RestServiceFactory;
import com.bug.client.hcm.factory.OAuth2LoginClientFactory;
import com.bug.client.hcm.presenter.AuthenticationMessages;
import com.bug.client.hcm.presenter.OAuth2LoginPresenter;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class OAuth2LoginViewTest {
	EventBus eventBus = new SimpleEventBus();
	AuthenticationResource proxy = null;

	// AuthenticationResource loginResourceClient = new
	// LoginResourceClientTestImp();
	OAuth2LoginView loginViewTest = Mockito.mock(OAuth2LoginView.class);
	OAuth2LoginClientFactory clientFactory = null;
	OAuth2LoginPresenter loginPresenter = null;
	AuthenticationMessages authenticationMessages = null;
	String loginURL = "https://accounts.google.com/o/oauth2/auth?response_type=code&client_id=770699764391-6gcvcm36h5sq2deqd7o2ngeq7lc6b5le.apps.googleusercontent.com&redirect_uri=http%3A%2F%2F127.0.0.1%3A8888%2Fweb.html&scope=https%3A%2F%2Fmail.google.com%2F%20https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		proxy = RestServiceFactory.getRestService(AuthenticationResource.class);
		loginViewTest = Mockito.mock(OAuth2LoginView.class, Mockito.RETURNS_DEEP_STUBS);
		clientFactory = Mockito.mock(OAuth2LoginClientFactory.class);
		authenticationMessages = MessageFactory.getMessage(AuthenticationMessages.class);

		when(clientFactory.getLoginView()).thenReturn(loginViewTest);

		when(clientFactory.getAuthenticationResource()).thenReturn(proxy);

		when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);
		loginPresenter = new OAuth2LoginPresenter(loginViewTest, eventBus, clientFactory);
	}

	@After
	public void tearDown() throws Exception {

		RestProxyClassStandAlone.wait(proxy);
	}

	@Test
	public void test() {

		doAnswer(new Answer<String>() {

			public String answer(InvocationOnMock invocation) throws Throwable {
				String url = invocation.getArgumentAt(0, String.class);
				// System.out.println("URL:" + url);
				assertNull(url);
				assertNotEquals(loginURL, url);
				when(loginViewTest.getTokenKey()).thenReturn(url);
				loginPresenter.login();
				return null;
			}
		}).when(loginViewTest).redirectLogin(anyString());
		doAnswer(new Answer<String>() {

			public String answer(InvocationOnMock invocation) throws Throwable {
				String url = invocation.getArgumentAt(0, String.class);
				System.out.println("Notify:" + url);
				assertNotNull(url);
				when(loginViewTest.getNotify()).thenReturn(url);
				return null;
			}
		}).when(loginViewTest).setNotify(anyString());

		loginPresenter.getURLLogin();

		System.out.println("FINISH");
	}

}
