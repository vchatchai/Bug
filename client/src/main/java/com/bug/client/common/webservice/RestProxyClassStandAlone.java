package com.bug.client.common.webservice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.fusesource.restygwt.client.MethodCallback;

public class RestProxyClassStandAlone implements InvocationHandler {

	private Object componentResource;

	public RestProxyClassStandAlone(Object componentResource) {
		this.componentResource = componentResource;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {

		Thread thread = new ConnectionThread(componentResource, proxy, m, args); 
		thread.start();

		return null;

	}
}

class ConnectionThread extends Thread {
	Object proxy;
	Method m;
	Object[] args;
	Object componentResource;

	public ConnectionThread(Object componentResource, Object proxy, Method m, Object[] args) {
		this.proxy = proxy;
		this.m = m;
		this.args = args;
		this.componentResource = componentResource;
		// System.out.println("instatnceof run:"+ m.getName());
	}

	@Override
	public void run() {
		org.fusesource.restygwt.client.Method method = null;
		Method[] methods = componentResource.getClass().getMethods();

		Method componentResourceMethod = null;
		for (Method meth : methods) {
			if (meth.getName().equals(m.getName())) {
				componentResourceMethod = meth;
			}
		}

		MethodCallback methodCallback = (MethodCallback) args[args.length - 1];

		Object[] objects = java.util.Arrays.copyOfRange(args, 0, args.length - 1);

		try {
			Object result = componentResourceMethod.invoke(componentResource, objects);
			methodCallback.onSuccess(method, result);
		} catch (Throwable e) {
			methodCallback.onFailure(method, e);
		}

	}
}

class JunitMethod extends org.fusesource.restygwt.client.Method {

	public JunitMethod(String name) {

	}

}
