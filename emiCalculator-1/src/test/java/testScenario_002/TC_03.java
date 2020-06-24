package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_03 extends DriverSetup {
	
	@Test
	public void validDownPaymentTextBoxTest() throws IOException, Exception {
		//Method for checking the Home down payment text box passing with valid data
		Reporting report = new Reporting();
		
		logger.info("TS_02 . TC_03 is Started");
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
			
				try {
					Assert.assertEquals(data.getDP(), clp.getHomeDownPayment());
					logger.info("valid down payment text box test is passed");
					reporter("validDownPaymentTextBoxTest","Pass");
					report.onTestSuccess("validDownPaymentTextBoxTest");
				} catch (AssertionError e) {
					reporter("validDownPaymentTextBoxTest","Fail");
					captureScreen(driver,"validDownPaymentTextBoxTest");
					//Thread.sleep(3000);
				    logger.info("valid down payment text box test is failed");
				    report.onTestFailure("validDownPaymentTextBoxTest");
				}
			    
			    RefreshPage();
			    logger.info("TS_02 . TC_03 is Completed");
	}

}