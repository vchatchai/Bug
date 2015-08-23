package com.bug.client.hcm.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
//import static org.hamcrest.Matchers.containsString;
import org.mockito.stubbing.Answer;

import com.bug.client.common.factory.MessageFactory;
import com.bug.client.common.webservice.RestProxyClassStandAlone;
import com.bug.client.common.webservice.RestServiceFactory;
import com.bug.client.hcm.factory.LoginClientFactory;
import com.bug.client.hcm.presenter.AuthenticationMessages;
import com.bug.client.hcm.presenter.EmailLoginPresenter;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewTest {
	EventBus eventBus = new SimpleEventBus();
	AuthenticationResource proxy = null;

	// AuthenticationResource loginResourceClient = new
	// LoginResourceClientTestImp();
	EmailLoginView loginViewTest = null;
	LoginClientFactory clientFactory = null;
	EmailLoginPresenter loginPresenter = null;
	AuthenticationMessages authenticationMessages = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		proxy = RestServiceFactory.getRestService(AuthenticationResource.class);
		loginViewTest = Mockito.mock(EmailLoginView.class, Mockito.RETURNS_DEEP_STUBS);
		clientFactory = Mockito.mock(LoginClientFactory.class);
		authenticationMessages = MessageFactory.getMessage(AuthenticationMessages.class);

		loginPresenter = new EmailLoginPresenter(loginViewTest, eventBus, clientFactory);

	}

	@After
	public void tearDown() throws Exception {

		RestProxyClassStandAlone.wait(proxy);
	}

	// @Ignore
	@Test
	public void testLoginByEmail() throws InterruptedException {

		when(loginViewTest.getEmail()).thenReturn("ee56054@gmail.com");
		when(loginViewTest.getPassword()).thenReturn("1234");

		when(clientFactory.getLoginView()).thenReturn(loginViewTest);

		when(clientFactory.getAuthenticationResource()).thenReturn(proxy);

		when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);

		doAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocationOnMock) throws Throwable {
				when(loginViewTest.getNotify()).thenReturn((String) invocationOnMock.getArguments()[0]);
				return null;
			}
		}).when(loginViewTest).setNotify(anyString());

		loginPresenter.login();
		System.out.println("loginViewTest.getNotify:" + loginViewTest.getNotify());

		assertNull(loginViewTest.getNotify());

	}

	// @Ignore
	@Test
	public void testLoginByEmailBlankFail() throws InterruptedException {

		when(loginViewTest.getEmail()).thenReturn("");
		when(loginViewTest.getPassword()).thenReturn("1234");

		when(clientFactory.getLoginView()).thenReturn(loginViewTest);

		when(clientFactory.getAuthenticationResource()).thenReturn(proxy);
		when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);

		doAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocationOnMock) throws Throwable {
				when(loginViewTest.getNotify()).thenReturn((String) invocationOnMock.getArguments()[0]);
				return null;
			}
		}).when(loginViewTest).setNotify(anyString());

		loginPresenter.login();

		System.out.println("loginViewTest.getNotify:" + loginViewTest.getNotify());

		assertEquals(loginViewTest.getNotify(), loginViewTest.getNotify(),
				authenticationMessages.errorEmailEmpty());
		assertNotNull(loginViewTest.getNotify());

	}

	// @Ignore
	@Test
	public void testLoginByEmailWithoutAtSignFail() throws InterruptedException {

		when(loginViewTest.getEmail()).thenReturn("ee56054");
		when(loginViewTest.getPassword()).thenReturn("1234");

		when(clientFactory.getLoginView()).thenReturn(loginViewTest);

		when(clientFactory.getAuthenticationResource()).thenReturn(proxy);
		when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);

		doAnswer(new Answer<String>() {
			public String answer(InvocationOnMock invocationOnMock) throws Throwable {
				when(loginViewTest.getNotify()).thenReturn((String) invocationOnMock.getArguments()[0]);
				return null;
			}
		}).when(loginViewTest).setNotify(anyString());

		loginPresenter.login();

		System.out.println("loginViewTest.getNotify:" + loginViewTest.getNotify());

		assertEquals(loginViewTest.getNotify(), loginViewTest.getNotify(),
				authenticationMessages.errorAtSign(loginViewTest.getEmail()));
		assertNotNull(loginViewTest.getNotify());

	}

}
