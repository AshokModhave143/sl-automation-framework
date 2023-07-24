package com.flashworks.pageObjects;

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
	public By welcomeText = By.xpath("//h6[text()='Welcome To Planorate']");
	
}
