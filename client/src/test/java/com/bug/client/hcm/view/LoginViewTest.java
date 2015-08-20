package com.bug.client.hcm.view;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
//import static org.hamcrest.Matchers.containsString;

import com.bug.client.common.webservice.RestServiceFactory;
import com.bug.client.hcm.factory.LoginClientFactory;
import com.bug.client.hcm.presenter.LoginPresenter;
import com.bug.client.hcm.webservice.AuthenticationResource;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

@RunWith(MockitoJUnitRunner.class)
public class LoginViewTest {
	EventBus eventBus = new SimpleEventBus();

	@Ignore
	@Test
	public void testWithOutServer() {

		LoginView loginViewTest = Mockito.mock(LoginView.class);
		LoginClientFactory clientFactory = Mockito.mock(LoginClientFactory.class);
		AuthenticationResource loginResourceClient = new LoginResourceClientTestImp();

		when(loginViewTest.getEmail()).thenReturn("ee56054@gmail.com");
		when(loginViewTest.getPassword()).thenReturn("1234");

		when(clientFactory.getLoginView()).thenReturn(loginViewTest);

		when(clientFactory.getAuthenticationResource()).thenReturn(loginResourceClient);

		LoginPresenter loginPresenter = new LoginPresenter(loginViewTest, eventBus,
				clientFactory.getAuthenticationResource());

		loginPresenter.login();

		String result = loginViewTest.getEmail();
		// assertThat(result, containsString("ee56054@gmail.com"));
		assertEquals(result, "ee56054@gmail.com");

	}

	@Test
	public void testWithServer() {
		AuthenticationResource proxy = RestServiceFactory.getRestService(AuthenticationResource.class);
		// proxy.createEmployee(new MethodCallback<Employee>() {
		//
		// public void onSuccess(Method method, Employee response) {
		// // TODO Auto-generated method stub
		// System.out.println("onSuccess");
		// }
		//
		// public void onFailure(Method method, Throwable exception) {
		// // TODO Auto-generated method stub
		// System.out.println("onFailure");
		//
		// }
		// });

		LoginView loginViewTest = Mockito.mock(LoginView.class, Mockito.RETURNS_DEEP_STUBS);
		LoginClientFactory clientFactory = Mockito.mock(LoginClientFactory.class);
		AuthenticationResource loginResourceClient = new LoginResourceClientTestImp();

		// final Dog mockedDog = Mockito.mock(Dog.class,
		// Mockito.RETURNS_DEEP_STUBS);
		// // connect getter and setter
		// Mockito.when(mockedDog.getSound()).thenCallRealMethod();
		// Mockito.doCallRealMethod().when(mockedDog).setSound(Mockito.any(Sound.class));

		// Mockito.when(loginViewTest.getNotify()).

		// when(loginViewTest.getNotify()).thenCallRealMethod();
		// doCallRealMethod().when(loginViewTest).setNotify(anyString());

		when(loginViewTest.getEmail()).thenReturn("ee56054@gmail.com");
		when(loginViewTest.getPassword()).thenReturn("1234");

		when(clientFactory.getLoginView()).thenReturn(loginViewTest);

		when(clientFactory.getAuthenticationResource()).thenReturn(loginResourceClient);

		LoginPresenter loginPresenter = new LoginPresenter(loginViewTest, eventBus, proxy);

		loginPresenter.login();
		System.out.println(loginViewTest.getNotify());

		// Mockito.doAnswer(invocation -> {
		// short status = invocation.getArgumentAt(0, Short.class);
		// Mockito.when(mockOrder.getStatus()).thenReturn(status);
		// return null;
		// }).when(mockOrder).setStatus(Mockito.anyShort());
		// String result = loginViewTest.getEmail();
		// assertThat(result, containsString("ee56054@gmail.com"));
		// assertEquals(result, "ee56054@gmail.com");

	}

}
