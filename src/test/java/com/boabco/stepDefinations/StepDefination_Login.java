package com.boabco.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sltest.core.CreateSession;
import com.sltest.core.TestContext;
import com.strategyX.pageObjects.SuccessFactorPage;
import com.boabco.pageObjects.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_Login {
	private String url;
	
	private TestContext testContext;
	private LoginPage loginPage;

	public StepDefination_Login() throws IOException {
		testContext = TestContext.getTestContext();
		loginPage = testContext.getPageObjectManager().getBoabCo_LoginPage();
		this.url = "https://staging-boabco.stream-line.com.au/#/login";
	}

	@Given("^i go to BoabCo Login page$")
	public void goToStrategyXLoginPage() throws Throwable {
		loginPage.get(url);
		loginPage.setLocalStorageItem(loginPage.session_token_key, loginPage.token);
	}

	@When("i fill in username of BoabCo with {string}")
	public void fillUserName(String username) throws InterruptedException {
		loginPage.waitForPageToLoad(loginPage.getTitle());
		loginPage.findElement(loginPage.usernameInput).sendKeys(username);
	}

	@And("i fill in password of BoabCo with {string}")
	public void fillPassword(String password) throws InterruptedException {
		loginPage.findElement(loginPage.passwordInput).sendKeys(password);
	}

	@And("^i press login button of BoabCo$")
	public void clicklogin() throws InterruptedException, TimeoutException {
		loginPage.waitForElementToBeClickable(loginPage.loginButton);
		loginPage.clickOnElementUsingActions(loginPage.loginButton);
	}

	@Then("i should see profile name of BoabCo as {string}")
	public void VerifyLogin(String profileName) throws TimeoutException, InterruptedException {
		loginPage.waitForPageToLoad(loginPage.getTitle());//
		loginPage.waitForElementVisibility(loginPage.profile);
		loginPage.clickOnElementUsingActions(loginPage.profile);
		
		loginPage.waitForElementVisibility(loginPage.boabCoLogo);
		loginPage.clickOnElementUsingActions(loginPage.boabCoLogo);
	}

}
