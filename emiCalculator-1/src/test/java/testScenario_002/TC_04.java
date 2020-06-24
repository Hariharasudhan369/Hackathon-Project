package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_04 extends DriverSetup{

	@Test
	public void validLoanInsurance () throws Exception {
		//Method for checking the Loan Insurance amount text box passing with valid data
		Reporting report = new Reporting();
		    logger.info("TS_02 . TC_04 is Started");
		    logger.info("URL is opened");
		 	HomeLoanPage clp = new HomeLoanPage(driver);
		 	TakeExcelData data = new TakeExcelData();
			
			clp.clickCalculatorButton();
			logger.info("calculatorButton button is clicked");
			
			clp.clickHomeLoanSelectButton();
			logger.info("HomeLoanButton button is clicked");
			
			clp.setHomePriceAmount(data.getHV());
			logger.info("valid Home price is passed");
			
			clp.setDownPayment(data.getDP());
			logger.info("valid Downpayment value is passed");
			
			clp.setHomeLoanInsuranceAmount(data.getLI());
			logger.info("valid home loan insurance amount is passed");
			
				try {
					Assert.assertEquals(data.getLI(), clp.getHomeLoanInsuranceAmount());
					reporter("validLoanInsurance","Pass");
					logger.info("valid  home loan insurance amount text box test is passed");
					report.onTestSuccess("validLoanInsurance");
				} catch (AssertionError e) {
					captureScreen(driver,"validLoanInsurance");
					reporter("validLoanInsurance","Fail");
				    logger.info("valid  home loan insurance amount text box test is failed");
				    report.onTestFailure("validLoanInsurance");
				}
			    
			    RefreshPage();
			    logger.info("TS_02 . TC_04 is Completed");
	}
		
}
