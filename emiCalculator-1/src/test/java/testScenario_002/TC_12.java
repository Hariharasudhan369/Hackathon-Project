package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;

public class TC_12 extends DriverSetup{
	@Test
	public void invalidHomeLoanInterest() throws IOException, Exception {
		//Method for checking the Home Loan Interest amount text box passing with invalid data
		Reporting report = new Reporting();
		
		logger.info("TS_02 . TC_12 is Started");
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
		 
		 clp.setHomeLoanInsuranceAmount(getInputDataProperties("invalidHomeLoanInsuranceValue"));
		 logger.info("invalid home loan insurance amount is passed");
		 
		 clp.setHomeLoanInterest(getInputDataProperties("invalidHomeInterestRateValue"));
		 logger.info("invalid home loan interest amount is passed");
		 			try {
					Assert.assertEquals(clp.getHomeLoanInterest(), getInputDataProperties("invalidHomeInterestRateValue"));
					reporter("invalidHomeLoanInterest","Pass");
					logger.info("invalid home loan interest Amount Test is passed");
					report.onTestSuccess("invalidHomeLoanInterest");
				} catch (AssertionError e) {
					// TODO Auto-generated catch block
					reporter("invalidHomeLoanInterest","Fail");
					captureScreen(driver,"invalidHomeLoanInterest");
					//Thread.sleep(3000);
				    logger.info("invalid home loan interest Amount Test  is failed");
				    report.onTestFailure("invalidHomeLoanInterest");
				}
			
		 
		 RefreshPage();
		 logger.info("TS_02 . TC_12 is Completed");
	}

}