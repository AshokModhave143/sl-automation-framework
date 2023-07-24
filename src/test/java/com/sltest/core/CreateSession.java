package com.sltest.core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.sltest.core.DriverManager;

public class CreateSession {
	
	// Thread instance that contains WebDriver instance is used to perform browser interactions
	private static ThreadLocal<RemoteWebDriver> remoteDriver = new ThreadLocal<>();
	
	// This is logger object used for logging - TODO: move to another file
	private static Logger logger = Logger.getLogger(CreateSession.class.getName());
	
	
	@BeforeSuite
	public static void initDriver() {
		// browser value passed in command line
		String browserName = System.getProperty("browser");
		if(browserName == null) browserName = "chrome";
		
		
		// Get the driver instance
		DriverManager driverManager = new DriverManager();
		remoteDriver.set((RemoteWebDriver)driverManager.getWebDriver(browserName));
				
		// Default settings for driver
		getWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getWebDriver().manage().window().maximize();
	}
		
	// Returns the webdriver for current thread
	public static WebDriver getWebDriver() {
		System.out.println("WebDriver: " + remoteDriver.get());
		return remoteDriver.get();
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		getWebDriver().quit();
	}
}
