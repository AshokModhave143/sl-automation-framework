package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.sltest.core.TestContext;
import com.strategyX.pageObjects.IdeasAndProbsPage;
import com.strategyX.pageObjects.RiskPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;

public class StepDefination_IdeaAndProbTests {
	private TestContext testContext;
	private IdeasAndProbsPage ideasAndProbsPage;

	private WebDriver driver;

	public StepDefination_IdeaAndProbTests() throws IOException {
		testContext = TestContext.getTestContext();
		ideasAndProbsPage = testContext.getPageObjectManager().getIdeasAndProbsPage();
	}
	
	@Given("^i go to idea and probs module$")
	public void goToIdeaAndProbsModule() {
		ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());
		ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.ideasAndProbsMenuLink);
	}

	@When("^i go to add$")
	public void goToAddIdeaButton() throws TimeoutException {
		ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());
		ideasAndProbsPage.waitForElementToBeClickable(ideasAndProbsPage.addButton);
		ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.addButton);

	}
	
	@And("^i go to idea from dropdown$")
	public void goToAddActionButton() throws TimeoutException {
	ideasAndProbsPage.waitForElementToBeClickable(ideasAndProbsPage.addIdeaButton);
	ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.addIdeaButton);}
	
	@And("i give idea")
	public void enterIdea() throws TimeoutException {
		ideasAndProbsPage.waitForElementVisibility(ideasAndProbsPage.ideaInput);
		String ideaInput = "test " + ideasAndProbsPage.getTodaysDate();

		// setting this variable into context to access in other tests with key "expectedTitleSuccessFactor"
		testContext.getScenarioContext().setContextMethod("ideaKey", ideaInput);
		
		ideasAndProbsPage.findElement(ideasAndProbsPage.ideaInput).sendKeys(ideaInput);

	}
	
	@And("^i click on saveandExit button under Ideas and Probs$")
	public void clickSaveAndExit() {
		ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.ideasSave);
	}
	
	@Then("verify if idea is added as {string}")
	public void verifyaddedIdea(String value) throws TimeoutException, InterruptedException {
		ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());
		WebElement table = ideasAndProbsPage.findElement(ideasAndProbsPage.ideaTable);
		System.out.println(table.getText());   
		String ideaInput = testContext.getScenarioContext().getContextMethod("ideaKey").toString();
		System.out.println(table.getText()); 
		//ideasAndProbsPage.implicitWait(2000);
		//ideasAndProbsPage.refreshPage();
		boolean isTextPresent = ideasAndProbsPage.isTableContainsText(table, ideaInput);
		Assert.assertTrue(isTextPresent);
	}
	

	// update ideas and probs

	@When("^i click on IdeasAndProbs name$")
	public void clickOnIdeasAndProbsName() throws TimeoutException {

		ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());
		String Idea = testContext.getScenarioContext().getContextMethod("ideaKey").toString();

		ideasAndProbsPage.waitForElementToBeClickable(ideasAndProbsPage.ideaTable);
		ideasAndProbsPage.getRiskTitleCell(Idea).click();
	}

	@And("i enter description to update IdeasAndProbs as {string}")
	public void enterDescriptionToUpdateIdeasAndProbs(String value) throws TimeoutException, InterruptedException {
        ideasAndProbsPage.switchToDialogWindow();
		Thread.sleep(1000);
		ideasAndProbsPage.waitForElementVisibility(ideasAndProbsPage.ideaDescriptionSpan);
		ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.ideaDescriptionSpan);
		// riskPage.waitForElementVisibility(riskPage.riskDescriptionInput);
		ideasAndProbsPage.findElement(ideasAndProbsPage.ideaDescriptionInput).clear();
		Thread.sleep(1000);
		ideasAndProbsPage.findElement(ideasAndProbsPage.ideaDescriptionInput).sendKeys(value);
	}

	@And("^click on saveAndExit to update IdeasAndProbs$")
	public void clickOnsaveAndExit() throws TimeoutException {
		ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.saveIdeaFactor);
	}

	@Then("IdeasAndProbs description should be {string}")
	public void verifyDescription_Risk(String value) throws TimeoutException, InterruptedException {
		ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());
		String ideaInput = testContext.getScenarioContext().getContextMethod("ideaKey").toString();
		Thread.sleep(2000);
		ideasAndProbsPage.waitUntilStalenessOf(ideasAndProbsPage.getRiskTitleCell(ideaInput));
		
	    ideasAndProbsPage.getRiskTitleCell(ideaInput).click();
		ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());
		String actualDescription = ideasAndProbsPage.findElement(ideasAndProbsPage.ideaDescriptionSpan).getText();
		Assert.assertEquals(actualDescription, value);
		ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.saveIdeaFactor);
	}
	
	//delete added idea
	
	@When("^click on three datatable dots under idea module$")
	public void clickThreeDots() throws TimeoutException {
	ideasAndProbsPage.waitForPageToLoad(ideasAndProbsPage.getTitle());	
	ideasAndProbsPage.waitForElementToBeClickable(ideasAndProbsPage.ideaTable);
	String ideaInput = testContext.getScenarioContext().getContextMethod("ideaKey").toString();
	ideasAndProbsPage.getIdeasThreeDotsCell(ideaInput).click();
	}
	
	@And("^click on delete button under idea module$")
	public void clickDeleteUnderIdea() throws TimeoutException {
	ideasAndProbsPage.waitForElementVisibility(ideasAndProbsPage.deleteButton);
	ideasAndProbsPage.clickOnElementUsingActions(ideasAndProbsPage.deleteButton);	
		
	}
	
	@Then("^added idea should get deleted$")
	public void verifyDeletedIdea() {
		System.out.println("Added idea is deleted");
	}
	
	
	
	
}
