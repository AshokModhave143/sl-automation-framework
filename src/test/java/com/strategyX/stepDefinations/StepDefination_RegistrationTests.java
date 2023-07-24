package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;

import com.sltest.core.CreateSession;

import com.strategyX.pageObjects.RegistrationPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_RegistrationTests {
	private WebDriver driver = null;
	private RegistrationPage registrationPage;
	private String url;

	public StepDefination_RegistrationTests() throws IOException {
		driver = CreateSession.getWebDriver();
		this.registrationPage = new RegistrationPage(this.driver);
		this.url = "https://test.strategyexe.com/users/login";
	}

	@Given("^i go to StrategyX registarion page$")
	public void goToStrategyXLoginPage() throws Throwable {
		registrationPage.get(url);
	}

	@When("^i click on create account button$")
	public void clickCreateAccountButton() throws TimeoutException {
		registrationPage.waitForElementVisibility(registrationPage.createAccountButton);
		registrationPage.findElement(registrationPage.createAccountButton).click();
	}

	@And("i enter first name under personal details as {string}")
	public void enterFirstName(String value) {
		registrationPage.findElement(registrationPage.firstName).sendKeys(value);
	}

	@And("i enter last name under personal details as {string}")
	public void enterLastName(String value) {
		registrationPage.findElement(registrationPage.lastName).sendKeys(value);
	}

	@And("i enter email address under personal details as {string}")
	public void enterEmailAddress(String value) {
		registrationPage.findElement(registrationPage.emailAddress).sendKeys(value);
	}

	@And("i enter country code under personal details as {string}")
	public void enterCountryCode(String value) {

		registrationPage.selectValueFromDropdownViaText(registrationPage.countryCode, value);
		registrationPage.clickOnElementUsingActions(registrationPage.companyDetails);
	}

	@And("i enter mobile number under personal details as {string}")
	public void enterMobileNumber(String value) {
		registrationPage.findElement(registrationPage.phone).sendKeys(value);
	}

	@And("i enter company name as {string}")
	public void enterCompanyName(String value) throws TimeoutException {
		registrationPage.waitForElementToBeClickable(registrationPage.companyName);
		registrationPage.findElement(registrationPage.companyName).sendKeys(value);
	}

	@And("i enter time zone under company details as {string}")
	public void enterTimeZone(String value) throws TimeoutException {
		registrationPage.waitForElementToBeClickable(registrationPage.timeZone);
		registrationPage.selectValueFromDropdownViaText(registrationPage.timeZone, value);
		registrationPage.clickOnElementUsingActions(registrationPage.companyDetails);
	}

	@And("^i click on next button$")
	public void clickNext() throws TimeoutException {
		registrationPage.waitForElementToBeClickable(registrationPage.nextButton);
		registrationPage.findElement(registrationPage.nextButton).click();
	}

	@Then("^user should be able to navigate to verify mobile page$")
	public void navigateMobilePage() {
		registrationPage.waitForPageToLoad(registrationPage.getTitle());
		registrationPage.findElement(registrationPage.mobileCode).isDisplayed();
     System.out.println("Successfully navigated to verify mobile number page");
	}

}
