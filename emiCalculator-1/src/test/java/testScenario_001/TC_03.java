package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_03 extends DriverSetup {
	
	@Test
	public void validDataCarInterestBoxTest() throws Exception {
		//Method for checking the Interest Rate text box passing with valid data
		Reporting report = new Reporting();
		
		logger.info("TS_01 . TC_03 is Started");
		logger.info("URL is opened");
		CarLoanPage clp = new CarLoanPage(driver);
		TakeExcelData data = new TakeExcelData();
		
		clp.clickCarLoan();
		logger.info("carloan button is clicked");
		
		clp.setCarLoanAmount(data.getCarloan());
		logger.info("valid car loan amount is passed");
		
		clp.setCarLoanInterest(data.getInterest());
		logger.info("valid car interest rate is passed");
		
		
			try {
				Assert.assertEquals(data.getInterest(),clp.getCarLoanInterest());
				reporter("validDataCarInterestBoxTest","Pass");
				logger.info("car interest test is passed");
				report.onTestSuccess("validDataCarInterestBoxTest");
			} catch (AssertionError e) {
				reporter("validDataCarInterestBoxTest","Fail");
				captureScreen(driver,"validDataCarInterestBoxTest");
				 logger.info("valid data car interest test is failed");
				 report.onTestFailure("validDataCarInterestBoxTest");
			}
		
		RefreshPage();
		logger.info("TS_01 . TC_03 is Completed");
		
	}
	

}