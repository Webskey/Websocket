package org.webskey.websocket;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.webskey.websocket.pageobjects.ChatElement;
import org.webskey.websocket.pageobjects.DriverFactory;
import org.webskey.websocket.pageobjects.HomePage;
import org.webskey.websocket.pageobjects.MessagesElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WriteMessageTest {

	private WebDriver driver;
	private HomePage homePage;
	private ChatElement chatElement;
	private MessagesElement messagesElement;
	private String message;

	@Before
	public void setUp() {
		driver = DriverFactory.INSTANCE.getDriver();
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@Given("^I am connected to chat$")
	public void i_am_connected_to_chat_with() throws Exception {
		homePage = new HomePage(driver);
		chatElement = homePage.joinChat("username");
	}

	@When("^i write \"([^\"]*)\" message$")
	public void i_write_message(String message) throws Exception {
		this.message = message;
		chatElement.writeMessage(message);
	}

	@When("^I click send button$")
	public void i_click_send_button() throws Exception {
		chatElement.send();
	}

	@Then("^My message is displayed in conversation table$")
	public void my_message_is_displayed_in_conversation_table() throws Exception {
		messagesElement = chatElement.getMessages();
		assertTrue(messagesElement.isMyMessageDisplayed(message));
	}
}
