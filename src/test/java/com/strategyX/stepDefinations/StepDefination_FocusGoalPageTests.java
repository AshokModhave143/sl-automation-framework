package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sltest.core.CreateSession;
import com.sltest.core.TestContext;
import com.strategyX.pageObjects.FocusGoalPage;
import com.strategyX.pageObjects.SuccessFactorPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_FocusGoalPageTests {
	private TestContext testContext;
	private FocusGoalPage focusGoalPage;

	public StepDefination_FocusGoalPageTests() throws IOException {
		testContext = TestContext.getTestContext();
		focusGoalPage = testContext.getPageObjectManager().getFocusGoalPage();
	}

 //Add focus goal
	@Given("^i go to focus goal module$")
	public void goToFocusGoalModule() throws TimeoutException, InterruptedException {
		Thread.sleep(4000);
		focusGoalPage.waitForElementVisibility(focusGoalPage.focusGoalsModule);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.focusGoalsModule);

	}

	@When("^i click on add button under focus goal$")
	public void clickOnAddButton() throws InterruptedException {
        Thread.sleep(2000);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.addButton);

	}

	@And("enter focus goal FROM as {string}")
	public void enterFocusGoal_From(String go_From) throws TimeoutException, InterruptedException {
		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());
		Thread.sleep(2000);
		focusGoalPage.waitForElementToBeClickable(focusGoalPage.goFrom);

		String fromDate = go_From.equalsIgnoreCase("TODAY") ? focusGoalPage.getTodaysDate() : go_From;
		testContext.getScenarioContext().setContextMethod("fromDate", fromDate);
		focusGoalPage.findElement(focusGoalPage.goFrom).sendKeys(fromDate);

	}

	private String toDate;

	@And("enter focus goal TO as {string}")
	public void enterFocusGoal_To(String go_To) throws TimeoutException {
		toDate = go_To.equalsIgnoreCase("AFTER_15_DAYS") ? focusGoalPage.getDateAfter_Fifteendays() : go_To;
		focusGoalPage.findElement(focusGoalPage.goTo).sendKeys(toDate);
	}

	@And("enter assignedTo as {string}")
	public void enterAssignedTo_FocusGoal(String assigned_To) {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.focusGoalAssignedTo);
		focusGoalPage.selectValueFromDropdownViaText(focusGoalPage.focusGoalAssignedTo, assigned_To);
		System.out.println("avhgdvh");
	}

	@And("enter approvedBy as {string}")
	public void enterApprovedBy_FocusGoal(String approved_By) {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.focusGoalApprovedBy);
		focusGoalPage.selectValueFromDropdownViaText(focusGoalPage.focusGoalApprovedBy, approved_By);
	}

	String selectedSuccessFactor;

	@And("enter success factor for focus goal as {string}")
	public void enterSuccessFactor_FocusGoal(String successfactor_name) {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.successFactor);
		// selectedSuccessFactor = "test " + focusGoalPage.getTodaysDate();
		// focusGoalPage.selectValueFromDropdownViaText(focusGoalPage.successFactor,
		// selectedSuccessFactor);
		String expectedTitleSuccessFactor = testContext.getScenarioContext()
				.getContextMethod("expectedTitleSuccessFactor").toString();
		focusGoalPage.selectValueFromDropdownViaText(focusGoalPage.successFactor, expectedTitleSuccessFactor);
		// focusGoalPage.selectValueFromDropdownViaIndex(focusGoalPage.successFactor,
		// 1);
		String text = focusGoalPage.findElement(focusGoalPage.successFactor).getText();
	}

	String selectedDueDate;

	@And("enter dueDate")
	public void enterDueDate_FocusGoal() throws TimeoutException {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.dueDate);
