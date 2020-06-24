package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_07 extends DriverSetup {

	@Test
	public void validHomeLoanTerm() throws IOException {
		//Method for checking the Home Loan Tenure amount text box passing with valid data
		Reporting report = new Reporting();
		
		try {
	
			logger.info("TS_02 . TC_07 is Started");
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
			
			String ldata=data.getHV();
			String hpa=clp.getHomePriceAmount();
			
			Assert.assertEquals("60,00,000",hpa);
			reporter("validHomeLoanTerm","Pass");
			report.onTestSuccess("validHomeLoanTerm");
		} catch (AssertionError e) {
			reporter("validHomeLoanTerm","Fail");
			captureScreen(driver,"validHomeLoanTerm");
			report.onTestFailure("validHomeLoanTerm");
			
		}
     	
		    RefreshPage();
		    logger.info("TS_02 . TC_07 is Completed");
	}
}