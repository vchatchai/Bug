package com.bug;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppMain {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"classpath:com/bug/config/applicationContext.xml");
	private static boolean standalone = true;

	public AppMain() {

		// logger.info("Spring context initialized.");

		// Message message = (Message) applicationContext.getBean("message");

		// logger.debug("message='" + message.getMessage() + "'");
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static boolean isStandalone() {
		return true;
	}

}
