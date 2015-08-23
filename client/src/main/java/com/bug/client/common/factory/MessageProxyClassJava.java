package com.bug.client.common.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

import com.google.gwt.i18n.client.Messages.DefaultMessage;

public class MessageProxyClassJava implements InvocationHandler {

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		DefaultMessage defaultMessage = (DefaultMessage) method.getAnnotation(DefaultMessage.class);

		String value = defaultMessage.value();

		if (!Objects.isNull(args)) {
			for (int count = 0; count < args.length; count++) {
				String arg = (String) args[count];
				value = value.replaceAll("\\{" + count + "\\}", arg);
			}
		}

		return value;
	}

}
