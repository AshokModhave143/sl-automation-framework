package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.apache.tools.ant.taskdefs.Ant.TargetElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sltest.core.CreateSession;
import com.sltest.core.TestContext;
import com.strategyX.pageObjects.RiskPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_RiskPageTests {
	private TestContext testContext;
	private RiskPage riskPage;

	private WebDriver driver;

	public StepDefination_RiskPageTests() throws IOException {
		testContext = TestContext.getTestContext();
		riskPage = testContext.getPageObjectManager().getRiskPage();
	}

	@Given("^i go to risk module$")
	public void goToActionModule() {
		riskPage.clickOnElementUsingActions(riskPage.riskMenuLink);
	}

	@When("^i go to add risk$")
	public void goToAddActionButton() {
		riskPage.waitForPageToLoad(riskPage.getTitle());
		riskPage.clickOnElementUsingActions(riskPage.addRisk);

	}

	@And("^i fill in the following details under risk module:$")
	public void fillmandatoryfields(Map<String, String> fieldList) throws InterruptedException, TimeoutException {
		riskPage.waitForPageToLoad(riskPage.getTitle());

		for (Map.Entry<String, String> entry : fieldList.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);

			if (key.equalsIgnoreCase("Unwanted Event")) {
				riskPage.waitForPageToLoad(riskPage.getTitle());
				// String expectedTitleRisk = "Test Unwanted Event" + riskPage.getTodaysDate();

				// setting this variable into context to access in other tests with key
				// "expectedTitleRisk"
				// testContext.getScenarioContext().setContextMethod("RiskTitle",
				// expectedTitleRisk);
				riskPage.waitForElementVisibility(riskPage.unwantedEvent);

				String unwantedEventInput = value.equalsIgnoreCase("TODAY") ? riskPage.getTodaysDate() : value;
				testContext.getScenarioContext().setContextMethod("unwantedEventKey", unwantedEventInput);
				riskPage.findElement(riskPage.unwantedEvent).sendKeys(unwantedEventInput);
				// riskPage.findElement(riskPage.unwantedEvent).sendKeys(expectedTitleRisk);

			}

			if (key.equalsIgnoreCase("Consequence category")) {
				riskPage.selectValueFromDropdownViaText(riskPage.consequenceCategory, value);
			}

			if (key.equalsIgnoreCase("Risk Category")) {
				riskPage.clickOnElementUsingActions(riskPage.riskCategory);
				riskPage.waitForElementToBeClickable(riskPage.selectRiskCategory);
				riskPage.clickOnElementUsingActions(riskPage.selectRiskCategory);
				Thread.sleep(2000);
			}
			if (key.equalsIgnoreCase("Risk Sub Category")) {
				Thread.sleep(1000);
				riskPage.waitForElementToBeClickable(riskPage.riskSubCategory);
				riskPage.clickOnElementUsingActions(riskPage.riskSubCategory);
				riskPage.waitForElementToBeClickable(riskPage.selectRiskSubCategory);
				Thread.sleep(1000);
				riskPage.clickOnElementUsingActions(riskPage.selectRiskSubCategory);
			}

			if (key.equalsIgnoreCase("Due Date")) {
				riskPage.findElement(riskPage.dueDate).click();
				Thread.sleep(1000);
				riskPage.findElement(riskPage.selectAddDueDate).click();
				Thread.sleep(2000);
			}
			if (key.equalsIgnoreCase("Assigned To")) {
				riskPage.selectValueFromDropdownViaText(riskPage.assignedTo, value);
			}

			if (key.equalsIgnoreCase("Approved By")) {
				riskPage.selectValueFromDropdownViaText(riskPage.approvedBy, value);
			}

		}
	}

	@And("^i give Inherent Risk rating$")
	public void enterInherentRiskRating() throws TimeoutException {

		riskPage.clickOnElementUsingActions(riskPage.inherentRiskRating);
		riskPage.switchToDialogWindow();
		riskPage.clickOnElementUsingActions(riskPage.selectInherentRiskRating);
		riskPage.waitForElementToBeClickable(riskPage.doneInherentRiskRating);
		riskPage.clickOnElementUsingActions(riskPage.doneInherentRiskRating);

	}

	@And("^i give Residual Risk Rating$")
	public void enterResidualRiskRating() throws TimeoutException {
		riskPage.clickOnElementUsingActions(riskPage.residualRiskRating);
		riskPage.switchToDialogWindow();
		riskPage.clickOnElementUsingActions(riskPage.selectResidualRiskRating);
		riskPage.waitForElementToBeClickable(riskPage.doneResidualRiskRating);
		riskPage.clickOnElementUsingActions(riskPage.doneResidualRiskRating);

	}

	@And("^i click on saveandExit button$")
	public void clickOnSaveAndExitButton() throws TimeoutException {
		riskPage.waitForElementToBeClickable(riskPage.saveAndExit);
		riskPage.clickOnElementUsingActions(riskPage.saveAndExit);
	}

	@And("^click on No button for adding first action while adding risk$")
	public void clickNoButton() throws TimeoutException {
		riskPage.waitForElementVisibility(riskPage.noButtonForFirstAction);
		riskPage.clickOnElementUsingActions(riskPage.noButtonForFirstAction);

	}

	@Then("verify if risk is added as {string}")
	public void verifyAddedRisk(String value) throws InterruptedException {
		WebElement table = riskPage.findElement(riskPage.riskTable);
		String unwantedEvent = testContext.getScenarioContext().getContextMethod("unwantedEventKey").toString();
		Thread.sleep(2000);
		Assert.assertTrue(riskPage.isTableContainsText(table, unwantedEvent));
	}

	// update risk module

	@When("^i click on Risk name$")
	public void clickOnRiskName() throws TimeoutException {

		riskPage.waitForPageToLoad(riskPage.getTitle());
		String unwantedEvent = testContext.getScenarioContext().getContextMethod("unwantedEventKey").toString();

		riskPage.waitForElementToBeClickable(riskPage.riskTable);
		riskPage.getRiskTitleCell(unwantedEvent).click();
	}

	@And("i enter description to update Risk as {string}")
	public void enterDescriptionToUpdateRisk(String value) throws TimeoutException, InterruptedException {

		// riskPage.findElement(riskPage.riskDescription).clear();
		riskPage.switchToDialogWindow();
		Thread.sleep(1000);
		riskPage.waitForElementVisibility(riskPage.riskrDescriptionSpan);
		riskPage.clickOnElementUsingActions(riskPage.riskrDescriptionSpan);
		// riskPage.waitForElementVisibility(riskPage.riskDescriptionInput);
		riskPage.findElement(riskPage.riskDescriptionInput).clear();
		Thread.sleep(1000);
		riskPage.findElement(riskPage.riskDescriptionInput).sendKeys(value);
	}

	@And("^click on saveAndExit to update Risk$")
	public void clickOnsaveAndExit() throws TimeoutException {
		riskPage.clickOnElementUsingActions(riskPage.saveRiskFactor);
	}

	@And("click on {string} for Will you meet this deadline?")
	public void clickOnYesButton(String value) throws TimeoutException, InterruptedException {
		riskPage.switchToDialogWindow();
		riskPage.waitForElementToBeClickable(riskPage.yesButton);
		riskPage.findElement(riskPage.yesButton).click();
		Thread.sleep(2000);
	}
	@Then("Risk description should be {string}")
	public void verifyDescription_Risk(String value) throws TimeoutException {
		riskPage.waitForPageToLoad(riskPage.getTitle());
		String unwantedEvent = testContext.getScenarioContext().getContextMethod("unwantedEventKey").toString();
		riskPage.getRiskTitleCell(unwantedEvent).click();
		riskPage.waitForPageToLoad(riskPage.getTitle());
		String actualDescription = riskPage.findElement(riskPage.riskrDescriptionSpan).getText();
		Assert.assertEquals(actualDescription, value);
		riskPage.clickOnElementUsingActions(riskPage.saveRiskFactor);
	}
	
	//delete added risk
	
	@When("^click on three datatable dots under risk module$")
	public void clickOnThreeDotsOfRiskTable() throws TimeoutException, InterruptedException {
		riskPage.waitForPageToLoad(riskPage.getTitle());
		Thread.sleep(2000);
		riskPage.waitForElementToBeClickable(riskPage.riskTable);
		String unwantedEvent = testContext.getScenarioContext().getContextMethod("unwantedEventKey").toString();
		riskPage.getThreeDotCell(unwantedEvent).click();
		
	}

	@And("^click on delete button under risk module$")
	public void clickDeleteButton() throws TimeoutException {
		riskPage.waitForElementToBeClickable(riskPage.deleteRiskButton);
		riskPage.clickOnElementUsingActions(riskPage.deleteRiskButton);
	}

	
	@Then("^added risk should get deleted$")
	public void verifyDeletedRisk() {
		System.out.println("Added Risk is deleted");
	}


}
