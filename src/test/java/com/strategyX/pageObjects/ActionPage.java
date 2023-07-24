package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sltest.core.CommonMethods;

public class ActionPage extends CommonMethods {
	WebDriver driver;
	public ActionPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}

	// Page elements
	public By actionsMenuLink = By.xpath("//a[@class='image_with_text active']");
	public By addAction = By.xpath("//button[@class='btn btn-custom btn-primary dropdown-toggle m-l-10 actionLogModel']");
	public By title = By.name("title");
	public By description = By.name("description");
	// public By relatedTo=By.id("title");

	public By assignedTo = By.id("assigned");
	public By approvedBy = By.id("approved");
	public By dueDate = By.name("duedate");

	public By selectAddDueDate = By.xpath(
			"//div[contains(@class, 'daterangepicker dropdown-menu daterangepicker-grid ltr single opensright show-calendar')]/div[@class='custom-quick-options']/ul/li[@data-key='NextWeekSameDay5pm']");
	public By Done = By.xpath(
			"//div[contains(@class, 'daterangepicker dropdown-menu daterangepicker-grid ltr single opensright show-calendar')]//button[text()='Done'];");
	public By notesInput = By.id("add-comment_editor");
	public By duration = By.id("duration");
	public By workDate = By.id("work-date");
	public By selectWorkDate = By.xpath(
			"//div[@class='daterangepicker dropdown-menu daterangepicker-grid ltr single opensright show-calendar'][contains(@style, 'display: block')]//li[@data-key='Tomorrow5pm']");
	public By postNoteButtonButton = By.id("add-note");
	public By addAttachmentButton = By.id("file-add");
	public By addVoiceButton = By.id("add-voice-note-for-add");
	public By subTasksButton = By.xpath("//a[@href='#subtasks-add']");
	public By plusSubTaskButton = By.id("btn-a-st");
	public By subtaskname = By.id("subtask_name");

	public By saveAndExit = By.id("btn-add-action");
	public By cancelButton = By.xpath(
			"//form[@id='add-action-log-form']//button[text()='Cancel' and @class='btn btn-secondary cancel_btn']");

	public By table = By.id("actionlogs-table");

	//verify add
	
	public boolean isTableContainsText(WebElement table, String text) {
		if (table.getText().contains(text)) {
			return true;
		}

		return false;

	}

	// Helper methods
	public By getDatePickerXpath(boolean isQuickOption, String value) {
		String datePickerRootXPath = "//div[contains(@class, 'daterangepicker dropdown-menu daterangepicker-grid ltr single opensright show-calendar')]";
		String path = "";

//		if(isQuickOption) {
//			// select quick option
//			switch(value) {
//				case "NextWeekSameDay5pm":
//			}
//		} else {
//			// select date
//		}

		return By.xpath(path);
	}

	public boolean isRegistered(WebElement table, String Action1) {
		for (WebElement row : table.findElements(By.tagName("tr"))) {
			if (row.getText().contains(Action1)) {
				return true;
			}
		}
		return false;
	}

	public WebElement getAddedRow(WebElement table, String Action1) {
		for (WebElement row : table.findElements(By.tagName("tr"))) {
			if (row.getText().contains(Action1)) {
				return row;
			}

		}
		return null;
	}

	public boolean deleteAddedAction(WebElement table, String action) {
		WebElement row = getAddedRow(table, action);
		if (row == null)
			return false;

		WebElement deleteButton = row.findElement(By.xpath("//a[@class='delete-task']"));
		deleteButton.click();

		return true;
	}

	// edit Actions section

	// edit Due date

	public By editDueDate = By.xpath("//table[@id='actionlogs-table']/tbody/tr[1]/td[8]/a");
	public By selectEditDueDateOrignal = By.xpath(
			"//div[contains(@class, 'daterangepicker dropdown-menu daterangepicker-grid ltr single openscenter show-calendar')]/div[@class='custom-quick-options']/ul/li[@data-key='NextWeekSameDay5pm']");
    public By EditDueDateInput = By.xpath("//input[@name='change_duedate_grid']");

    
    //edit priority Date

	public By priorityDate = By.xpath("//table[@id='actionlogs-table']/tbody/tr[1]/td[6]/a");
	public By selectpriorityDate = By.xpath(
			"//div[contains(@class, 'daterangepicker dropdown-menu daterangepicker-grid ltr single openscenter show-calendar')]/div[@class='custom-quick-options']/ul/li[@data-key='Tomorrow5pm']");

// Dialog
	public By excludedButton = By.xpath("//button[text()='Excluded']");

// Change current due date to revised due date

//	public void revisedDuedate() {
//		waitForElementToBeClickable(editDueDate);
//		clickOnElementUsingActions(editDueDate);

//		waitForElementVisibility(selectEditDueDate);

//		actionPage.findElement(actionPage.selectEditDueDate).click();
//
//		// switch to pop up
//		actionPage.switchToDialogWindow();
//
//		actionPage.clickOnElementUsingActions(actionPage.excludedButton);
//
//		// switch to parent window
//
//		actionPage.switchToParentWindow();
//	}

		// delete action
		public By threedots = By.xpath("//img[@src='/images/svg/3dots-gray.svg']");
        public By deleteButton = By.xpath("//a[@class='delete-task']");
        
        
	//approval module test-case
        public WebElement getPercentageCompleteCell(String titleDate) throws TimeoutException {
    		// find table & rows
    		WebElement row = findRowContainsText(titleDate);
    		if(row != null) {
    			List<WebElement> columns = getColumns(row);
    			System.out.println(columns.get(6).getText());
    			 return columns.get(6);
    		} else {
    			return null;
    		}
    	}
        
        public List<WebElement> getColumns(WebElement row) {
    		List<WebElement> columns = row.findElements(By.tagName("td"));
    		return columns;
    	}
    	
    	public WebElement findRowContainsText(String titleDate) {
    		List<WebElement> rows = getRows();
    		
    		for(int i=0; i < rows.size(); i++) {
    			boolean isTextExistInRow = rows.get(i).getText().contains(titleDate);
    			if(isTextExistInRow) {
    				return rows.get(i);
    			}
    		}
    		return null;
    	}
    	
    	public List<WebElement> getRows() {
    		WebElement tbl = driver.findElement(table);
    		WebElement tbody = tbl.findElement(By.tagName("tbody"));
    		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
    		
    		return rows;
    	}
    	public By Hundred = By.xpath("//td[@id='gridCompleted100']");
    	public By savePercent = By.xpath("//button[text()='Save']");
    	
}