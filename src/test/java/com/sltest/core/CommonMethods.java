package com.sltest.core;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sltest.helper.Logging;

public class CommonMethods {
	WebDriver driver = null;
	public final int timeOut = 45;

	public CommonMethods(WebDriver driver) throws IOException {
		this.driver = driver;
	}

	public void get(String url) {
		driver.get(url);
	}

	public void navigate(String url) {
		driver.navigate().to(url);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void acceptsAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void clickOnElementUsingActions(By saveAndExitButton) {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement((By) saveAndExitButton));
		actions.click().perform();
		//driver.findElement(saveAndExitButton).click();
	}

	public void clickOnElementUsingJs(By targetElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", driver.findElement(targetElement));
	}

	// Wait for page to load
	public void waitForPageToLoad(String pageName) {
		String pageLoadStatus;
		JavascriptExecutor js;

		do {
			js = (JavascriptExecutor) driver;
			pageLoadStatus = (String) js.executeScript("return document.readyState");
			Logging.info(".");
		} while (!pageLoadStatus.equals("complete"));

		Logging.info(pageName + " page loaded successfully");
	}

	// findElement
	public WebElement findElement(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			return element;
		} catch (NoSuchElementException e) {
			Logging.logError(this.getClass().getName(), "findElement", "Element not found" + locator);
			throw new NoSuchElementException();
		}
	}

	// Scroll to element
	public void scrollToElement(By targetElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(targetElement));
	}
	
	public void setValueToHiddenField(By targetElementId, String str) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementByName('gender').value=" + str);
		} catch (Exception ex) {
			
		}
	}

	// Element present check
	public Boolean isElementPresent(By targetElement) throws InterruptedException {
		Boolean isPresent = driver.findElements(targetElement).size() > 0;
		return isPresent;
	}

	public Boolean isElementNotPresent(By targetElement) throws InterruptedException {
		Boolean isPresent = (driver.findElements(targetElement).size() == 0);
		return isPresent;
	}

	// Wait for element to be - clickable, visible
	public boolean waitForElementVisibility(By targetElement) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
			return true;
		} catch (Exception e) {
			System.out.println("Element is not visible: " + targetElement);
			System.out.println(e.getMessage());
			throw new TimeoutException();
		}
	}

	public boolean waitForElementToBeClickable(By targetElement) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(targetElement));
			return true;
		} catch (Exception e) {
			System.out.println("Element is not clickable: " + targetElement);
			System.out.println(e.getMessage());
			throw new TimeoutException();
		}
	}

	public boolean waitUntilStalenessOf(WebElement targetElement) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until( ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(targetElement)));
			return true;
		} catch (StaleElementReferenceException ex) {
			System.out.println("Element is not staled: " + targetElement.getText());
			System.out.println(ex.getMessage());
			throw new TimeoutException();
		}
	}
	
	public boolean refreshPage() {
		driver.navigate().refresh();
		return true;
		}

	public boolean waitForInVisibility(By targetElement) throws TimeoutException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(targetElement));
			return true;
		} catch (Exception e) {
			System.out.println("Element is still visible: " + targetElement);
			System.out.println(e.getMessage());
			throw new TimeoutException();
		}
	}

	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	public void implicitWait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
		}
	}

	public String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			return alertText;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	public boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}

	public void selectValueFromDropdownViaIndex(By element, int valueToSelectedIndex) {
		Select selectFromDropdown = new Select(driver.findElement(element));
		selectFromDropdown.selectByIndex(valueToSelectedIndex);
	}

	public void selectValueFromDropdownViaText(By element, String valueToSelectedText) {
		Select selectFromDropdown = new Select(driver.findElement(element));
		selectFromDropdown.selectByVisibleText(valueToSelectedText);

	}

	public void switchToAlert() {
		Alert alert = driver.switchTo().alert();
	}

	// handling dilogbox
	private String parentWindow = null;

	public void switchToDialogWindow() {
		parentWindow = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();

		while (iterator.hasNext()) {
			String handle = iterator.next();
			if (!handle.contains(parentWindow)) {
				// Switch to popup and close it
				driver.switchTo().window(handle);
				// Perform required action in popup
				return;
			}
		}
	}

	public void switchToParentWindow() {
		driver.switchTo().window(parentWindow);
	}

	// create date stamp

	public String getTodaysDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");// add time in hours and minutes with
																					// seconds like HH:mm:ss
		Date date = new Date(System.currentTimeMillis());
		String expectedDateTime = formatter.format(date);
		return formatter.format(date);
	}

	public String getDateAfter_Fifteendays() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		String strDate = formatter.format(date);
		System.out.println("Date Format with MM/dd/yyyy : " + strDate);

		Calendar c = Calendar.getInstance();

		c.add(Calendar.DAY_OF_MONTH, 15);
		String new_str = formatter.format(c.getTime());
		return new_str;

	}
	
	public void setLocalStorageItem(String key, String value) {
		JavascriptExecutor js;
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("localStorage.setItem(arguments[0],arguments[1])",key,value);
		} catch(Exception e) {
			
		}
		
	}
	//list box automation
	
	public String selectElemetFromList() {
		return parentWindow;
		
		
	}

}