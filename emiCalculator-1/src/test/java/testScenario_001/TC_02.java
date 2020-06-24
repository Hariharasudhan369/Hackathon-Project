package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_02 extends DriverSetup {
	
	@Test
	public void validDataCarLoanBoxTest() throws Exception {
		//Method for checking the car loan text box passing with valid data
		Reporting report = new Reporting();
		
	logger.info("TS_01 . TC_02 is Started");
	logger.info("URL is opened");
	CarLoanPage clp = new CarLoanPage(driver);
	TakeExcelData data = new TakeExcelData();
	
	clp.clickCarLoan();
	logger.info("carloan button is clicked");
	
	clp.setCarLoanAmount(data.getCarloan());
	logger.info("valid data car loan amount is passed");
	

		try {
			Assert.assertEquals(data.getCarloan(),clp.getCarLoanAmount());
			logger.info("valid data car loan box test is passed");
			reporter("validDataCarLoanBoxTest","Pass");
			report.onTestSuccess("validDataCarLoanBoxTest");
		} catch (AssertionError e) {
			captureScreen(driver,"validDataCarLoanBoxTest");
			reporter("validDataCarLoanBoxTest","Fail");
			logger.info("valid data car loan box test is failed");
			report.onTestFailure("validDataCarLoanBoxTest");
		}

	    RefreshPage();
	    logger.info("TS_01 . TC_02 is Completed");
	}
	
	
}