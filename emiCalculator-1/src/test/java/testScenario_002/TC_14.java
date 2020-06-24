package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;

public class TC_14 extends DriverSetup{
    
	@Test
	public void invalidLoanFees() throws IOException, Exception {
		//Method for checking the Fees and charges amount text box passing with invalid data
		Reporting report = new Reporting();
		
		 logger.info("TS_02 . TC_14 is Started");
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
		 
		 clp.setHomeLoanTerm(getInputDataProperties("invalidHomeLoanTenureValue"));
		 logger.info("invalid home loan term value is passed");
		 
		 clp.setHomeLoanFees(getInputDataProperties("invalidHomeLoanFeesValue"));
		 logger.info("invalid loan fees value is passed");
		 
		
				try {
					Assert.assertEquals(clp.getHomeLoanFees(), getInputDataProperties("invalidHomeLoanFeesValue"));
					reporter("invalidLoanFees","Pass");
					report.onTestSuccess("invalidLoanFees");
					logger.info("invalid loan fees Amount Test is passed");
				} catch (AssertionError e) {
					reporter("invalidLoanFees","Fail");
					captureScreen(driver,"invalidLoanFees");
				    logger.info("invalid loan fees Amount Test  is failed");
				    report.onTestFailure("invalidLoanFees");
				}
		
		 RefreshPage();
		 logger.info("TS_02 . TC_14 is Completed");
		
	}
}