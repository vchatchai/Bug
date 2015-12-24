package com.bug.client.hcm.view;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.Label;

//@RunWith(MockitoJUnitRunner.class)
public class LoginViewTestGwt extends GWTTestCase {

	@Override
	public String getModuleName() {
		// com.bug.client.spider.ui.web
		return "com.bug.client.spider.web";
	}

	public void testUpperCasingLabel() {
		Label upperCasingLabel = new Label();

		upperCasingLabel.setText("foo");
		assertEquals("FOO", upperCasingLabel.getText());

		upperCasingLabel.setText("BAR");
		assertEquals("BAR", upperCasingLabel.getText());

		upperCasingLabel.setText("BaZ");
		assertEquals("BAZ", upperCasingLabel.getText());

		System.out.println("finished");
	}

	// EventBus eventBus = new SimpleEventBus();
	// AuthenticationResource proxy = null;
	//
	// // AuthenticationResource loginResourceClient = new
	// // LoginResourceClientTestImp();
	// EmailLoginView loginViewTest = null;
	// LoginClientFactory clientFactory = null;
	// EmailLoginPresenter loginPresenter = null;
	// AuthenticationMessages authenticationMessages = null;
	//
	//
	// @BeforeClass
	// public static void setUpBeforeClass() throws Exception {
	//
	// }
	//
	// @AfterClass
	// public static void tearDownAfterClass() throws Exception {
	// }
	//
	// @Before
	// public void setUp() throws Exception {
	// proxy = RestServiceFactory.getRestService(AuthenticationResource.class);
	// loginViewTest = Mockito.mock(EmailLoginView.class,
	// Mockito.RETURNS_DEEP_STUBS);
	// clientFactory = Mockito.mock(LoginClientFactory.class);
	// authenticationMessages =
	// MessageFactory.getMessage(AuthenticationMessages.class);
	//
	// loginPresenter = new EmailLoginPresenter(loginViewTest, eventBus,
	// clientFactory);
	//
	// }
	//
	// @After
	// public void tearDown() throws Exception {
	//
	// RestProxyClassStandAlone.wait(proxy);
	// }
	//
	// // @Ignore
	// @Test
	// public void testLoginByEmail() throws InterruptedException {
	//
	// when(loginViewTest.getEmail()).thenReturn("ee56054@gmail.com");
	// when(loginViewTest.getPassword()).thenReturn("1234");
	//
	// when(clientFactory.getLoginView()).thenReturn(loginViewTest);
	//
	// when(clientFactory.getAuthenticationResource()).thenReturn(proxy);
	//
	// when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);
	//
	// doAnswer(new Answer<String>() {
	// public String answer(InvocationOnMock invocationOnMock) throws Throwable
	// {
	// when(loginViewTest.getNotify()).thenReturn((String)
	// invocationOnMock.getArguments()[0]);
	// System.out.println("testLoginByEmail loginViewTest.getNotify1: " +
	// loginViewTest.getNotify());
	// assertNull(loginViewTest.getNotify());
	// return null;
	// }
	// }).when(loginViewTest).setNotify(anyString());
	//
	// loginPresenter.login();
	// // System.out.println("loginViewTest.getNotify12:" +
	// // loginViewTest.getNotify());
	// // System.out.println("loginViewTest.getNotify12:" +
	// // loginViewTest.getNotify());
	// // System.out.println("loginViewTest.getNotify12:" +
	// // loginViewTest.getNotify());
	// // System.out.println("loginViewTest.getNotify12:" +
	// // loginViewTest.getNotify());
	//
	// // assertNull(loginViewTest.getNotify());
	//
	// }
	//
	//
	//
	//
	//
	// // @Ignore
	// @Test
	// public void testLoginByEmailBlankFail() throws InterruptedException {
	//
	// when(loginViewTest.getEmail()).thenReturn("");
	// when(loginViewTest.getPassword()).thenReturn("1234");
	//
	// when(clientFactory.getLoginView()).thenReturn(loginViewTest);
	//
	// when(clientFactory.getAuthenticationResource()).thenReturn(proxy);
	// when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);
	//
	// doAnswer(new Answer<String>() {
	// public String answer(InvocationOnMock invocationOnMock) throws Throwable
	// {
	// when(loginViewTest.getNotify()).thenReturn((String)
	// invocationOnMock.getArguments()[0]);
	//
	// assertEquals(loginViewTest.getNotify(), loginViewTest.getNotify(),
	// authenticationMessages.errorEmailEmpty());
	// assertNotNull(loginViewTest.getNotify());
	// return null;
	// }
	// }).when(loginViewTest).setNotify(anyString());
	//
	// loginPresenter.login();
	//
	// // System.out.println("loginViewTest.getNotify:" +
	// // loginViewTest.getNotify());
	//
	//
	// }
	//
	// // @Ignore
	// @Test
	// public void testLoginByEmailWithoutAtSignFail() throws
	// InterruptedException {
	//
	// when(loginViewTest.getEmail()).thenReturn("ee56054");
	// when(loginViewTest.getPassword()).thenReturn("1234");
	//
	// when(clientFactory.getLoginView()).thenReturn(loginViewTest);
	//
	// when(clientFactory.getAuthenticationResource()).thenReturn(proxy);
	// when(clientFactory.getAuthenticationMessages()).thenReturn(authenticationMessages);
	//
	// doAnswer(new Answer<String>() {
	// public String answer(InvocationOnMock invocationOnMock) throws Throwable
	// {
	// when(loginViewTest.getNotify()).thenReturn((String)
	// invocationOnMock.getArguments()[0]);
	// assertEquals(loginViewTest.getNotify(), loginViewTest.getNotify(),
	// authenticationMessages.errorAtSign(loginViewTest.getEmail()));
	// assertNotNull(loginViewTest.getNotify());
	// return null;
	// }
	// }).when(loginViewTest).setNotify(anyString());
	//
	// loginPresenter.login();
	//
	// // System.out.println("loginViewTest.getNotify:" +
	// // loginViewTest.getNotify());
	//
	//
	//
	// }

}
