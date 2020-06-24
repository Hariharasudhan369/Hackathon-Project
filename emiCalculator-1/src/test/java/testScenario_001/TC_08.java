package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_08 extends DriverSetup {

	@Test
	public void validDataCarLoanTest() throws Exception {
		//Method for getting values from the result page
		Reporting report = new Reporting();
		try {
			
			logger.info("TS_01 . TC_08 is Started");
			logger.info("URL is opened");
			CarLoanPage clp = new CarLoanPage(driver);
			TakeExcelData data = new TakeExcelData();
			
			clp.clickCarLoan();
			logger.info("carloan button is clicked");
			
			
			  clp.setCarLoanAmount(data.getCarloan());
			  logger.info("car loan amount is passed");
			 
			
			clp.setCarLoanInterest(data.getInterest());
			logger.info("car interest rate is passed");
			
			clp.setCarLoanTerm(data.getTenureYr());
			logger.info("car loan tenure is passed");
			
			clp.clickEMIInArrearButton();
			logger.info("EMI in arrear button is clicked");
			
			clp.clickYearButton();
			logger.info("year button is clicked");
			
			String principalForFirstmonth = clp.getPrincipalAmountCarLoan();
			logger.info("Principal amount for first month was gotten");
			
			String interestForFirstmonth = clp.getInterestAmountCarLoan();
			logger.info("interest amount for first month was gotten");
			
			System.out.println("The principal amount for first month is"+principalForFirstmonth+" and the interest amount for first month is"+interestForFirstmonth+".");
			logger.info("Successfully printed the principal and interest for first month");
			report.onTestSuccess("validDataCarLoanTest");
			 reporter("validDataCarLoanTest","Pass");
		} catch (AssertionError e) {
			 reporter("validDataCarLoanTest","Fail");
			 captureScreen(driver, "validDataCarLoanTest");
			 report.onTestFailure("validDataCarLoanTest");
			
		} 
    
		
		RefreshPage();
		logger.info("TS_01 . TC_08 is Completed");
	}
}