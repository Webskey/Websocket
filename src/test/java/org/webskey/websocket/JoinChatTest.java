package org.webskey.websocket;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.webskey.websocket.pageobjects.DriverFactory;
import org.webskey.websocket.pageobjects.HomePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JoinChatTest {

	private WebDriver driver;
	private HomePage homePage;

	@Before
	public void setUp() {
		driver = DriverFactory.INSTANCE.getDriver();
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Given("^I am on Home Page$")
	public void i_am_on_Home_Page() throws Exception {
		homePage = new HomePage(driver);
	}

	@When("^I enter \"([^\"]*)\"$")
	public void i_enter(String name) throws Exception {
		homePage.enterUsername(name);
	}

	@When("^I click connect$")
	public void i_click_connect() throws Exception {
		homePage.clickConnect();
	}

	@Then("^I joined chat$")
	public void i_joined_chat() throws Exception {
		assertTrue(homePage.isChatConnected());
	}

	@Then("^I failed to join chat$")
	public void i_failed_to_join_chat() throws Exception {
		assertFalse(homePage.isChatConnected());
	}
}
