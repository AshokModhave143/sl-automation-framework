package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sltest.core.CommonMethods;

public class TacticalProjectsPage extends CommonMethods {
	WebDriver driver;

	public TacticalProjectsPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// page elements
	public By tacticalProjectsMenuLink = By.xpath("//div[@id='side-menu']//li//a[@href='/tactical-projects']");
	public By addTacticalProjects = By.xpath("//button[@class='btn btn-custom btn-primary tacticalModule']");
	public By projectName = By.name("project_name");
	public By category = By.id("category");
	public By assignedTo = By.id("assigned");
	public By approved = By.id("approved");
	public By dueDate = By.id("due-date");
	public By selectAddDueDate = By.xpath(
			"//div[@class='daterangepicker dropdown-menu daterangepicker-grid ltr single opensright show-calendar']//ul/li[@data-key='NextWeekSameDay5pm']");

	public By saveandexit = By.xpath("//button[@id='btn-add-tactical-project']");

	public By noButtonForFirstAction = By.xpath("//div[@class='swal2-buttonswrapper']//button[text()='No']");

	// locate verify added tactical project
	public By tacticalProjectsTable = By.xpath("//table[@id='tacticalprojects-table']");

	public boolean isTableContainsText(WebElement table, String text) {
		if (table.getText().contains(text)) {
			return true;
		}

		return false;

	}

	// update tactical project

	public WebElement getTacticalProjectTitleCell(String projectName) throws TimeoutException {
		WebElement baseTable = driver.findElement(tacticalProjectsTable);
		By cellElement = By.xpath("//*[@id='tacticalprojects-table']/tbody//td/a[contains(text(),'" + projectName + "')]");
		//this.waitForElementVisibility(cellElement);
		WebElement cellNeed = baseTable.findElement(cellElement);
		return cellNeed;

	}

	public By tacticalProjectDescriptionSpan = By.id("description-span");
	public By tacticalProjectDescriptionInput = By
			.xpath("//div[@id='description-input-div']/*[@id='description-input']");
	public By tacticalProjectSave = By.xpath("//button[text()='Save & Exit']");
	public By yesButton = By.xpath("//button[text()='Yes']");

	// delete tactical project
	
public By dataTableDots =  By.xpath("//td[@class=' text-center datatable-dots']/span[@class='dropdown-toggle']/img");
	
public WebElement getThreeDotsCell(String projectName) throws TimeoutException {
	
	WebElement row = findRowContainsText(projectName);
	if(row != null) {
		List<WebElement> columns = getColumns(row);
		
		return columns.get(9);
	} else {
		return null;
	}
}
	public List<WebElement> getrows(){
		WebElement table = driver.findElement(tacticalProjectsTable);
		WebElement tbody = table.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		
		return rows;
		
	}
	public WebElement findRowContainsText(String projectName) {
		List<WebElement> rows = getrows();
		
		for(int i=0; i < rows.size(); i++) {
			boolean isTextExistInRow = rows.get(i).getText().contains(projectName);
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

	public By deleteTacticalProjectsButton = By.xpath("//td[@class='text-center datatable-dots open']//li/a[@class='delete-task']");

}
