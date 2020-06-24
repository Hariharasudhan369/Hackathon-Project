package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_23 extends DriverSetup {
	
	
	@Test
	public void LTLoanFeesAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Fees and Charges slider button under Loan Tenure Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_23 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialposition = clp.getLoanFeesSlider();
			 	 
			 clp.setLoanFees(data.getFees());
			 logger.info("loan amount is passed");
			 
			 try {
			 Assert.assertNotEquals(initialposition, clp.getLoanFeesSlider());
			 reporter("LTLoanFeesAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LTLoanFeesAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LTLoanFeesAndSliderTallyCheck","Fail");
			captureScreen(driver,"LTLoanFeesAndSliderTallyCheck");
			report.onTestFailure("LTLoanFeesAndSliderTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_23 . TC_01 is closed");
	}
	

}
