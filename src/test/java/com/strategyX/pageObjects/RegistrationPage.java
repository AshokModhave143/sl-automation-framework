package com.strategyX.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sltest.core.CommonMethods;
public class RegistrationPage extends CommonMethods {
	private WebDriver driver;

	public RegistrationPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}

//locate elements
	public By createAccountButton = By.xpath("//input[@value='Create Account']");
    public By firstName = By.id("company-user-firstname");
    public By lastName = By.id("company-user-lastname");
    public By emailAddress = By.id("company-user-email");
    public By countryCode = By.id("company-user-country-code");
    public By phone = By.id("company-user-mobile");
    public By companyDetails = By.xpath("//h4[text()='Company details']");
    //elements for company details
    public By companyName=By.name("name");
    public By timeZone= By.id("company-user-timezone-id");
    public By nextButton = By.xpath("//button[text()='Next']");
    //elements on mobile page
    public By mobileCode = By.name("mobile_verification_code");
}
