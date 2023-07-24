package com.boabco.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sltest.core.CommonMethods;

public class LoginPage extends CommonMethods {
	private WebDriver driver;

	public LoginPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}

	// Elements
	public By usernameInput = By.id("username");
	public By passwordInput = By.name("password");
	public By loginButton = By.xpath("//button[@type='submit']//*[text()='Sign in']");

	public By logo = By.xpath("//img[contains(@src,'boabco/logo')]");
	public By profile = By.xpath("//button[@title='Profile']");
	public By boabCoLogo = By.xpath("//img[@src='https://sif-web-assets-au.s3.amazonaws.com/boabco/logo.png']");
	
	public String session_token_key = "session_token";
	public String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmZDI3YjlhZTAxOTcyMDRjNDUxMWFhODVkZWQzZDQwNSIsImlzcyI6Imh0dHA6Ly9zdGFnaW5nLWJvYWJjby1hcGkuc3RyZWFtLWxpbmUuY29tLmF1L2FwaS92Mi91c2VyL3Nlc3Npb24iLCJpYXQiOjE2MTMwODYwMzQsImV4cCI6MTYxMzExNDgzNCwibmJmIjoxNjEzMDg2MDM0LCJqdGkiOiJrcGdWR05WcEw3MXE0V0JaIiwidXNlcl9pZCI6MTgsImZvcmV2ZXIiOmZhbHNlfQ.ro8uYgD7PvTPnpQdF9xkxM_LY0OJC1CziavIwEhE4rc";

}
