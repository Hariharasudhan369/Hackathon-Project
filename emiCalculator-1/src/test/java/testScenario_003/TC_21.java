package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_21 extends DriverSetup {
	
	
	@Test
	public void LTLoanInterestAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Interest Rate slider button under Loan Tenure Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_21 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialposition = clp.getLoanInterestSlider();
						 
			 clp.setLoanInterest(data.getInterestRate());
			 logger.info("loan interest is passed");
			 
			 try {
			 Assert.assertNotEquals(initialposition, clp.getLoanInterestSlider());
			 reporter("LTLoanInterestAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LTLoanInterestAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LTLoanInterestAndSliderTallyCheck","Fail");
			captureScreen(driver,"LTLoanInterestAndSliderTallyCheck");
			report.onTestFailure("LTLoanInterestAndSliderTallyCheck");
		} 
		
		 RefreshPage();
		 logger.info("TS_03 . TC_21 is closed");
	}
	

}


