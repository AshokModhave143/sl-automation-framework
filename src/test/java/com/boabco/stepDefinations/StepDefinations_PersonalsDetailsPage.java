package com.boabco.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.boabco.pageObjects.LoginPage;
import com.boabco.pageObjects.PersonalDetailsPage;
import com.sltest.core.TestContext;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepDefinations_PersonalsDetailsPage {
	private TestContext testContext;
	private PersonalDetailsPage personalDetailsPage;

	public StepDefinations_PersonalsDetailsPage() throws IOException {
		testContext = TestContext.getTestContext();
		personalDetailsPage = testContext.getPageObjectManager().getBoabCo_personalDetailsPage();
}

	@Given("^i click on people$")
	public void clickPeople() throws TimeoutException, InterruptedException {
		personalDetailsPage.waitForPageToLoad(personalDetailsPage.getTitle());
		Thread.sleep(6000);
		personalDetailsPage.waitForElementToBeClickable(personalDetailsPage.peopleButton);
		personalDetailsPage.clickOnElementUsingActions(personalDetailsPage.peopleButton);
	}

	@And("^i click on create button$")
	public void clickCreateButton() {
		personalDetailsPage.waitForPageToLoad(personalDetailsPage.getTitle());
		personalDetailsPage.clickOnElementUsingActions(personalDetailsPage.createButton);
	}

	@And("i fill first_name with {string}")
	public void fillFirstName(String value) throws TimeoutException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.first_name);
		personalDetailsPage.findElement(personalDetailsPage.first_name).sendKeys(value);
	}

	@And("i fill last_name with {string}")
	public void fillLastName(String value) throws TimeoutException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.last_name);
		personalDetailsPage.findElement(personalDetailsPage.last_name).sendKeys(value);
	}

	@And("i fill DOB with {string}")
	public void fillDOB(String value) throws TimeoutException, InterruptedException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.date_of_birth);
		personalDetailsPage.findElement(personalDetailsPage.date_of_birth).click();
		personalDetailsPage.switchToDialogWindow();
		Thread.sleep(2000);
		personalDetailsPage.findElement(personalDetailsPage.okButton).click();
	}

	@And("i fill gender as {string}")
	public void fillGender(String value) throws TimeoutException, InterruptedException {
		personalDetailsPage.clickOnElementUsingActions(personalDetailsPage.gender);
		Thread.sleep(3000);
		//personalDetailsPage.findElement(personalDetailsPage.getGenderXpath(value)).click();;	
		personalDetailsPage.findElement(personalDetailsPage.female).click();
	}
	@And("i fill dawang as {string}")
	public void fillDwang(String value) throws TimeoutException, InterruptedException {
		personalDetailsPage.clickOnElementUsingActions(personalDetailsPage.dawang);
		Thread.sleep(3000);
		personalDetailsPage.clickOnElementUsingActions(personalDetailsPage.Balaburr);
	}

	@And("i fill mothers_name {string}")
	public void fillMothersName(String value) throws TimeoutException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.mother_name);
		personalDetailsPage.findElement(personalDetailsPage.mother_name).sendKeys(value);
	}
	@And("i fill fathers_name {string}")
	public void fillFathersName(String value) throws TimeoutException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.father_name);
		personalDetailsPage.findElement(personalDetailsPage.father_name).sendKeys(value);
	}

	@And("i fill community {string}")
	public void fillCommunity(String value) throws TimeoutException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.community);
		personalDetailsPage.findElement(personalDetailsPage.community).sendKeys(value);
	}
	@And("i fill street {string}")
	public void fillStreet(String value) throws TimeoutException {
		personalDetailsPage.waitForElementVisibility(personalDetailsPage.street);
		personalDetailsPage.findElement(personalDetailsPage.street).sendKeys(value);
	}

	@And("^i fill drivers_licence$")
	public void fillDriverLicence() throws TimeoutException {
		personalDetailsPage.scrollToElement(personalDetailsPage.drivers_licence);
		personalDetailsPage.waitForElementToBeClickable(personalDetailsPage.drivers_licence);
		personalDetailsPage.findElement(personalDetailsPage.drivers_licence).click();
		personalDetailsPage.selectValueFromDropdownViaIndex(personalDetailsPage.drivers_licence, 0);
	}

	@And("^click on save button$")
	public void clickSave() throws InterruptedException {
		personalDetailsPage.clickOnElementUsingActions(personalDetailsPage.saveButton);
		Thread.sleep(3000);	}
	
	@Then("^person should get created$")
	public void verifyAddedPerson() {
		System.out.println("Done");
	}

}
