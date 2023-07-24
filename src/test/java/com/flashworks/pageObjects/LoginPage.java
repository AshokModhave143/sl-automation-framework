package com.flashworks.pageObjects;

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
	public By usernameInput = By.id("username");
	public By passwordInput = By.id("password");
	public By loginButton = By.xpath("//button[@type='submit']");
}
