package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.strategyX.pageObjects.HomePage;
import com.strategyX.pageObjects.LoginPage;
import com.sltest.core.Constants;
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

	public StepDefination_LoginPageTests() throws IOException {
		driver = CreateSession.getWebDriver();
		this.loginPage = new LoginPage(this.driver);
		this.homePage = new HomePage(this.driver);
		this.url = Constants.WEB_CONFIG.WEB_URL;
	}

	@Given("^i go to StrategyX Login page$")
	public void goToStrategyXLoginPage() throws Throwable {
		loginPage.get(url);
	}

	@When("i fill in username with {string}")
	public void fillUserName(String username) throws InterruptedException {
		loginPage.findElement(loginPage.usernameInput).sendKeys(username);
	}

	@And("i fill in password with {string}")
	public void fillPassword(String password) throws InterruptedException {
		loginPage.findElement(loginPage.passwordInput).sendKeys(password);
	}

	@And("^i press login button$")
	public void clicklogin() throws InterruptedException, TimeoutException {
		//loginPage.waitForElementToBeClickable(loginPage.loginButton);
		
		loginPage.clickOnElementUsingActions(loginPage.loginButton);
		Thread.sleep(6000);
	}

	@Then("i should see profile name as {string}")
	public void VerifySuccessfulLogin(String profileName) throws TimeoutException {
		//homePage.waitForPageToLoad(homePage.getTitle());

		String expectedProfileName = homePage.findElement(homePage.userProfileLogo).getText();
		String actualProfileName = profileName;
		Assert.assertEquals(expectedProfileName, actualProfileName);
	}

	// Unsuccessful Login

	@Then("i should get error message as {string}")
	public void VerifyUnSuccessfulLogin(String value) throws TimeoutException {
		loginPage.waitForElementVisibility(By.className("toast-title"));
		String toastMessage = loginPage.findElement(By.className("toast-title")).getText();
		Assert.assertEquals(toastMessage, value);
	}

// Forget password
	@When("i click on forget password button")
	public void clickForgetButoon() {
		loginPage.clickOnElementUsingActions(loginPage.forgetPassword);
	}

	@Then("^i should navigated to page of request reset link$")
	public void VerifyRestResetField() throws TimeoutException {
		loginPage.waitForPageToLoad(loginPage.getTitle());
		loginPage.findElement(loginPage.requestLink).isDisplayed();
		System.out.println("Successfully navigated to request reset link page");
	}
	
	//chat to us
	@When("i click on chat to us button")
	public void clickChatToUsButoon() {
		loginPage.clickOnElementUsingActions(loginPage.chatToUs);
	}

	@Then("^i should see pop up for chat$")
	public void VerifyChatToUsPopUp() throws TimeoutException {
		loginPage.waitForElementToBeClickable(loginPage.chatToUsPopUP);
		loginPage.findElement(loginPage.chatToUsPopUP).isDisplayed();
		System.out.println("Continue to coversation pop up is displayed");
	}
	
	
	
}
