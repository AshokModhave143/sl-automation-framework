package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;

import com.strategyX.pageObjects.HomePage;
import com.sltest.core.CreateSession;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefination_HomePageTests {
	private WebDriver driver = null;
	private HomePage homePage;
	
	public StepDefination_HomePageTests() throws IOException {
		driver = CreateSession.getWebDriver();		
		homePage = new HomePage(driver);
	}
	

	@Given("^I go to Action Module$")
	public void goToActionModule() throws Throwable {
		homePage.waitForPageToLoad(homePage.getTitle());
		homePage.clickOnElementUsingActions(homePage.actionsMenuLink);
	}
	
	@Then("^Get number of Actionslist$")
	public void getActionList() throws InterruptedException {
		homePage.getActionCount();
	}
	
	@And("^Logout from application$")
	public void clickOnLogoutLink() throws TimeoutException, InterruptedException {
		homePage.waitForPageToLoad(homePage.getTitle());
		homePage.scrollToElement(homePage.logoutMenuLink);
		homePage.implicitWait(3000);
		homePage.waitForElementToBeClickable(homePage.logoutMenuLink);
		homePage.clickOnElementUsingActions(homePage.logoutMenuLink);
		Thread.sleep(5000);
	}
}
