package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_06 extends DriverSetup {
	
	@Test
	public void validHomeLoanInterest() throws IOException, Exception {
		//Method for checking the Home Loan Interest amount text box passing with valid data
		Reporting report = new Reporting();
		
		    logger.info("TS_02 . TC_06 is Started");
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
			
				try {
					Assert.assertEquals(data.getIR(),clp.getHomeLoanInterest());
					reporter("validHomeLoanInterest","Pass");
					report.onTestSuccess("validHomeLoanInterest");
					logger.info("valid  home loan interest value text box test is passed");
				} catch (AssertionError e) {
					reporter("validHomeLoanInterest","Fail");
					captureScreen(driver,"validHomeLoanInterest");
					//Thread.sleep(3000);
				    logger.info("valid  home loan interest value text box test is failed");
				    report.onTestFailure("validHomeLoanInterest");
				}
			    RefreshPage();
			    logger.info("TS_02 . TC_06 is Completed");
	}

}