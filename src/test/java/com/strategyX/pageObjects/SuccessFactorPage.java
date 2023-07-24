package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sltest.core.CommonMethods;

public class SuccessFactorPage extends CommonMethods {
	WebDriver driver;

	public SuccessFactorPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locate elements on page SuccessFactor for add SuccessFactor
	public By successFactorModule = By.xpath("//span[text()='Success Factors' and contains(@class, 'side-menu')]");
	public By addButton = By.xpath("//div/a[text()='+ Add']");
	public By successFactorInput = By.id("critical-success-factor-name");
	public By assignedToDropDown = By.id("assigned");
	public By reportTitleInput = By.name("report_title");
	public By graphType = By.id("graph_type");
	public By saveAndExitButton = By.id("btn-add-success-factor");

	// locate elements on success factor page for verify added success factor
	public By successFactorTable = By.id("critical-success-factor-table");

	public By verifyAddedSuccessFactor = By
			.xpath("//table[@id='critical-success-factor-table']/tbody/tr[1]/td/a[contains(text(),'test1')]");

	// locate elements on page SuccessFactor to delete SuccessFactor
	public By dataTableDots = By.xpath("//td[@class=' text-center datatable-dots']/span[@class='dropdown-toggle']/img");

	public By deleteSuccessFactorButton = By
			.xpath("//td[contains(@class, 'datatable-dots')]/ul/li/a[@class='delete-task']");
	public By yesButton = By.xpath("//button[text()='Yes']");

	// Helper functions

	// get table element
	// get headers
	// get rows
	public boolean isSuccessFactorPresent(String value) {
		List<String> successFactorList = getSuccessFactorTableRows();

		for (int i = 0; i < successFactorList.size(); i++) {
			if (successFactorList.get(i).equals(value))
				return true;
		}
		return false;

	}

	public List<String> getSuccessFactorTableRows() {
		List<String> tableValues = new ArrayList<String>();

		WebElement tbl = driver.findElement(successFactorTable);
		WebElement tbody = tbl.findElement(By.tagName("tbody"));

		// check all row, identification with 'tr' tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		// row iteration
		for (int i = 0; i < rows.size(); i++) {
			// check column each in row, identification with 'td' tag
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

			tableValues.add(cols.get(2).getText());

		}
		return tableValues;

	}

//update success factor elements	
	public List<WebElement> getRows() {

		WebElement tbl = driver.findElement(successFactorTable);
		WebElement tbody = tbl.findElement(By.tagName("tbody"));

		// check all row, identification with 'tr' tag
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));

		return rows;

	}

	public List<WebElement> getColumns(WebElement row) {

		List<WebElement> cols = row.findElements(By.tagName("td"));
		return cols;

	}

	public List<WebElement> findRow(String successFactor) {

		List<WebElement> successFactorRows = getRows();

		for (int i = 0; i < successFactorRows.size(); i++) {
			List<WebElement> successFactorColumns = getColumns(successFactorRows.get(i));

			if (successFactorColumns.get(2).getText().equals(successFactor)) {
				return successFactorColumns;
			}
		}

		return null;
	}

	public WebElement findViewReportLink(String successFactor) {
		List<WebElement> ele = findRow(successFactor);
		return ele.get(6).findElement(By.tagName("a"));

	}

	// locating elements to update success factor
	// public By successFactorName = By.xpath("//td[contains(@class,
	// 'table-text-title')]");
	public By successFactorDescriptionSpan = By.id("description-span");
	public By successFactorDescriptionInput = By
			.xpath("//div[@id='description-input-div']/textarea[@id='description-input']");
	public By notesUpdatedSuccessFactor = By.id("comment_editor");
	public By postNotesButton = By.id("add-comment-submit");
	public By saveUpdateSuccessFactor = By.xpath("//button[text()='Save & Exit']");

	// locating elements to add focus goal under success factor update
	public By addButtonFocusGoal = By.xpath("//button[contains(@class,'focusModule pull-right')]");
	public By goFrom = By.name("go_from");
	public By goTo = By.name("go_to");
	public By focusGoalAssignedTo = By.id("assigned");
	public By focusGoalApprovedBy = By.id("approved");
	public By dueDate = By.id("due-date");
	// public By dueDateas26012021 = By.xpath("//div[@class='calendar left
	// single']//table[@class='table-condensed']/tbody/tr[4]/td[3]");
	public By dueDateas26012021 = By.xpath(
			"//div[contains(@class,'daterangepicker-grid ltr single opensright show-calendar')]//div[@style='display: block;']//td[text()='26']");
	public By selectDueDtae = By.xpath(
			"//div[contains(@class,'daterangepicker-grid ltr single opensright show-calendar')]//li[text()='Next Week Same Day - 5pm']");
	public By doneButtonDueDate = By.xpath("//div[contains(@class,'daterangepicker-grid ltr')]//button[text()='Done']");
	public By saveAndExitFocusGoal = By.id("btn-add-focus");
	public By noButtonForFirstAction = By.xpath("//div[@class='swal2-buttonswrapper']//button[text()='No']");
	public By verifyAddedFocusGoal = By.xpath("//div/h4/span[contains(text(),'Go from')]");
	public By focusGoalTitle = By.xpath("//td[contains(@class,'view-focus-goal')]");
	public By focusGoalsModule = By.xpath("//div[@id='side-menu']//li//a[@href='/focuses']");

	public WebElement getSuccessFactorTitleCell(String expectedTitleSuccessFactor) throws TimeoutException {
		WebElement baseTable = driver.findElement(By.id("critical-success-factor-table"));
		By cellElement = By.xpath("//*[@id='critical-success-factor-table']/tbody//td/a[contains(text(),'"
				+ expectedTitleSuccessFactor + "')]");
		this.waitForElementVisibility(cellElement);
		WebElement cellNeed = baseTable.findElement(cellElement);

		return cellNeed;
	}

	public String getSuccessFactorTitleCellText(String expectedTitleSuccessFactor) throws TimeoutException {
		String actualTitle = "";
		for(int i=0; i<=2; i++) {
			// TODO: Handle staleness of element later
			try {
				actualTitle = getSuccessFactorTitleCell(expectedTitleSuccessFactor).getText();
				break;
			} catch (StaleElementReferenceException e) {
				System.out.println("Attempt number: " + i + " : Element is staled. try again.");
			}
		}
		return actualTitle;
	}
	
	//locate elements to delete all success factor
	
//	public List<String> getSuccessFactorTableRows() {
//		List<String> tableValues = new ArrayList<String>();
//
//		WebElement tbl = driver.findElement(successFactorTable);
//		WebElement tbody = tbl.findElement(By.tagName("tbody"));
//
//		// check all row, identification with 'tr' tag
//		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
//
//		// row iteration
//		for (int i = 0; i < rows.size(); i++) {
//			// check column each in row, identification with 'td' tag
//			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
//
//			tableValues.add(cols.get(2).getText());
//
//		}
//		return tableValues;
//
//	}


}
