package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.sltest.core.CommonMethods;

public class ApprovalsPage extends CommonMethods{
WebDriver driver;
	public ApprovalsPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}
//page elements
	
	public By approvalModule = By.xpath("//div[@id='side-menu']//li/a[@href='/approvals']");
	public By myApproved = By.xpath("//a[@href='/approved']");
	public By sentForApproval = By.xpath("//a[@href='/sent-for-approvals']");
	public By forYourApproval = By.xpath("//ul[@class='nav nav-tabs main-tabs m-b-15 m-t-20']//a[@href='/approvals']");
	public By dueDateRequest = By.xpath("//a[@href='/revise-duedate-requests']");
	public By forYourApprovalTable = By.id("approvals-table");

//approval module test-case
public WebElement getTitleCellToApprove(String titleDate) throws TimeoutException {
	// find table & rows
	WebElement row = findRowContainsText(titleDate);
	if(row != null) {
		List<WebElement> columns = getColumns(row);
		System.out.println(columns.get(8).getText());
		WebElement actionColumnElement = columns.get(8);
		WebElement approveButtonElement = actionColumnElement.findElement(By.xpath("//button[text()='Approve']"));
		 return approveButtonElement;
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
	WebElement tbl = driver.findElement(forYourApprovalTable);
	WebElement tbody = tbl.findElement(By.tagName("tbody"));
	List<WebElement> rows = tbody.findElements(By.tagName("tr"));
	
	return rows;
}
}