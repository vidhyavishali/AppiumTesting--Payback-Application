package com.apptest.steps;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.apptest.utils.DriverFactory;
import com.apptest.utils.SessionManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	private static Logger logger = LogManager.getLogger(Hooks.class.getName());
	private SessionManager instance = SessionManager.getInstance();
	private DriverFactory dFactory = new DriverFactory();
	private WebDriver driver;

	@Before
	public void setUp(Scenario scenario) {

		logger.info("Running Scenario : " + scenario.getName());
		driver = dFactory.createDriverInstance();
		instance.setDriver(driver);
	}

	@After
	public void tearDown(Scenario scenario) {
		logger.info("Scenario completed: " + scenario.getName());
		dFactory.stopDriver();

	}

}
