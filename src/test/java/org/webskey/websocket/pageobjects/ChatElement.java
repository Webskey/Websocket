package org.webskey.websocket.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChatElement {

	private WebDriver driver;

	public ChatElement(WebDriver driver) {
		this.driver = driver;
	}

	public void writeMessage(String message) {
		WebElement msg = driver.findElement(By.id("msg"));
		msg.sendKeys(message);
	}

	public void send() {
		WebElement send = driver.findElement(By.id("send"));
		send.click();
	}

	public void disconnect() {
		WebElement dc = driver.findElement(By.id("disconnect"));
		dc.click();
	}

	public MessagesElement getMessages() {
		return new MessagesElement(driver);
	}
}
