package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.sltest.core.TestContext;
import com.strategyX.pageObjects.ApprovalsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_ApprovalPageTests {
	private TestContext testcontext;
	private ApprovalsPage approvalsPage;

	public StepDefination_ApprovalPageTests() throws IOException {
		testcontext = TestContext.getTestContext();
		approvalsPage = testcontext.getPageObjectManager().getApprovalsPage();
	}

	@And("^i go to approvals module$")
	public void goToApprovalModule() throws TimeoutException {
		approvalsPage.waitForElementToBeClickable(approvalsPage.approvalModule);
		approvalsPage.findElement(approvalsPage.approvalModule).click();
	}

//My Approved
	@When("^i click on my approved button$")
	public void clickMyApprovedButton() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
		approvalsPage.clickOnElementUsingActions(approvalsPage.myApproved);

	}

	@Then("^verify the results of my approved$")
	public void verifyResultsOfMyApproved() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
	}

//Sent for Approval

	@When("^i click on sent for Approval button$")
	public void clickSentApprovalButton() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
		approvalsPage.clickOnElementUsingActions(approvalsPage.sentForApproval);

	}

	@Then("^verify the results of sent for Approval$")
	public void verifyResultsOfMyApproval() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
	}
//For your Approval

	@And("^i click on for your approval button$")
	public void clickForYourApprovalButton() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
		approvalsPage.clickOnElementUsingActions(approvalsPage.forYourApproval);

	}
	
	@And("^i click on approve button under action for selected task$")
	public void clickOnApproveButton() throws InterruptedException, TimeoutException {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
		Thread.sleep(2000);
		approvalsPage.waitForElementToBeClickable(approvalsPage.forYourApprovalTable);
		String titleDate = testcontext.getScenarioContext().getContextMethod("titleKey").toString();
  	Thread.sleep(5000);
  	approvalsPage.getTitleCellToApprove(titleDate).click();

	}

	@Then("^verify the results present on for your approval page$")
	public void verifyResultsOfForYourApproval() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
	}

//Due date Request
	@When("^i click on due date request button$")
	public void clickDueDateRequestButton() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
		approvalsPage.clickOnElementUsingActions(approvalsPage.dueDateRequest);
	}

	@Then("^verify the results of due date request$")
	public void verifyResultsOfDueDateRequest() {
		approvalsPage.waitForPageToLoad(approvalsPage.getTitle());
	}

}
