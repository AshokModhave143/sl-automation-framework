package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.beust.jcommander.internal.Console;
import com.sltest.core.CreateSession;
import com.sltest.core.TestContext;
import com.strategyX.pageObjects.ActionPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_ActionPageTests {
	private TestContext testContext;
	
	private ActionPage actionPage;
	// private HomePage homePage;
	//private WebDriver driver;

	public StepDefination_ActionPageTests() throws IOException {
		testContext = TestContext.getTestContext();
		actionPage = testContext.getPageObjectManager().getActionPage();
	}

	@Given("^i am on Action Page$")
	public void goToActionModule() {
		actionPage.clickOnElementUsingActions(actionPage.actionsMenuLink);
	}

	@When("^i go to add action button$")
	public void goToAddActionButton() {
		actionPage.waitForPageToLoad(actionPage.getTitle());
		actionPage.clickOnElementUsingActions(actionPage.addAction);

	}

	@And("i enter title for add action as {string}")
	public void enterTitle(String title) throws InterruptedException, TimeoutException {
		actionPage.waitForPageToLoad(actionPage.getTitle());
		Thread.sleep(4000);
	actionPage.waitForElementToBeClickable(actionPage.title);
	String titleDate = title.equalsIgnoreCase("TODAY") ? actionPage.getTodaysDate() : title;
	testContext.getScenarioContext().setContextMethod("titleKey", titleDate);
	actionPage.findElement(actionPage.title).sendKeys(titleDate);
	
	}
	
	@And("^i fill in the following:$")
	public void fillmandatoryfields(Map<String, String> fieldList) throws InterruptedException, TimeoutException {
		actionPage.waitForPageToLoad(actionPage.getTitle());

		for (Map.Entry<String, String> entry : fieldList.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);

//			if (key.equalsIgnoreCase("title")) {
//				Thread.sleep(4000);
//				actionPage.waitForElementToBeClickable(actionPage.title);
//				value.equalsIgnoreCase("TODAY") ? actionPage.getTodaysDate() : value
//				actionPage.findElement(actionPage.title).sendKeys(value);
//			}

			if (key.equalsIgnoreCase("Description")) {
				actionPage.findElement(actionPage.description).sendKeys(value);
			}

			if (key.equalsIgnoreCase("Assigned To")) {
				actionPage.selectValueFromDropdownViaText(actionPage.assignedTo, value);
			}
			
			if (key.equalsIgnoreCase("Approved By")) {
				actionPage.selectValueFromDropdownViaText(actionPage.approvedBy, value);
			}

			if (key.equalsIgnoreCase("Due Date")) {
				actionPage.findElement(actionPage.dueDate).click();
				Thread.sleep(1000);
				actionPage.findElement(actionPage.selectAddDueDate).click();
				Thread.sleep(2000);

			}
//			if(key.equalsIgnoreCase("Notes")) {
//				actionPage.findElement(actionPage.notesInput).sendKeys(value);
//			}

		}
	}

	@And("^i press Save&Exit$")
	public void clickOnSaveAndExitButton() throws TimeoutException {
		// System.out.println(actionPage.findElement(actionPage.saveAndExit));
		actionPage.waitForElementToBeClickable(actionPage.saveAndExit);
		actionPage.clickOnElementUsingActions(actionPage.saveAndExit);

	}

	@Then("i should see added action in ActionList")
	public void verifyAddedAction() throws TimeoutException, InterruptedException {
		
		try {
			actionPage.waitForElementVisibility(actionPage.table);
			WebElement table = actionPage.findElement(actionPage.table);
			Thread.sleep(5000);
			String titleDate = testContext.getScenarioContext().getContextMethod("titleKey").toString();
//			boolean isExists = actionPage.isRegistered(table, "Action1");
//			Assert.assertTrue(isExists);
			Thread.sleep(4000);
		Assert.assertTrue(actionPage.isTableContainsText(table, titleDate));
		} catch (org.openqa.selenium.StaleElementReferenceException ex) {
			actionPage.waitForElementVisibility(actionPage.table);
			WebElement table = actionPage.findElement(actionPage.table);
			Thread.sleep(4000);
			//boolean isExists = actionPage.isRegistered(table, "Action1");
			String titleDate = testContext.getScenarioContext().getContextMethod("titleKey").toString();
			//Assert.assertTrue(isExists);
			Assert.assertTrue(actionPage.isTableContainsText(table, titleDate));
		}
 
	}

