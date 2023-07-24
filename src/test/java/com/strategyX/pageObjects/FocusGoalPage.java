package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sltest.core.CommonMethods;

public class FocusGoalPage extends CommonMethods {
	WebDriver driver;

	public FocusGoalPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}
	// add focus goal elements

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

	// public By focusGoalsModule =
	// By.xpath("//div[@id='side-menu']//li//a[@href='/focuses']");
	public By addButton = By.xpath("//div/button[text()='+ Add']");

	public String getTitleFocusGoal() {
		WebElement baseTable = driver.findElement(By.id("focuses-table"));
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"focuses-table\"]/tbody/tr[1]"));
		WebElement cellINeed = tableRow.findElement(By.xpath("//*[@id=\"focuses-table\"]/tbody/tr[1]/td[3]"));
		String valueCell = cellINeed.getText();
		System.out.println(valueCell);

		return valueCell;
	}

	// verify add
	public boolean isTableContainsText(WebElement table, String text) {
		if (table.getText().contains(text)) {
			return true;
		}

		return false;

	}

	// add action under focus goal
	public By threeDots = By.xpath("//*[@id=\"focuses-table\"]/tbody/tr/td[10]");
	public By addActionButton = By.xpath("//td[contains(@class,'text-center datatable-dots open')]//a[@data-url='/action-logs/add']");
	public By asignedToAction_focusGoal = By.xpath("//select[@name='assigned']");
	public By titleAddAction = By.id("title");
	public By approvedByAction_focusGoal = By.id("approved");
	public By successFactor = By.name("success_factor");

	public By duedateAction_focusGoal = By.name("duedate");
	public By selectDueDate_addActionFocusGoal = By
			.xpath("//div[contains(@class,'opensright show-calendar')]//li[text()='Tomorrow - 5pm']");
	public By save_addAction = By.xpath("//button[@id='btn-add-action']");

	// verify added action under update focus factor
	public By actionsMenuLink = By.xpath("//div[@id='side-menu']//li//a[@href='/action-logs']");

	public By actionTable = By.id("actionlogs-table");

	
	

	
	

	// locate elements on page focus goal to delete focus goal
	public By dataTableDots = By.xpath("//td[@class=' text-center datatable-dots']/span[@class='dropdown-toggle']");
	public By deleteFocusGoalButton = By.xpath("//li/a[@class='delete-task']");
	public By yesButton = By.xpath("//button[text()='Yes']");
	public By focusTable = By.id("focuses-table");

	//
	public List<WebElement> getRows() {
		WebElement tbl = driver.findElement(focusTable);
		WebElement tbody = tbl.findElement(By.tagName("tbody"));
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		
		return rows;
	}
	
	public List<WebElement> getColumns(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		return columns;
	}
	
	public WebElement findRowContainsText(String fromDate) {
		List<WebElement> rows = getRows();
		
		for(int i=0; i < rows.size(); i++) {
			boolean isTextExistInRow = rows.get(i).getText().contains(fromDate);
			if(isTextExistInRow) {
				return rows.get(i);
			}
		}
		return null;
	}
	
	public WebElement getThreeDotCell(String fromDate) throws TimeoutException {
		// find table & rows
		WebElement row = findRowContainsText(fromDate);
		if(row != null) {
			List<WebElement> columns = getColumns(row);
			
			return columns.get(9);
		} else {
			return null;
		}
	}

}
