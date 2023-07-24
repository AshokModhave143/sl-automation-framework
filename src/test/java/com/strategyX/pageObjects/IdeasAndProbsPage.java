package com.strategyX.pageObjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.sltest.core.CommonMethods;

public class IdeasAndProbsPage extends CommonMethods {
	WebDriver driver;
	public IdeasAndProbsPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//page elements
		public By ideasAndProbsMenuLink = By.xpath("//div[@id='side-menu']//li//a[@href='/ideas-and-problems']");
		public By addButton = By.xpath("//button[@class='btn btn-custom btn-primary dropdown-toggle']");
		public By addIdeaButton = By.xpath("//a[@class='ideasAndProblemsModule link-add-idea']");
		public By ideaInput = By.name("title");
		public By saveAndExit = By.id("btn-add-risk");

		// locate verify added ideas
		public By ideaTable = By.xpath("//table[@aria-describedby='ideasandproblems-table_info']");

//		public boolean isTableContainsText(By tableElement, String text) {
//			
//			// for(int i=0; i<=2;i++){
//			  try{
//			     WebElement table = driver.findElement(tableElement);
//
//				if (table.getText().contains(text)) {
//					return true;
//				} else {
//					return false;
//				}
//			  }
//			  catch(Exception e){
//			     System.out.println(e.getMessage());
//			     return false;
//			  }
			//}
	//	}
		
		public boolean isTableContainsText(WebElement table, String text) {
			String contentTable =table.getText();
			System.out.println(contentTable);
			if (table.getText().contains(text)) {
				return true;
			}

			return false;

		}
		
		
		public By ideasSave = By.xpath("//button[text()='Save & Exit']");
		
		
		//update idea
		
		public WebElement getRiskTitleCell(String ideaInput) throws TimeoutException {
			WebElement baseTable = driver.findElement(ideaTable);
			By cellElement = By.xpath("//*[@id='ideasandproblems-table']/tbody//td/a[contains(text(),'" + ideaInput + "')]");
			this.waitForElementVisibility(cellElement);
			WebElement cellNeed = baseTable.findElement(cellElement);

			return cellNeed;
			}
		
		public By ideaDescriptionSpan = By.id("description-span");
		public By ideaDescriptionInput = By.xpath("//div[@id='description-input-div']/*[@id='description-input']");
		public By saveIdeaFactor = By.xpath("//button[text()='Save & Exit']");
	
		
		//delete idea
		
		public By dataTableDots =  By.xpath("//td[@class=' datatable-dots text-center']/span[@class='dropdown-toggle']/img");
		
	
		
		public WebElement getIdeasThreeDotsCell(String ideaInput) throws TimeoutException {
			
			WebElement row = findRowContainsText(ideaInput);
			if(row != null) {
				List<WebElement> columns = getColumns(row);
				
				return columns.get(11);
			} else {
				return null;
			}
		}

		public WebElement findRowContainsText(String ideaInput) {
			List<WebElement> rows = getrows();
			
			for(int i=0; i < rows.size(); i++) {
				boolean isTextExistInRow = rows.get(i).getText().contains(ideaInput);
				if(isTextExistInRow) {
					return rows.get(i);
				}
			}
			return null;
		}
		
		public List<WebElement> getrows(){
			WebElement table = driver.findElement(ideaTable);
			WebElement tbody = table.findElement(By.tagName("tbody"));
			List<WebElement> rows = tbody.findElements(By.tagName("tr"));
			
			return rows;
			
		}
		
		public List<WebElement> getColumns(WebElement row) {
			List<WebElement> columns = row.findElements(By.tagName("td"));
			return columns;
		}
		
		public By deleteButton = By.xpath("//td[@class='text-center datatable-dots open']//li/a[@class='delete-task']");

}
