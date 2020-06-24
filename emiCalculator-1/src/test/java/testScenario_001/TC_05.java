package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_05 extends DriverSetup {
	
	@Test
	public void invalidDataCarLoanBoxTest() throws Exception {
		//Method for checking the car loan text box passing with invalid data
		Reporting report = new Reporting();
		
	logger.info("TS_01 . TC_05 is Started");
	logger.info("URL is opened");
	CarLoanPage clp = new CarLoanPage(driver);
	
	clp.clickCarLoan();
	logger.info("carloan button is clicked");
	
	String positionOfSlider = clp.getLoanAmountSlider();
	
	clp.setCarLoanAmount(getInputDataProperties("invalidCarloanamountValue"));
	logger.info("invalid car loan value is passed");
	
	
		try {
			Assert.assertEquals(positionOfSlider, clp.getLoanAmountSlider());
			reporter("invalidDataCarLoanBoxTest","Pass");
			logger.info("invalid data car loan box test is passed");
			report.onTestSuccess("invalidDataCarLoanBoxTest");
		} catch (AssertionError e) {
			reporter("invalidDataCarLoanBoxTest","Fail");
			captureScreen(driver,"invalidDataCarLoanBoxTest");
			report.onTestFailure("invalidDataCarLoanBoxTest");
		    logger.info("invalid data car loan box test is failed");
		}


	    
	    RefreshPage();
	    logger.info("TS_01 . TC_05 is Completed");
	}
	
	
}