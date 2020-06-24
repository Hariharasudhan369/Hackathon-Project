package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_04 extends DriverSetup {

	@Test
	public void validDataCarLoanTenureBoxTest() throws Exception {
		//Method for checking the Car loan tenure text box passing with valid data
		Reporting report = new Reporting();
		
		logger.info("TS_01 . TC_04 is Started");
		logger.info("URL is opened");
		CarLoanPage clp = new CarLoanPage(driver);
		TakeExcelData data = new TakeExcelData();
		
		clp.clickCarLoan();
		logger.info("carloan button is clicked");
		
		
		  clp.setCarLoanAmount(data.getCarloan());
		  logger.info("valid car loan amount is passed");
		 
		
		clp.setCarLoanInterest(data.getInterest());
		logger.info("valid car interest rate is passed");
		
		clp.setCarLoanTerm(data.getTenureYr());
		logger.info("valid car loan tenure is passed");
		
		try {
				Assert.assertEquals(data.getTenureYr(), clp.getCarLoanTerm());
				logger.info("valid data car loan tenure test is passed");
				reporter("validDataCarLoanTenureBoxTest","Pass");
				report.onTestSuccess("validDataCarLoanTenureBoxTest");
			} catch (AssertionError e) {
				captureScreen(driver,"validDataCarLoanTenureBoxTest");
				reporter("validDataCarLoanTenureBoxTest","Fail");
			    logger.info("valid data car loan tenure test is failed");
			    report.onTestFailure("validDataCarLoanTenureBoxTest");
			}
		
		RefreshPage();
		logger.info("TS_01 . TC_04 is Completed");
	}
}