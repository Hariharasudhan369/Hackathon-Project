package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;

public class TC_09 extends DriverSetup {
	@Test
	public void invalidHomePrice() throws IOException, Exception {
		//Method for checking the Home value amount text box passing with invalid data
		Reporting report = new Reporting();
		
		 logger.info("TS_02 . TC_09 is Started");
		 logger.info("URL is opened");
		 HomeLoanPage clp = new HomeLoanPage(driver);
		 
		 clp.clickCalculatorButton();
		 logger.info("calculatorButton button is clicked");
			
		 clp.clickHomeLoanSelectButton();
		 logger.info("HomeLoanButton button is clicked");
		 
		 clp.setHomePriceAmount(getInputDataProperties("invalidHomePriceValue"));
		 logger.info("invalid home price amount is passed");
		 
				try {
					Assert.assertEquals(getInputDataProperties("invalidHomePriceValue"), clp.getHomePriceAmount());
					reporter("invalidHomePrice","Pass");
					report.onTestSuccess("invalidHomePrice");
					logger.info("invalid home Value Amount Test is passed");
				} catch (AssertionError e) {
					reporter("invalidHomePrice","Fail");
					captureScreen(driver,"invalidHomePrice");
					//Thread.sleep(3000);
				    logger.info("invalid home Value Amount Test test is failed");
				    report.onTestFailure("invalidHomePrice");
				}
		 
		 RefreshPage();
		 logger.info("TS_02 . TC_09 is Completed");
	 }

}