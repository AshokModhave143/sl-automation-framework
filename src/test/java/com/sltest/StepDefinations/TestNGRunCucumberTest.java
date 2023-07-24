//package com.sltest.StepDefinations;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//
//import com.sltest.core.DriverManager;
//import com.sltest.core.DriverManagerFactory;
//import com.sltest.helper.DriverType;
//
//import io.cucumber.testng.CucumberOptions;
//// import cucumber.api.testng.CucumberFeatureWrapper;
//import io.cucumber.testng.TestNGCucumberRunner;
//
//
////@CucumberOptions(features = {"src/test/resources/features"},
////	glue = {"com.strategyX.StepDefinations"},
////	plugin = { "pretty", "html:target/cucumber-reports/cucumber.html", "json:target/cucumber-reports/cucumber.json"}
////)
//public class TestNGRunCucumberTest {
//	protected DriverManager driverManager = null;
//	protected WebDriver driver = null; 
//	private TestNGCucumberRunner testNGCucumberRunner;
//	
//
//	//@BeforeClass
//	//@Parameters(value = {"browser", "version"})
//	public void beforeClass(String browser, String version) {
//		try {
//			driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
//			driver = driverManager.getWebDriver();
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
//		
//		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//	}
//	
////	@Test(groups = {"cucumber scenarios" }, description = "Run cucumber scenarios", dataProvider = "scenarios")
////	public void scenario(PickleWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
////		testNGCucumberRunner.runScenario(pickleEvent.getPickle());
////	}
//	
//	 /**
//     * @return returns two dimensional array of {@link CucumberFeatureWrapper}
//     *         objects.
//     */
//    //@DataProvider
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
//
//   //@AfterClass
//    public void tearDown() {
//        driverManager.quitWebDriver();
//        testNGCucumberRunner.finish();
//    }
//}
