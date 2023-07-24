package com.strategyX.stepDefinations;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sltest.core.CreateSession;
import com.sltest.core.TestContext;
import com.strategyX.pageObjects.SuccessFactorPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_SuccessFactorPageTests {
	private TestContext testContext;
	private SuccessFactorPage successFactorPage;

	public StepDefination_SuccessFactorPageTests() throws IOException {
		testContext = TestContext.getTestContext();
		successFactorPage = testContext.getPageObjectManager().getSuccessFactorPage();
	}

	@Given("^i go to Success Factor Module$")
	public void goToSuccessFactorModule() {

		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
		successFactorPage.clickOnElementUsingActions(successFactorPage.successFactorModule);
	}

	@When("^i click on add button$")
	public void clickAddButton() throws TimeoutException, InterruptedException {
		Thread.sleep(2000);
		successFactorPage.waitForElementToBeClickable(successFactorPage.addButton);
		successFactorPage.clickOnElementUsingActions(successFactorPage.addButton);
	}


	@And("enter success factor as {string}")
	public void enterSuccessFactor(String value) throws TimeoutException {
		successFactorPage.waitForElementVisibility(successFactorPage.successFactorInput);
		String expectedTitleSuccessFactor = "test " + successFactorPage.getTodaysDate();

		// setting this variable into context to access in other tests with key "expectedTitleSuccessFactor"
		testContext.getScenarioContext().setContextMethod("expectedTitleSuccessFactor", expectedTitleSuccessFactor);
		
		successFactorPage.findElement(successFactorPage.successFactorInput).sendKeys(expectedTitleSuccessFactor);

	}

	@And("^enter Assigned To$")
	public void enterAssignedTo() {
		successFactorPage.selectValueFromDropdownViaText(successFactorPage.assignedToDropDown, "Diksha");

	}

	@And("^enter report title$")
	public void enterReportTitles() {
		successFactorPage.findElement(successFactorPage.reportTitleInput).sendKeys("Title");

	}

	@And("^enter graph type$")
	public void enterGraphType() {
		successFactorPage.selectValueFromDropdownViaIndex(successFactorPage.graphType, 1);
	}

	@And("^click on save & exit$")
	public void clickSaveExitButton() throws InterruptedException {
		Thread.sleep(2000);
		successFactorPage.clickOnElementUsingActions(successFactorPage.saveAndExitButton);
		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
	}

	@Then("^Success Factor should get added$")
	public void verifySuccessFactor() throws TimeoutException, InterruptedException {
		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
		String expectedTitleSuccessFactor = testContext.getScenarioContext().getContextMethod("expectedTitleSuccessFactor").toString();
		Thread.sleep(2000);
		String actualTitle = successFactorPage.getSuccessFactorTitleCellText(expectedTitleSuccessFactor);
		Assert.assertTrue(actualTitle.contains(expectedTitleSuccessFactor));
		
	}

//Verify added success factor

//	@Then("^verify if table contains added success factor$")
//	public void verifyAddedSuccessFactor() {
//		}

	// update success factor

	@When("^i click on success factors name$")
	public void clickOnSuccessFactorName() throws TimeoutException, InterruptedException {

		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
		String expectedTitleSuccessFactor = testContext.getScenarioContext().getContextMethod("expectedTitleSuccessFactor").toString();
        Thread.sleep(2000);
		successFactorPage.getSuccessFactorTitleCell(expectedTitleSuccessFactor).click();
	}

	@And("i enter description to update success factor as {string}")
	public void enterDescriptionToUpdateFocusGoal(String value) throws TimeoutException {

//		successFactorPage.findElement(successFactorPage.successFactorDescription).clear();
		successFactorPage.switchToDialogWindow();
		successFactorPage.waitForElementVisibility(successFactorPage.successFactorDescriptionSpan);
		successFactorPage.clickOnElementUsingActions(successFactorPage.successFactorDescriptionSpan);

		successFactorPage.waitForElementVisibility(successFactorPage.successFactorDescriptionInput);
		// successFactorPage.findElement(successFactorPage.successFactorDescriptionInput).clear();
		successFactorPage.findElement(successFactorPage.successFactorDescriptionInput).sendKeys(value);
	

	}

	@And("^click on saveAndExit to update success factor$")
	public void clickOnAddFocusGoal() throws TimeoutException {
		successFactorPage.clickOnElementUsingActions(successFactorPage.saveUpdateSuccessFactor);
	}

	@Then("success factor description should be {string}")
	public void verifyDescription_SuccessFactor(String value) throws TimeoutException, InterruptedException {
		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
		String expectedTitleSuccessFactor = testContext.getScenarioContext().getContextMethod("expectedTitleSuccessFactor").toString();
		Thread.sleep(3000);
		successFactorPage.getSuccessFactorTitleCell(expectedTitleSuccessFactor).click();
		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
		String actualNotes = successFactorPage.findElement(successFactorPage.successFactorDescriptionSpan).getText();
		Assert.assertEquals(actualNotes, value);
		successFactorPage.clickOnElementUsingActions(successFactorPage.saveUpdateSuccessFactor);
	}

//	@And("enter focus goal FROM as {string}")
//	public void enterFocusGoal_From(String go_From) throws TimeoutException {
//		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
//		successFactorPage.waitForElementVisibility(successFactorPage.goFrom);
//		String fromDate = go_From.equalsIgnoreCase("TODAY") ? successFactorPage.getTodaysDate() :  go_From;
//		successFactorPage.findElement(successFactorPage.goFrom).sendKeys(fromDate);
//		
//	}
//
//	@And("enter focus goal TO as {string}")
//	public void enterFocusGoal_To(String go_To) throws TimeoutException {
//		successFactorPage.findElement(successFactorPage.goTo).sendKeys(go_To);
//	}
//
//	@And("enter assignedTo as {string}")
//	public void enterAssignedTo_FocusGoal(String assigned_To) {
//		successFactorPage.clickOnElementUsingActions(successFactorPage.focusGoalAssignedTo);
//		successFactorPage.selectValueFromDropdownViaText(successFactorPage.assignedToDropDown, assigned_To);
//		System.out.println("avhgdvh");
//	}

//	@And("enter approvedBy as {string}")
//	public void enterApprovedBy_FocusGoal(String approved_By) {
//		successFactorPage.clickOnElementUsingActions(successFactorPage.focusGoalApprovedBy);
//		successFactorPage.selectValueFromDropdownViaText(successFactorPage.focusGoalApprovedBy, approved_By);
//	}

//	@And("enter dueDate")
//	public void enterDueDate_FocusGoal() throws TimeoutException {
//		successFactorPage.clickOnElementUsingActions(successFactorPage.dueDate);
//	successFactorPage.waitForElementVisibility(successFactorPage.dueDateas26012021);
//	successFactorPage.clickOnElementUsingActions(successFactorPage.dueDateas26012021);
//	successFactorPage.clickOnElementUsingActions(successFactorPage.doneButtonDueDate);
//		successFactorPage.clickOnElementUsingActions(successFactorPage.selectDueDtae);
//		
//		
//	}

//	@And("^click on saveAndExit$")
//	public void clickOnSave() {
//		successFactorPage.clickOnElementUsingActions(successFactorPage.saveAndExitFocusGoal);
//	}
//
//	@And("^click on No button for adding first action now$")
//	public void clickNoButton() throws TimeoutException {
//		successFactorPage.waitForElementVisibility(successFactorPage.noButtonForFirstAction);
//		successFactorPage.clickOnElementUsingActions(successFactorPage.noButtonForFirstAction);
//		System.out.println("abcd");
//	}
//
//	@Then("verify if focus goal is added as {string}")
//	public void verifyAddedFocusGoal(String value) {
//		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
//		successFactorPage.clickOnElementUsingActions(successFactorPage.focusGoalsModule);
//		successFactorPage.waitForPageToLoad(successFactorPage.getTitle());
//		String title = successFactorPage.getTitleFocusGoal();
//		Assert.assertEquals(title, value);		
//	}
	
	
	
	
	
//delete success factor

	@When("^click on three datatable dots$")
	public void clickOnThreeDots() throws TimeoutException {
		successFactorPage.waitForElementVisibility(successFactorPage.dataTableDots);
		successFactorPage.clickOnElementUsingActions(successFactorPage.dataTableDots);
		
	}

	@And("^click on delete button$")
	public void clickDeleteButton() throws TimeoutException {
		successFactorPage.waitForElementToBeClickable(successFactorPage.deleteSuccessFactorButton);
		successFactorPage.clickOnElementUsingActions(successFactorPage.deleteSuccessFactorButton);
	}

	@And("^click on yes button$")
	public void clickOnYesButton() throws InterruptedException {
		successFactorPage.clickOnElementUsingActions(successFactorPage.yesButton);
		Thread.sleep(2000);
	}

	@Then("^success factor should get deleted$")
	public void verifyDeletedSuccessFactor() {
		System.out.println("success");
	}

}
