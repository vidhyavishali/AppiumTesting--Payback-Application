package com.apptest.utils;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadAppConfig {

	private final static Logger logger = Logger.getLogger(ReadAppConfig.class);
	private static Properties prop;

	static {
		prop = new Properties();
		FileInputStream file = null;
		try {
			file = new FileInputStream("./config/AppConfig.properties");
			prop.load(file);
		} catch (Exception e) {
			logger.error("Failed to read properties file!");
			e.printStackTrace();
		}
	}

	public static String getProperty(String property) {
		return prop.getProperty(property);
	}
}
