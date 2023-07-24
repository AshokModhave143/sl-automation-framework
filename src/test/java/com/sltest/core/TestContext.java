package com.sltest.core;

import org.openqa.selenium.WebDriver;

public class TestContext {
	static TestContext testContext = null;
	private WebDriver driver;
	private PageObjectManager pageObjectManager;
	private ScenarioContext scenarioContext;
	
	public TestContext() {
		this.driver = CreateSession.getWebDriver();
		//this.pageObjectManager = new PageObjectManager(this.driver);
		//this.scenarioContext = new ScenarioContext();
	}
	
	public static TestContext getTestContext() {
		if( null == testContext) {
			testContext = new TestContext();
		}
		return testContext;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public PageObjectManager getPageObjectManager() {
		if(null == pageObjectManager) {
			pageObjectManager = new PageObjectManager(driver);
		}
		return pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		if (null == scenarioContext) {
			scenarioContext = new ScenarioContext();
		}
		return scenarioContext;
	}
}
