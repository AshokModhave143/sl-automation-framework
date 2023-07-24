package com.flashworks.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.flashworks.pageObjects.HomePage;
import com.flashworks.pageObjects.LoginPage;
import com.sltest.core.CreateSession;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_LoginPageTests {
	private WebDriver driver = null;	
	private LoginPage loginPage;
	private HomePage homePage;
	private String url;
	
	public StepDefination_LoginPageTests () throws IOException {
		driver = CreateSession.getWebDriver();
		this.loginPage = new LoginPage(this.driver);
		this.homePage = new HomePage(this.driver);
		this.url = "https://planorate.flashworks.io/";
	}

	@Given("^i go to Flashwork Login page$")
	public void goToFlashworkLoginPage() throws Throwable {
		loginPage.get(url);
	}

	@When("i fill in username with {string}")
	public void fillUserName(String username) throws InterruptedException {
		loginPage.waitForPageToLoad(loginPage.getTitle());
		loginPage.findElement(loginPage.usernameInput).sendKeys(username);		
	}
	@And("i fill in password with {string}")
	public void fillPassword(String password) throws InterruptedException {
		loginPage.findElement(loginPage.passwordInput).sendKeys(password);		
	}
	
	@And("^i press login button$")
	public void clicklogin() throws InterruptedException, TimeoutException {
		loginPage.waitForElementToBeClickable(loginPage.loginButton);
		loginPage.clickOnElementUsingActions(loginPage.loginButton);
		
	}
	

	@Then("i should see {string}")
	public void VerifyLogin(String profileName) throws TimeoutException, InterruptedException {
		Thread.sleep(5000);
		homePage.waitForPageToLoad(homePage.getTitle());
		String actualProfileName = homePage.findElement(homePage.welcomeText).getText();
		String expectedProfileName = profileName;
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

}