//	successFactorPage.waitForElementVisibility(successFactorPage.dueDateas26012021);
//	successFactorPage.clickOnElementUsingActions(successFactorPage.dueDateas26012021);
//	successFactorPage.clickOnElementUsingActions(successFactorPage.doneButtonDueDate);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.selectDueDtae);
		selectedDueDate = focusGoalPage.findElement(focusGoalPage.dueDate).getAttribute("value");
	}

	@And("^click on saveAndExit$")
	public void clickOnSave() {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.saveAndExitFocusGoal);
	}

	@And("^click on No button for adding first action now$")
	public void clickNoButton() throws TimeoutException {
		focusGoalPage.waitForElementVisibility(focusGoalPage.noButtonForFirstAction);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.noButtonForFirstAction);

	}

	@Then("verify if focus goal is added as {string}")
	public void verifyAddedFocusGoal(String value) throws InterruptedException {
//		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());
//		focusGoalPage.clickOnElementUsingActions(focusGoalPage.focusGoalsModule);
//		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());
//		String expectedTitleSuccessFactor;
		// String actualTitle =
		// focusGoalPage.getFocusGoalTitleCellText(expectedTitleSuccessFactor);
//		String expectedTitleSuccessFactor = testContext.getScenarioContext().getContextMethod("expectedTitleSuccessFactor").toString();
//        String expectedTitle = "Go from "+fromDate+" to ";
//        Assert.assertTrue(actualTitle.contains(expectedTitle));
		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());
		WebElement table = focusGoalPage.findElement(focusGoalPage.focusTable);
		String fromDate = testContext.getScenarioContext().getContextMethod("fromDate").toString();
		Thread.sleep(4000);
		Assert.assertTrue(focusGoalPage.isTableContainsText(table, fromDate));

	}

	// Update focus goal by Adding action to focus goal
	@When("^i click on three dots$")
	public void clickThreeDotsButton() throws TimeoutException, InterruptedException {
		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());
		Thread.sleep(2000);
		focusGoalPage.waitForElementToBeClickable(focusGoalPage.focusTable);
		String fromDate = testContext.getScenarioContext().getContextMethod("fromDate").toString();
		Thread.sleep(5000);
		focusGoalPage.getThreeDotCell(fromDate).click();
	}

	@And("^click on add action button$")
	public void clickAddButton() throws TimeoutException, InterruptedException {
		Thread.sleep(2000);
		focusGoalPage.waitForElementToBeClickable(focusGoalPage.addActionButton);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.addActionButton);
	}

	private String actionName;

	@And("enter title as {string}")
	public void enterTitle(String value) throws TimeoutException {
		actionName = "add action " + focusGoalPage.getTodaysDate();
		focusGoalPage.findElement(focusGoalPage.titleAddAction).sendKeys(actionName);

	}

	@And("enter assignedTo action under Focus Goal as {string}")
	public void enterAssignedTo(String value) {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.asignedToAction_focusGoal);
		focusGoalPage.selectValueFromDropdownViaText(focusGoalPage.asignedToAction_focusGoal, value);
	}

	@And("enter approvedBy action under Focus Goal as {string}")
	public void enterapprovedBy(String value) {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.approvedByAction_focusGoal);
		focusGoalPage.selectValueFromDropdownViaText(focusGoalPage.approvedByAction_focusGoal, value);
	}

	@And("^enter due Date action under Focus Goal$")
	public void enterdueDate() {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.duedateAction_focusGoal);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.selectDueDate_addActionFocusGoal);

	}

	@And("^click on save button action under Focus Goal$")
	public void clickOnSAve() {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.save_addAction);

	}

	@Then("action should get added as {string}")
	public void verifyAddedAction(String value) throws TimeoutException, InterruptedException {
		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());
		Thread.sleep(3000);
		focusGoalPage.waitForElementToBeClickable(focusGoalPage.actionsMenuLink);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.actionsMenuLink);
		focusGoalPage.waitForPageToLoad(focusGoalPage.getTitle());

		WebElement actionTable = focusGoalPage.findElement(focusGoalPage.actionTable);
		Thread.sleep(3000);
		Assert.assertTrue(isTableContainsText(actionTable, actionName));
	}

	public boolean isTableContainsText(WebElement table, String text) {
		if (table.getText().contains(text)) {
			return true;
		}

		return false;
	}

//		Assert.assertTrue(focusGoalPage.isTableContainsText(table, fromDate));
//		
//		WebElement table = focusGoalPage.findElement(focusGoalPage.table);
//		boolean isExists = focusGoalPage.isRegistered(table, actionName);
//		Thread.sleep(2000);
//		System.out.println(isExists);
//		Assert.assertTrue(isExists);
	// WebElement table = actionPage.findElement(actionPage.table);

	// boolean isExists = actionPage.isRegistered(table, "Action1");
	// System.out.println(isExists);
	// Assert.assertTrue(isExists);

	// delete success factor

	@When("^click on three datatable dots to delete Focus Goals$")
	public void clickOnThreeDots() throws TimeoutException {
		focusGoalPage.waitForElementVisibility(focusGoalPage.dataTableDots);
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.dataTableDots);
	}

	@And("^click on delete button to delete Focus Goals$")
	public void clickDeleteButton() {
		focusGoalPage.clickOnElementUsingActions(focusGoalPage.deleteFocusGoalButton);
	}

	@Then("^Focus Goals should get deleted$")
	public void verifyDeletedSuccessFactor() {
		System.out.println("focus goal is deleted");
	}

}