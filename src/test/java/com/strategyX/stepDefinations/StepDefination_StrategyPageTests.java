package com.strategyX.stepDefinations;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import com.sltest.core.CreateSession;
import com.strategyX.pageObjects.StrategyPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination_StrategyPageTests {
	private StrategyPage strategyPage;
	private WebDriver driver;

	public StepDefination_StrategyPageTests() throws IOException {
		driver = CreateSession.getWebDriver();
		strategyPage = new StrategyPage(driver);
	}

	@Given("^i am on strategy page$")
	public void goToStrategyModule() throws InterruptedException, TimeoutException {
		Thread.sleep(1000);
		strategyPage.scrollToElement(strategyPage.strategyModule);
		strategyPage.waitForElementToBeClickable(strategyPage.strategyModule);
        strategyPage.clickOnElementUsingActions(strategyPage.strategyModule);
	}

	@When("^edit vision$")
	public void editVision() throws TimeoutException, InterruptedException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		Thread.sleep(3000);
		//strategyPage.waitForElementToBeClickable(strategyPage.vision);
		strategyPage.clickOnElementUsingActions(strategyPage.vision);
		strategyPage.switchToDialogWindow();
		Thread.sleep(2000);
		strategyPage.waitForElementVisibility(strategyPage.editVision);
		strategyPage.clickOnElementUsingActions(strategyPage.editVision);
		strategyPage.waitForElementToBeClickable(strategyPage.visionText);
		strategyPage.findElement(strategyPage.visionText).clear();
		strategyPage.findElement(strategyPage.visionText).sendKeys("abcd");
		strategyPage.clickOnElementUsingActions(strategyPage.saveVisionButton);
	}

	@And("^edit mission$")
	public void editMission() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.mission);
		strategyPage.clickOnElementUsingActions(strategyPage.mission);
		strategyPage.waitForElementVisibility(strategyPage.editMission);
		strategyPage.clickOnElementUsingActions(strategyPage.editMission);
		strategyPage.waitForElementToBeClickable(strategyPage.missionText);
		strategyPage.findElement(strategyPage.missionText).clear();
		strategyPage.findElement(strategyPage.missionText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveMissionButton);

	}

	@And("edit values$")
	public void editValues() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.values);
		strategyPage.clickOnElementUsingActions(strategyPage.values);
		strategyPage.waitForElementVisibility(strategyPage.editValues);
		strategyPage.waitForElementToBeClickable(strategyPage.editValues);
		strategyPage.clickOnElementUsingActions(strategyPage.editValues);
		strategyPage.waitForElementToBeClickable(strategyPage.ValuesText);
		strategyPage.findElement(strategyPage.ValuesText).clear();
		strategyPage.findElement(strategyPage.ValuesText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveValuesButton);

	}
	@And("edit culture$")
	public void editCulture() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.culture);
		strategyPage.clickOnElementUsingActions(strategyPage.culture);
		strategyPage.waitForElementVisibility(strategyPage.editCulture);
		strategyPage.waitForElementToBeClickable(strategyPage.editCulture);
		strategyPage.clickOnElementUsingActions(strategyPage.editCulture);
		strategyPage.waitForElementToBeClickable(strategyPage.cultureText);
		strategyPage.findElement(strategyPage.cultureText).clear();
		strategyPage.findElement(strategyPage.cultureText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveCultureButton);

	}


	@And("edit strengths$")
	public void editStrengths() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.strengths);
		strategyPage.clickOnElementUsingActions(strategyPage.strengths);
		strategyPage.waitForElementVisibility(strategyPage.editStrengths);
		strategyPage.waitForElementToBeClickable(strategyPage.editStrengths);
		strategyPage.clickOnElementUsingActions(strategyPage.editStrengths);
		strategyPage.waitForElementToBeClickable(strategyPage.strengthsText);
		strategyPage.findElement(strategyPage.strengthsText).clear();
		strategyPage.findElement(strategyPage.strengthsText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveStrengthsButton);

	}

	@And("edit weaknesses$")
	public void editWeaknesses() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.weaknesses);
		strategyPage.clickOnElementUsingActions(strategyPage.weaknesses);
		strategyPage.waitForElementVisibility(strategyPage.editWeaknesses);
		strategyPage.waitForElementToBeClickable(strategyPage.editWeaknesses);
		strategyPage.clickOnElementUsingActions(strategyPage.editWeaknesses);
		strategyPage.waitForElementToBeClickable(strategyPage.weaknessesText);
		strategyPage.findElement(strategyPage.weaknessesText).clear();
		strategyPage.findElement(strategyPage.weaknessesText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveWeaknessesButton);

	}

	@And("edit opportunities$")
	public void editOpportunities() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.opportunities);
		strategyPage.clickOnElementUsingActions(strategyPage.opportunities);
		strategyPage.waitForElementVisibility(strategyPage.editOpportunities);
		strategyPage.clickOnElementUsingActions(strategyPage.editOpportunities);
		strategyPage.waitForElementToBeClickable(strategyPage.opportunitiesText);
		strategyPage.findElement(strategyPage.opportunitiesText).clear();
		strategyPage.findElement(strategyPage.opportunitiesText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveOpportunitiesButton);

	}

	@And("edit threats$")
	public void editThreats() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.threats);
		strategyPage.clickOnElementUsingActions(strategyPage.threats);
		strategyPage.waitForElementVisibility(strategyPage.editThreats);
		strategyPage.clickOnElementUsingActions(strategyPage.editThreats);
		strategyPage.waitForElementToBeClickable(strategyPage.threatsText);
		strategyPage.findElement(strategyPage.threatsText).clear();
		strategyPage.findElement(strategyPage.threatsText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveThreatsButton);

	}

	@And("edit core competencies$")
	public void editCoreCompetencies() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.coreCompetencies);
		strategyPage.clickOnElementUsingActions(strategyPage.coreCompetencies);
		strategyPage.waitForElementVisibility(strategyPage.editCoreCompetencies);
		strategyPage.clickOnElementUsingActions(strategyPage.editCoreCompetencies);
		strategyPage.waitForElementToBeClickable(strategyPage.coreCompetenciesText);
		strategyPage.findElement(strategyPage.coreCompetenciesText).clear();
		strategyPage.findElement(strategyPage.coreCompetenciesText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveCoreCompetenciesButton);

	}

	@And("edit core business$")
	public void editCoreBusinessText() throws TimeoutException {
		strategyPage.waitForPageToLoad(strategyPage.getTitle());
		strategyPage.waitForElementToBeClickable(strategyPage.coreBusiness);
		strategyPage.clickOnElementUsingActions(strategyPage.coreBusiness);
		
		strategyPage.waitForElementVisibility(strategyPage.editCoreBusiness);
		strategyPage.clickOnElementUsingActions(strategyPage.editCoreBusiness);
		
		strategyPage.waitForElementToBeClickable(strategyPage.coreBusinessText);
		strategyPage.findElement(strategyPage.coreBusinessText).clear();
		strategyPage.findElement(strategyPage.coreBusinessText).sendKeys("Test");
		strategyPage.clickOnElementUsingActions(strategyPage.saveCoreBusinessButton);
		strategyPage.waitForPageToLoad(strategyPage.getTitle());

	}

	@Then("^strategy is added$")
	public void verifyVision() {

		System.out.println("success");

	}

}
