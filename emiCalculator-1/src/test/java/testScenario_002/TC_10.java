package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;

public class TC_10 extends DriverSetup {
	
	@Test
	public void invalidDownpayment() throws IOException, Exception {
		//Method for checking the Home down payment text box passing with invalid data
		Reporting report = new Reporting();
		
		 logger.info("TS_02 . TC_10 is Started");
		 logger.info("URL is opened");
		 HomeLoanPage clp = new HomeLoanPage(driver);
		 
		 clp.clickCalculatorButton();
		 logger.info("calculatorButton button is clicked");
			
		 clp.clickHomeLoanSelectButton();
		 logger.info("HomeLoanButton button is clicked");
		 
		 clp.setHomePriceAmount(getInputDataProperties("invalidHomePriceValue"));
		 logger.info("invalid home price amount is passed");
		 
		 clp.setDownPayment(getInputDataProperties("invalidHomeDownPaymentValue"));
		 logger.info("invalid down payment amount is passed");
		 
				try {
					Assert.assertEquals(clp.getHomeDownPayment(), getInputDataProperties("invalidHomeDownPaymentValue"));
					reporter("invalidDownpayment","Pass");
					report.onTestSuccess("invalidDownpayment");
					logger.info("invalid down payment Amount Test is passed");
				} catch (AssertionError e) {
					reporter("invalidDownpayment","Fail");
					captureScreen(driver,"invalidDownpayment");
					//Thread.sleep(3000);
				    logger.info("invalid down payment Amount Test test is failed");
				    report.onTestFailure("invalidDownpayment");
				    
				}
		 
		 RefreshPage();
		 logger.info("TS_02 . TC_10 is Completed");
	}

}