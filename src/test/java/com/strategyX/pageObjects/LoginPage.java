package com.strategyX.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sltest.core.CommonMethods;

public class LoginPage extends CommonMethods {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		// PageFactory.initElements(driver,this);
	}
		
	// Elements
	public By usernameInput = By.name("email");
	public By passwordInput = By.name("password");
	public By loginButton = By.id("_btn-login");
	
	public By forgetPassword = By.xpath("//span[text()='Forgot Password?']");
	public By requestLink = By.xpath("//input[@value='Request reset link']");
	public By chatToUs = By.xpath("//button[@class='btn btn-default intercom-chat-launcher']");
	public By chatToUsPopUP = By.xpath("//span[text()='Send us a message']");
	
	
	
	// helper methods
//	public void enterUsernameAndPassword(String email, String password) {
//		// locate username
//		WebElement element = this.findElement(usernameInput);
//		element.sendKeys(email);
//	}
//
//	public void enterpassword(String password) throws InterruptedException {
//		// locate password
//		WebElement element = driver.findElement(passwordInput);
//		element.sendKeys(password);
//		Thread.sleep(5000);
//	}
//
//	public void clickLoginButton() throws InterruptedException {
//		// click on login
//		WebElement Login = driver.findElement(By.id("_btn-login"));
//		Login.click();
//	}

}