//	@And("delete added action")
//	public void deleteAction() {
//		boolean isDeleted = actionPage.deleteAddedAction(actionPage.findElement(actionPage.table), "Action1");
//		System.out.println("deleted:" + isDeleted);
//		Assert.assertTrue(isDeleted);
//	}

	@Given("^I go to action module to edit due date$")
	public void goToActionModuleToEditAction() throws InterruptedException, TimeoutException {
		actionPage.clickOnElementUsingActions(actionPage.actionsMenuLink);

	}

	@When("^I edit due date of action$")
	public void editDueDate() throws InterruptedException, TimeoutException {

		actionPage.waitForElementToBeClickable(actionPage.editDueDate);
		actionPage.clickOnElementUsingActions(actionPage.editDueDate);
//		actionPage.waitForElementVisibility(actionPage.selectEditDueDate);
//		actionPage.findElement(actionPage.selectEditDueDate).click();

		// switch to pop up
		actionPage.switchToDialogWindow();

		actionPage.clickOnElementUsingActions(actionPage.excludedButton);

		// switch to parent window

		actionPage.switchToParentWindow();

	}

	@When("^I edit priority date of action$")
	public void editPriorityDate() throws InterruptedException, TimeoutException {
        actionPage.waitForElementToBeClickable(actionPage.priorityDate);
		actionPage.clickOnElementUsingActions(actionPage.priorityDate);
		
		actionPage.waitForElementToBeClickable(actionPage.selectpriorityDate);
		actionPage.clickOnElementUsingActions(actionPage.selectpriorityDate);
		actionPage.waitForElementVisibility(actionPage.priorityDate);
	}

	@Then("^Due date should get updated$")
	public void verifyDueDate() {
		System.out.println("sucess");
	}

	@And("^Priority date should get updated$")
	public void verifyPriorityDate() {
		System.out.println("sucess");
	}

	// delete action

	@When("^i click on delete button of selected action$")
	public void clickonDeleteButton() throws InterruptedException, TimeoutException {
		actionPage.waitForPageToLoad(actionPage.getTitle());
		actionPage.clickOnElementUsingActions(actionPage.threedots);
		actionPage.scrollToElement(actionPage.deleteButton);
		actionPage.waitForElementToBeClickable(actionPage.deleteButton);
		actionPage.clickOnElementUsingActions(actionPage.deleteButton);
		Thread.sleep(2000);
		actionPage.waitForPageToLoad(actionPage.getTitle());

	}

	@Then("^action should get deleted$")
	public void verifyDeletedAction() {
		System.out.println("successful");

	}
	
	
	
	
// Approval Module | sending request to approve action under approvals module
	
	@And ("^i click on percentage complete$")
	public void clickOnPercentageComplete() throws InterruptedException, TimeoutException {
actionPage.waitForPageToLoad(actionPage.getTitle());
Thread.sleep(2000);
actionPage.waitForElementToBeClickable(actionPage.table);
String titleDate = testContext.getScenarioContext().getContextMethod("titleKey").toString();
Thread.sleep(5000);
actionPage.getPercentageCompleteCell(titleDate).click();
	}
	
	@And ("^i click on 100 percent to complete in this task$")
	public void clickOn100PercentageComplete() throws InterruptedException, TimeoutException {
Thread.sleep(1000);
		// switch to pop up
		actionPage.switchToDialogWindow();

		actionPage.clickOnElementUsingActions(actionPage.Hundred);

		
	}
	@And ("^i click on save button$")
	public void clickOnSavePercent() throws InterruptedException, TimeoutException {
actionPage.clickOnElementUsingActions(actionPage.savePercent);
//switch to parent window

		actionPage.switchToParentWindow();
	//actionPage.waitForPageToLoad(actionPage.getTitle());
	}
}
