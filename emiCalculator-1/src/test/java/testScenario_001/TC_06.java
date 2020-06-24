package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_06 extends DriverSetup {
	
	@Test
	public void invalidDataCarInterestBoxTest() throws Exception {
		//Method for checking the Interest Rate text box passing with invalid data
		Reporting report = new Reporting();
		
		logger.info("TS_01 . TC_06 is Started");
		logger.info("URL is opened");
		CarLoanPage clp = new CarLoanPage(driver);
		
		clp.clickCarLoan();
		logger.info("carloan button is clicked");
		
		String positionOfSlider = clp.getLoanAmountSlider();
		
		clp.setCarLoanAmount(getInputDataProperties("invalidCarloanamountValue"));
		logger.info("invalid car loan amount is passed");
		
		
		clp.setCarLoanInterest(getInputDataProperties("invalidCarInterestrateValue"));
		logger.info("invalid car interest rate is passed");
		
		clp.setCarLoanTerm(getInputDataProperties("invalidCarLoanTenureValue"));
		

		try {
			Assert.assertEquals(positionOfSlider, getInputDataProperties("invalidCheck"));
			reporter("invalidDataCarInterestBoxTest","Pass");
			logger.info("invalid data car interest test is passed");
			report.onTestSuccess("invalidDataCarInterestBoxTest");
		} catch (AssertionError e) {
	
			reporter("invalidDataCarInterestBoxTest","Fail");
			captureScreen(driver,"invalidDataCarInterestBoxTest");
			report.onTestFailure("invalidDataCarInterestBoxTest");
		    logger.info("invalid data car interest test is failed");
		}
		
		RefreshPage();
		logger.info("TS_01 . TC_06 is Completed");
		
	}
	

}