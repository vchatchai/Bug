package com.bug.client.common.webservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.bug.AppMain;
import com.bug.client.common.anotation.SpringComponentResourceName;

public class RestServiceFactory {

	public static <T> T getRestService(Class cls) {

		SpringComponentResourceName springComponentResourceName = (SpringComponentResourceName) cls
				.getAnnotation(SpringComponentResourceName.class);

		Object componentResource = AppMain.getApplicationContext().getBean(springComponentResourceName.value());

		InvocationHandler handler = new RestProxyClassStandAlone(componentResource);
		T proxy = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[] { cls }, handler);
		
		
		return proxy;
	}

}


