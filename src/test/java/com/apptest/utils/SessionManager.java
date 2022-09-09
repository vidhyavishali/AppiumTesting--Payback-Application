package com.apptest.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SessionManager {

	private static SessionManager instance;
	private static Logger logger = LogManager.getLogger(SessionManager.class.getName());

	public static SessionManager getInstance() {

		if (instance == null) {
			logger.debug("Session is null. It has to be initialized.");
			return instance = new SessionManager();
		}
		return instance;
	}

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
