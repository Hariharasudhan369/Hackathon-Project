package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_08 extends DriverSetup{
	
	
	@Test
	public void validLoanFees() throws IOException, Exception {
		//Method for checking the Fees and charges amount text box passing with valid data
		Reporting report = new Reporting();
		
		logger.info("TS_02 . TC_08 is Started");
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
		
		clp.setHomeLoanAmount(data.getHL());
		logger.info("valid home loan amount is passed");
		
		clp.setHomeLoanInterest(data.getIR());
		logger.info("valid home loan interest value is passed");
		
		clp.setHomeLoanTerm(data.getLT());
		logger.info("valid home loan term value is passed");
		
		clp.setHomeLoanFees(data.getLFees());
		logger.info("valid home loan fees value is passed");
	
			try {
				Assert.assertEquals(data.getLFees(), clp.getHomeLoanFees());
				reporter("validLoanFees","Pass");
				report.onTestSuccess("validLoanFees");
				logger.info("valid  home loan fees value text box test is passed");
			} catch (AssertionError e) {
				reporter("validLoanFees","Fail");
				captureScreen(driver,"validLoanFees");
				//Thread.sleep(3000);
			    logger.info("valid  home loan fees value text box test is failed");
			    report.onTestFailure("validLoanFees");
			}

		    RefreshPage();
		    logger.info("TS_02 . TC_08 is Completed");
	}

}