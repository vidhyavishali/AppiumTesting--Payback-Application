package com.apptest.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {

	private  WebDriver driver;
	private  DesiredCapabilities cap = new DesiredCapabilities();
	private final static Logger logger = Logger.getLogger(DriverFactory.class);

	public  WebDriver createDriverInstance() {

		if (driver == null) {
			String platform = ReadAppConfig.getProperty("platformName");
			logger.info("Running tests on: " + platform);
			cap.setCapability("deviceName", ReadAppConfig.getProperty("deviceName"));
			cap.setCapability("udid", ReadAppConfig.getProperty("uuid"));
			cap.setCapability("platformName", ReadAppConfig.getProperty("platformName"));
			cap.setCapability("platformVersion", ReadAppConfig.getProperty("platformVersion"));
			cap.setCapability("appPackage", ReadAppConfig.getProperty("appPackage"));
			cap.setCapability("appActivity", ReadAppConfig.getProperty("appActivity"));
			cap.setCapability("noReset", ReadAppConfig.getProperty("noReset"));
			System.out.println("Creating driver instance");

			try {
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new RemoteWebDriver(url, cap);
			} catch (MalformedURLException exception) {
				logger.error("Error with Driver URL");
				exception.printStackTrace();
			}
		}
		return driver;

	}

	public  void stopDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
