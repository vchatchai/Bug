package com.bug.client.common.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.bug.AppMain;
import com.bug.client.common.anotation.SpringComponentResourceName;
import com.bug.client.common.webservice.RestProxyClassStandAlone;
import com.google.gwt.i18n.client.Messages.DefaultMessage;

public class MessageFactory {
	public static <T> T getMessage(Class cls) {


		InvocationHandler handler = new MessageProxyClassJava();
		T proxy = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[] { cls }, handler);

		return proxy;
	}

}
