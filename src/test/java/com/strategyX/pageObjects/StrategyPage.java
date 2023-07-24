package com.strategyX.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sltest.core.CommonMethods;

public class StrategyPage extends CommonMethods {

	public StrategyPage(WebDriver driver) throws IOException {
		super(driver);
		
	}
	
	//locate elements from vision
	
	//public By strategyModule = By.xpath("//li//*[text()='Strategy']");
	public By strategyModule = By.xpath("//div[@id='side-menu']//li/a[@href='/strategy']");
	public By vision = By.xpath("//h3[contains(text(),'Vision')]");
	public By editVision= By.xpath("//span[text()='Edit' and @data-section='vision']");
	public By visionText = By.name("vision_text");
	public By saveVisionButton=By.id("save-strategy-section");
	
	//locate elements from mission
	
	public By mission = By.xpath("//h3[contains(text(), 'Mission')]");
	public By editMission = By.xpath("//span[@data-section='mission' and text()='Edit']");
	public By missionText = By.name("mission_text");
	public By saveMissionButton=By.id("save-strategy-section");
	
	//locate elements from values
	
		public By values = By.xpath("//h3[contains(text(), 'Values')]");
		public By editValues = By.xpath("//span[@data-section='values' and text()='Edit']");
		public By ValuesText = By.name("values_text");
		public By saveValuesButton=By.id("save-strategy-section");

		//locate elements from culture
		
		public By culture = By.xpath("//h3[contains(text(), 'Culture')]");
		public By editCulture = By.xpath("//span[@data-section='culture' and text()='Edit']");
		public By cultureText = By.name("culture_text");
		public By saveCultureButton=By.id("save-strategy-section");

		//locate elements from strengths
		
		public By strengths = By.xpath("//h3[contains(text(), 'Strengths')]");
		public By editStrengths = By.xpath("//span[@data-section='strengths' and text()='Edit']");
		public By strengthsText = By.name("strengths_text");
		public By saveStrengthsButton=By.id("save-strategy-section");

		//locate elements from weaknesses
		
		public By weaknesses = By.xpath("//h3[contains(text(), 'Weaknesses')]");
		public By editWeaknesses = By.xpath("//span[@data-section='weaknesses' and text()='Edit']");
		public By weaknessesText = By.name("weaknesses_text");
		public By saveWeaknessesButton=By.id("save-strategy-section");

		//locate elements from opportunities
		
		public By opportunities = By.xpath("//h3[contains(text(), 'Opportunities')]");
		public By editOpportunities = By.xpath("//span[@data-section='opportunities' and text()='Edit']");
		public By opportunitiesText = By.name("opportunities_text");
		public By saveOpportunitiesButton=By.id("save-strategy-section");

		//locate elements from threats
		
		public By threats = By.xpath("//h3[contains(text(), 'Threats')]");
		public By editThreats = By.xpath("//span[@data-section='threats' and text()='Edit']");
		public By threatsText = By.name("threats_text");
		public By saveThreatsButton=By.id("save-strategy-section");

		//locate elements from core business
		
		public By coreBusiness = By.xpath("//h3[contains(normalize-space(),'Core Business')]");
		public By editCoreBusiness = By.xpath("//span[text()='Edit' and @data-section='core_Business']");
		public By coreBusinessText = By.id("core_business-text");
		public By saveCoreBusinessButton=By.id("save-strategy-section");

		//locate elements from core competencies
		
		public By coreCompetencies = By.xpath("//h3[contains(normalize-space(),'Core Competencies')]");
		public By editCoreCompetencies = By.xpath("//span[@data-section='core_Competencies' and text()='Edit']");
		public By coreCompetenciesText = By.id("core-competenc-text-0-name");
		public By saveCoreCompetenciesButton=By.id("save-strategy-section");


}
