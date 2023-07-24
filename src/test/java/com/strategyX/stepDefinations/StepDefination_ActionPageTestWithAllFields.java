package com.strategyX.stepDefinations;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sltest.core.CreateSession;
import com.strategyX.pageObjects.ActionPage;

import io.cucumber.cucumberexpressions.CaptureGroupTransformer;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_ActionPageTestWithAllFields {
	private ActionPage actionPage;
	// private HomePage homePage;
	private WebDriver driver;

	public StepDefination_ActionPageTestWithAllFields() throws IOException {
		driver = CreateSession.getWebDriver();
		actionPage = new ActionPage(driver);
	}

	@Given("^i am already on Action Page$")
	public void goToActionModule() {
		actionPage.clickOnElementUsingActions(actionPage.actionsMenuLink);
	}

	@When("^i go to add action$")
	public void goToAddActionButton() {
		actionPage.clickOnElementUsingActions(actionPage.addAction);

	}

	@And("^i fill in the following details:$")
	public void fillmandatoryfields(Map<String, String> fieldList) throws InterruptedException, TimeoutException {
		actionPage.waitForPageToLoad(actionPage.getTitle());

		for (Map.Entry<String, String> entry : fieldList.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + ":" + value);

			if (key.equalsIgnoreCase("title")) {
				actionPage.findElement(actionPage.title).sendKeys(value);
				
			}

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
			if (key.equalsIgnoreCase("Notes")) {
				actionPage.findElement(actionPage.notesInput).sendKeys(value);
				actionPage.clickOnElementUsingActions(actionPage.postNoteButtonButton);
			}

			if (key.equalsIgnoreCase("Duration")) {
				actionPage.clickOnElementUsingActions(actionPage.duration);
				actionPage.findElement(actionPage.duration).sendKeys(value);
			}

			if (key.equalsIgnoreCase("Work Date")) {
				actionPage.clickOnElementUsingActions(actionPage.workDate);
				actionPage.clickOnElementUsingActions(actionPage.selectWorkDate);
			}

//			if (key.equalsIgnoreCase("Add Voice Note")) {
//				actionPage.clickOnElementUsingActions(actionPage.addVoiceButton);
//				Thread.sleep(2000);
//				if (actionPage.isAlertPresent()) {
//					actionPage.acceptsAlert();
//					Thread.sleep(1000);
//					}
//				actionPage.waitForElementToBeClickable(actionPage.addVoiceButton);
//				actionPage.clickOnElementUsingActions(actionPage.addVoiceButton);
//				Thread.sleep(1000);
//
//			}
			
			if (key.equalsIgnoreCase("Add Attachment")) {
				actionPage.findElement(actionPage.addAttachmentButton).sendKeys("D:\\Study Folder\\Streamline_workspace\\test.docx");
				Thread.sleep(5000);
			}
			
			if (key.equalsIgnoreCase("Subtask Name")) {
				actionPage.clickOnElementUsingActions(actionPage.subTasksButton);
				actionPage.findElement(actionPage.subtaskname).sendKeys(value);
				actionPage.clickOnElementUsingActions(actionPage.plusSubTaskButton);
				Thread.sleep(2000);
			}

		}
	}

	@And("^i press Save&ExitButton$")
	public void clickOnSaveAndExitButton() throws TimeoutException {
		// System.out.println(actionPage.findElement(actionPage.saveAndExit));
		actionPage.waitForElementToBeClickable(actionPage.saveAndExit);
		actionPage.clickOnElementUsingActions(actionPage.saveAndExit);

	}
	

	@Then("i should see new added action in ActionList")
	public void verifyAddedAction() {
		// System.out.println("successfull");

		WebElement table = actionPage.findElement(actionPage.table);

		boolean isExists = actionPage.isRegistered(table, "Action1");
		System.out.println(isExists);
		Assert.assertTrue(isExists);
	}

//	@And("delete added action")
//	public void deleteAction() {
//		boolean isDeleted = actionPage.deleteAddedAction(actionPage.findElement(actionPage.table), "Action1");
//	System.out.println("deleted:" + isDeleted);
//		Assert.assertTrue(isDeleted);
//	}
}
