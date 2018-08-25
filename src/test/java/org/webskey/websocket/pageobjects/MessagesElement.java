package org.webskey.websocket.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagesElement {

	private WebDriver driver;
	
	public MessagesElement(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getMyMessages() {
		WebElement myMsg = driver.findElement(By.id("myMsg"));
		
		return myMsg.getText(); 
	}
	
	public boolean isMyMessageDisplayed(String message) {
		WebElement messages = driver.findElement(By.id("messages"));
		
		boolean contains = messages.getText().contains(message);
		boolean displayed = messages.isDisplayed();
		
		return contains && displayed;
	}
}
