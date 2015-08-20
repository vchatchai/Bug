package com.bug.config;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.BaseConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.codahale.metrics.MetricRegistryListener.Base;

public class Configuration {

	public static BaseConfiguration getTitanConfiguration() throws IOException, ConfigurationException {

		
		PropertiesConfiguration  propertiesConfiguration = new PropertiesConfiguration(Configuration.class.getResource("titan-cassandra.properties"));
		
		return propertiesConfiguration;
		
		
		 
	}

}
