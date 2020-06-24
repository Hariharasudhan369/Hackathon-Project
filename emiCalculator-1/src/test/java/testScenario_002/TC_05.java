package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_05 extends DriverSetup {
	
	@Test
	public void validHomeLoanAmount() throws IOException {
		//Method for checking the Home Loan amount text box passing with valid data	  
			  Reporting report = new Reporting();
			  try {
			  
			logger.info("TS_02 . TC_05 is Started");
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
				
				String ldata=data.getHL();
				String hpa=clp.getHomeLoanAmount();
				 hpa=hpa.replaceAll("[^0-9]", ""); 
			 	Assert.assertEquals(ldata,hpa);
			 	report.onTestSuccess("validHomeLoanAmount");
			 	reporter("validHomeLoanAmount","Pass");
		} catch (AssertionError e) {
			reporter("validHomeLoanAmount","Pass");
			captureScreen(driver,"validHomeLoanAmount");
			report.onTestFailure("validHomeLoanAmount");
		}

		    
			    RefreshPage();
			    logger.info("TS_02 . TC_05 is Completed");
		
	}

}