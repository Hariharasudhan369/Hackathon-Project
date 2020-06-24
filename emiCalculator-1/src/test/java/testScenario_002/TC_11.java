package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;

public class TC_11 extends DriverSetup {
	
	
	@Test
	public void invalidHomeLoanInsuranceAmount() throws IOException, Exception {
		//Method for checking the Loan Insurance amount text box passing with invalid data
		Reporting report = new Reporting();
		
		 logger.info("TS_02 . TC_11 is Started");
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
		 
				try {
					Assert.assertEquals(clp.getHomeLoanInsuranceAmount(), getInputDataProperties("invalidHomeLoanInsuranceValue"));
					reporter("invalidHomeLoanInsuranceAmount","Pass");
					logger.info("invalid home loan insurance Amount Test is passed");
					report.onTestSuccess("invalidHomeLoanInsuranceAmount");
				} catch (AssertionError e) {
					reporter("invalidHomeLoanInsuranceAmount","Fail");
					captureScreen(driver,"invalidHomeLoanInsuranceAmount");
					//Thread.sleep(3000);
				    logger.info("invalid home loan insurance Amount Test is failed");
				    report.onTestFailure("invalidHomeLoanInsuranceAmount");
				}
	
		 RefreshPage();
		 logger.info("TS_02 . TC_11 is Completed");
		
	}

}