package com.boabco.pageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sltest.core.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {
private WebDriver driver;
	public PersonalDetailsPage(WebDriver driver) throws IOException {
		super(driver);
		this.driver=driver;
	}
	//Elements
	public By peopleButton = By.xpath("//a[@href='#/person']");
	public By createButton = By.xpath("//*[text()='Create']");
	public By first_name = By.name("first_name");
	public By last_name = By.name("last_name");
    public By date_of_birth = By.xpath("//input[@value='Select date of birth']");
    public By select_date_of_birth = By.xpath("//button//*[text()='12']");
    public By okButton = By.xpath("//button//*[text()='OK']");
    
    public By gender = By.xpath("//input[@name='gender']/parent::div/div");
    public By female = By.xpath("//li[text()='Female']");
    
    public By dawang = By.xpath("//input[@name='family_group']/parent::div/div");
    public By Balaburr = By.xpath("//li[text()='Balaburr']");
    
    public By mother_name = By.xpath("//input[@name='mothers_name']");
    public By father_name = By.xpath("//input[@name='fathers_name']");
    public By community = By.xpath("//input[@name='community']");
    public By street = By.xpath("//input[@name='street']");
    public By drivers_licence = By.xpath("//div[@basepath='/person']//input[@name='drivers_licence']");
    public By saveButton = By.xpath("//button[@type='submit']");
    
    public By getGenderXpath(String value) {
    	String path = "//li[text()='"+ gender + "']";
    	return By.xpath(path);
    }

}
