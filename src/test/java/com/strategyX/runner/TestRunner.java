package com.strategyX.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
		"json:target/cucumber-reports/cucmber.json"
		}, 
	features = "src/test/resources/strategyX_feature",
	monochrome  = true,
	dryRun = false,
	glue = "com.strategyX.stepDefinations",
	tags = "not @JIRA"
)

public class TestRunner extends AbstractTestNGCucumberTests {
	// Test suit initialization
}
