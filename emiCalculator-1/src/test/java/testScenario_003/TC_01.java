package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import junit.framework.AssertionFailedError;
import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_01 extends DriverSetup {
	
	
	@Test
	public void LoanAmountAndSliderTallyCheck() throws Exception  {
		//Method for checking the properly working of the Loan amount slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_01 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialposition = clp.getLoanAmountSlider();
			
			 clp.setLoanAmount(data.getLoanAmount());
			 logger.info("loan amount is passed");
			 
		
				try {
			 Assert.assertNotEquals(initialposition, clp.getLoanAmountSlider());
			 reporter("LoanAmountAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LoanAmountAndSliderTallyCheck");
		} catch (AssertionError e) {
			 reporter("LoanAmountAndSliderTallyCheck","Fail");
			 captureScreen(driver,"LoanAmountAndSliderTallyCheck");
			 report.onTestFailure("LoanAmountAndSliderTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_01 is closed");
	}
	

}
