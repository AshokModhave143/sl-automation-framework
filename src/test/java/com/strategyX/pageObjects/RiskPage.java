package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sltest.core.CommonMethods;

public class RiskPage extends CommonMethods {
	WebDriver driver;

	public RiskPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//page elements
	public By riskMenuLink = By.xpath("//div[@id='side-menu']//li//a[@href='/risks']");
	public By addRisk = By.xpath("//button[@class='btn btn-custom btn-primary riskModule']");
	public By unwantedEvent = By.id("unwanted-event");
	public By consequenceCategory = By.name("risk_consequence_category");
	public By riskCategory = By.xpath("//select[@id='risk-category']/following-sibling::span");
	public By selectRiskCategory = By.xpath("//li[text()='Economic and Financial']");
	public By riskSubCategory = By.xpath("//select[@id='risk_subcategory']/following-sibling::span");
	public By selectRiskSubCategory = By.xpath("//li[text()='Global Financial Events']");
	public By dueDate = By.name("duedate");
	public By selectAddDueDate = By.xpath(
			"//div[@class='daterangepicker dropdown-menu daterangepicker-view ltr single opensright show-calendar']//ul/li[@data-key='NextWeekSameDay5pm']");
	public By assignedTo = By.name("assigned");
	public By approvedBy = By.name("approved");
	public By inherentRiskRating = By.xpath("//div[@class='form-control choose-level pointer']");
	public By selectInherentRiskRating = By.xpath("//div[@id='modal-level-chooser']//table/tbody/tr[4]/td[5]");
	public By doneInherentRiskRating = By
			.xpath("//h4[contains(text(),'Choose Inherent Risk')]/div[@class='pull-right']/button[text()='Done']");
	public By residualRiskRating = By.xpath("//div[@class='form-control choose-residual-risk-rating pointer']");
	public By selectResidualRiskRating = By
			.xpath("//div[@id='modal-residual-risk-rating-chooser']//table/tbody/tr[2]/td[5]");
	public By doneResidualRiskRating = By
			.xpath("//h4[contains(text(),'Choose Residual')]/div[@class='pull-right']/button[text()='Done']");

	public By saveAndExit = By.id("btn-add-risk");

	public By noButtonForFirstAction = By.xpath("//div[@class='swal2-buttonswrapper']//button[text()='No']");

	// locate verify added risk
	public By riskTable = By.xpath("//table[@id='risks-table']");

	public boolean isTableContainsText(WebElement table, String text) {
		if (table.getText().contains(text)) {
			return true;
		}

		return false;

	}

	// update risk module

	public WebElement getRiskTitleCell(String unwantedEvent) throws TimeoutException {
		WebElement baseTable = driver.findElement(riskTable);
		By cellElement = By.xpath("//*[@id='risks-table']/tbody//td/a[contains(text(),'" + unwantedEvent + "')]");
		this.waitForElementVisibility(cellElement);
		WebElement cellNeed = baseTable.findElement(cellElement);

		return cellNeed;
		}
	
	
	public By riskrDescriptionSpan = By.id("description-span");
	public By riskDescriptionInput = By.xpath("//div[@id='description-input-div']/*[@id='description-input']");
	public By saveRiskFactor = By.xpath("//button[text()='Save & Exit']");
	public By yesButton = By.xpath("//button[text()='Yes']");
	
	//delete risk
	
	public By dataTableDots =  By.xpath("//td[@class=' text-center datatable-dots']/span[@class='dropdown-toggle']/img");
	
	public WebElement getRiskThreeDotsCell(String unwantedEvent) throws TimeoutException {
		WebElement baseTable = driver.findElement(riskTable);
		By cellElement = By.xpath("//*[@id='risks-table']/tbody//tr/a[contains(text(),'" + unwantedEvent + "')]");
		this.waitForElementVisibility(cellElement);
		WebElement cellNeed = baseTable.findElement(cellElement);

		return cellNeed;

	}
	
	public List<WebElement> getrows(){
		WebElement table = driver.findElement(riskTable);
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		
		return rows;
		
	}
	
	public WebElement findRowContainsText(String unwantedEvent) {
		List<WebElement> rows = getrows();
		
		for(int i=0; i < rows.size(); i++) {
			boolean isTextExistInRow = rows.get(i).getText().contains(unwantedEvent);
			if(isTextExistInRow) {
				return rows.get(i);
			}
		}
		return null;
	}
	
	public List<WebElement> getColumns(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		return columns;
	}
	
	public WebElement getThreeDotCell(String unwantedEvent) throws TimeoutException {
		
		WebElement row = findRowContainsText(unwantedEvent);
		if(row != null) {
			List<WebElement> columns = getColumns(row);
			
			return columns.get(9);
		} else {
			return null;
		}
	}
	
	public By deleteRiskButton = By.xpath("//li/a[@class='delete-task pointer']");
}
