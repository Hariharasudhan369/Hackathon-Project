package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_17 extends DriverSetup {
	
	
	@Test
	public void LTLoanAmountAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Loan Amount slider button under Loan Tenure Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_01 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialposition = clp.getLoanAmountSlider();
			
			 
			 clp.setLoanAmount(data.getLoanAmount());
			 logger.info("loan amount is passed");
			 
			 try {
			 Assert.assertNotEquals(initialposition, clp.getLoanAmountSlider());
			 reporter("LTLoanAmountAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LTLoanAmountAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LTLoanAmountAndSliderTallyCheck","Fail");
			 captureScreen(driver,"LTLoanAmountAndSliderTallyCheck");
			 report.onTestFailure("LTLoanAmountAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_01 is closed");
	}
	

}