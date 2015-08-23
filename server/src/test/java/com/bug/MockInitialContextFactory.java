package com.bug;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MockInitialContextFactory implements InitialContextFactory {

    private static final ThreadLocal<Context> currentContext = new ThreadLocal<Context>();

    public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
        return currentContext.get();
    }

    public static void setCurrentContext(Context context) {
        currentContext.set(context);
    }

    public static void clearCurrentContext() {
        currentContext.remove();
    }

}

