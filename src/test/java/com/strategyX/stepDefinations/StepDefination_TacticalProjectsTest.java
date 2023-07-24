package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sltest.core.TestContext;
import com.strategyX.pageObjects.RiskPage;
import com.strategyX.pageObjects.TacticalProjectsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_TacticalProjectsTest {
	private TestContext testContext;
	private TacticalProjectsPage tacticalProjectPage;

	private WebDriver driver;
	public StepDefination_TacticalProjectsTest() throws IOException {
		testContext = TestContext.getTestContext();
		tacticalProjectPage = testContext.getPageObjectManager().getTacticalProjectsPage();
	}
	
	@Given("^i go to tactical Projects module$")
	public void goToTacticalProjectsModule() {
		tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.tacticalProjectsMenuLink);
	}

	@When("^i go to add tactical Projects$")
	public void goToAddActionButton() {
		tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
		tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.addTacticalProjects);

	}

	@And("^i fill in the following details under tactical Projects module:$")
	public void fillmandatoryfields(Map<String, String> fieldList) throws InterruptedException, TimeoutException {
		tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());

		for (Map.Entry<String, String> entry : fieldList.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);

			if (key.equalsIgnoreCase("Project Name")) {
				tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
				tacticalProjectPage.waitForElementVisibility(tacticalProjectPage.projectName);

				String projectNameInput = value.equalsIgnoreCase("TODAY") ? tacticalProjectPage.getTodaysDate() : value;
				testContext.getScenarioContext().setContextMethod("projectNameKey", projectNameInput);
				tacticalProjectPage.findElement(tacticalProjectPage.projectName).sendKeys(projectNameInput);
				
			}

			if (key.equalsIgnoreCase("Category")) {
				tacticalProjectPage.selectValueFromDropdownViaText(tacticalProjectPage.category, value);
			}

			if (key.equalsIgnoreCase("Assigned To")) {
				tacticalProjectPage.selectValueFromDropdownViaText(tacticalProjectPage.assignedTo, value);
			}
			if (key.equalsIgnoreCase("Approved By")) {
				tacticalProjectPage.selectValueFromDropdownViaText(tacticalProjectPage.approved, value);
			}

			if (key.equalsIgnoreCase("Due Date")) {
				tacticalProjectPage.findElement(tacticalProjectPage.dueDate).click();
				Thread.sleep(1000);
				tacticalProjectPage.findElement(tacticalProjectPage.selectAddDueDate).click();
				Thread.sleep(2000);
			}
			
		}
	}

	@And("^i click on saveandExit button under tactical Projects$")
	public void clickOnSaveAndExitButton() throws TimeoutException {
		tacticalProjectPage.waitForElementToBeClickable(tacticalProjectPage.saveandexit);
		tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.saveandexit);
	}

	@And("^click on No button for adding first action while adding tactical Project$")
	public void clickNoButton() throws TimeoutException {
		tacticalProjectPage.waitForElementVisibility(tacticalProjectPage.noButtonForFirstAction);
		tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.noButtonForFirstAction);

	}

	@Then("verify if tactical Project is added as {string}")
	public void verifyAddedTacticalProject(String value) throws InterruptedException {
		WebElement table = tacticalProjectPage.findElement(tacticalProjectPage.tacticalProjectsTable);
		String projectName = testContext.getScenarioContext().getContextMethod("projectNameKey").toString();
		Thread.sleep(2000);
		Assert.assertTrue(tacticalProjectPage.isTableContainsText(table, projectName));
	}
	
	// update tactical project

		@When("^i click on tactical Project name$")
		public void clickOnTacticalProjectName() throws TimeoutException {

			tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
			String projectName = testContext.getScenarioContext().getContextMethod("projectNameKey").toString();

			tacticalProjectPage.waitForElementToBeClickable(tacticalProjectPage.tacticalProjectsTable);
			tacticalProjectPage.getTacticalProjectTitleCell(projectName).click();
		}

		@And("i enter description to update tactical Project as {string}")
		public void enterDescriptionToUpdateTacticalProject(String value) throws TimeoutException, InterruptedException {

			tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
			tacticalProjectPage.switchToDialogWindow();
			Thread.sleep(1000);
			tacticalProjectPage.waitForElementVisibility(tacticalProjectPage.tacticalProjectDescriptionSpan);
			tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.tacticalProjectDescriptionSpan);
			// riskPage.waitForElementVisibility(riskPage.riskDescriptionInput);
			tacticalProjectPage.findElement(tacticalProjectPage.tacticalProjectDescriptionInput).clear();
			Thread.sleep(1000);
			tacticalProjectPage.findElement(tacticalProjectPage.tacticalProjectDescriptionInput).sendKeys(value);
		}

		@And("^click on saveAndExit to update tactical Project$")
		public void clickOnsaveAndExit() throws TimeoutException {
			tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.tacticalProjectSave);
		}

		@And("click on {string} for Will you meet this deadline? under tactical Project")
		public void clickOnYesButton(String value) throws TimeoutException, InterruptedException {
			tacticalProjectPage.switchToDialogWindow();
			tacticalProjectPage.waitForElementToBeClickable(tacticalProjectPage.yesButton);
			tacticalProjectPage.findElement(tacticalProjectPage.yesButton).click();
			Thread.sleep(2000);
		}
		@Then("tactical Project description should be {string}")
		public void verifyDescription_TacticalProject(String value) throws TimeoutException {
			tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
			String projectName = testContext.getScenarioContext().getContextMethod("projectNameKey").toString();
			tacticalProjectPage.getTacticalProjectTitleCell(projectName).click();
			tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
			String actualDescription = tacticalProjectPage.findElement(tacticalProjectPage.tacticalProjectDescriptionSpan).getText();
			Assert.assertEquals(actualDescription, value);
			tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.tacticalProjectSave);
		}
		
		//delete added tactical project

		@When("^click on three datatable dots under tactical project module$")
		public void clickOnThreeDotsOfTacticalProjectTable() throws TimeoutException, InterruptedException {
			tacticalProjectPage.waitForPageToLoad(tacticalProjectPage.getTitle());
			Thread.sleep(2000);
			tacticalProjectPage.waitForElementToBeClickable(tacticalProjectPage.tacticalProjectsTable);
			String projectName = testContext.getScenarioContext().getContextMethod("projectNameKey").toString();
			tacticalProjectPage.getThreeDotsCell(projectName).click();
			
		}

		@And("^click on delete button under tactical project module$")
		public void clickDeleteButton() throws TimeoutException {
			tacticalProjectPage.waitForElementToBeClickable(tacticalProjectPage.deleteTacticalProjectsButton);
			tacticalProjectPage.clickOnElementUsingActions(tacticalProjectPage.deleteTacticalProjectsButton);
		}

		
		@Then("^added tactical project should get deleted$")
		public void verifyDeletedTacticalProject() {
			System.out.println("Added tactical project is deleted");
		}
	
	
}
