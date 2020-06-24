package testScenario_002;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 extends DriverSetup {
	@Test
	public void homeLoanPageTest() throws Exception {
		//Method for entering the Home Loan EMI calculator page
		Reporting report = new Reporting();
		
		logger.info("TS_02 . TC_01 is Started");
		logger.info("URL is opened");
		HomeLoanPage clp = new HomeLoanPage(driver);
		
		clp.clickCalculatorButton();
		logger.info("calculatorButton button is clicked");
		
		clp.clickHomeLoanSelectButton();
		logger.info("HomeLoanButton button is clicked");
		
        	try {
        		Assert.assertEquals(driver.getTitle(), getInputDataProperties("HomeLoanPageTitle"));
				reporter("homeLoanPageTest","Pass");
				logger.info("HomeLoanButton page is opened properly");
				report.onTestSuccess("carLoanPageTest");
			} catch (AssertionError e) {
				captureScreen(driver,"homeLoanPageTest");
	        	reporter("homeLoanPageTest","Fail");
				//Thread.sleep(3000);
	        	logger.info("HomeLoanButton page is not opened properly");
	        	report.onTestFailure("homeLoanPageTest");
			}
        
	
		
		RefreshPage();
		logger.info("TS_02 . TC_01 is Completed");
	}

}