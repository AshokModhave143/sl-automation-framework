package com.strategyX.pageObjects;

import java.io.IOException;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sltest.core.CommonMethods;

public class HomePage extends CommonMethods {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) throws IOException {
		super(driver);
		this.driver = driver;
	}
	
	// Page elements
	public By userProfileLogo = By.xpath("//div[@class='user-text profile-company']");
	public By actionsMenuLink = By.xpath("//a[@class='image_with_text active']");
	public By logoutMenuLink = By.linkText("Logout");
	
	
	
	
//	public void verifylogo() {
//		String userProfile = driver.findElement(By.xpath("//div[@class='user-text profile-company']")).getText();
//		Assert.assertEquals(userProfile, "Stream-Line AU");
//	}
//
//	public void clickonActionModule() throws InterruptedException {
//		WebElement Actions = driver.findElement(By.xpath("//a[@class='image_with_text active']"));
//		Actions.click();
//		Thread.sleep(5000);
//		int rowcount = driver.findElements(By.xpath("//table[@id='actionlogs-table']/tbody/tr")).size();
//		int columncount = driver.findElements(By.xpath("//table[@id='actionlogs-table']/thead/tr/th")).size();
//
//		System.out.println("Number of Actions in Action List is: " + rowcount);
//		System.out.println("column count is: " + columncount);
//	}
//
//	public void goToActionModule() throws InterruptedException {
//		WebElement Actions = driver.findElement(By.xpath("//a[@class='image_with_text active']"));
//		Actions.click();
//		Thread.sleep(5000);
//		
//	}
//
	public void getActionCount() {
		int rowcount = driver.findElements(By.xpath("//table[@id='actionlogs-table']/tbody/tr")).size();
		int columncount = driver.findElements(By.xpath("//table[@id='actionlogs-table']/thead/tr/th")).size();

		System.out.println("Number of Actions in Action List is: " + rowcount);
		System.out.println("column count is: " + columncount);
	
		
	}
}