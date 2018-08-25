package org.webskey.websocket.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.get("http://localhost:8090");
	}

	public void enterUsername(String username) {
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys(username);
	}

	public void clickConnect() {
		WebElement connect = driver.findElement(By.id("connect-btn"));
		connect.click();
	}

	public boolean isChatConnected() {	
		WebElement rest = driver.findElement(By.id("rest"));

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return rest.isDisplayed();
	}

	public ChatElement joinChat(String username) {
		enterUsername(username);
		clickConnect();

		return new ChatElement(driver);
	}
}
