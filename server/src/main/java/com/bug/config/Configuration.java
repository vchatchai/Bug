package com.bug.config;

import java.io.IOException;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.ConfigurationException;

public class Configuration {

	public static BaseConfiguration getTitanConfiguration() throws IOException, ConfigurationException {

		// PropertiesConfiguration propertiesConfiguration = new
		// PropertiesConfiguration(Configuration.class.getResource("titan-cassandra.properties"));

		// BaseConfiguration.addProperty("storage.backend", "inmemory");
		BaseConfiguration conf = new BaseConfiguration();
		conf.setProperty("storage.backend", "inmemory");
		// conf.setProperty("storage.hostname","127.0.0.1");
		// TitanGraph g = TitanFactory.open(conf);

		return conf;

	}

}
