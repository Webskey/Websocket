package org.webskey.websocket;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.webskey.websocket.pageobjects.DriverFactory;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"})
public class TestRunner {
	
	@AfterClass
	public static void shutDown() {
		DriverFactory.INSTANCE.getDriver().quit();
	}
}