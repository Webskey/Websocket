package org.webskey.websocket.pageobjects;

import org.openqa.selenium.firefox.FirefoxDriver;

public enum DriverFactory {
	INSTANCE;
	
	private FirefoxDriver driver;
	
	private DriverFactory() {
		System.setProperty("webdriver.gecko.driver", "c:/SeleniumGecko/geckodriver.exe");
		this.driver = new FirefoxDriver();
	}
	
	public FirefoxDriver getDriver() {
		return driver;
	}
}
