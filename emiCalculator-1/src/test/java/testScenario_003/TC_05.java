package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_05 extends DriverSetup {
	
	
	@Test
	public void LoanTermAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the loan tenure slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_05 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialposition = clp.getLoanTermSlider();
			 
			 clp.setLoanTerm(data.getLoanTenure());
			 logger.info("loan amount is passed");
				try {
			 Assert.assertNotEquals(initialposition, clp.getLoanTermSlider());
			 report.onTestSuccess("LoanTermAndSliderTallyCheck");
			 reporter("LoanTermAndSliderTallyCheck","Pass");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LoanTermAndSliderTallyCheck","Fail");
			captureScreen(driver,"LoanTermAndSliderTallyCheck");
			report.onTestFailure("LoanTermAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_05 is closed");
	}
	

}

