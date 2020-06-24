package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_07 extends DriverSetup {
	
	
	@Test
	public void LoanFeesAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the fees and chargers slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_01 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialposition = clp.getLoanFeesSlider();
			 ////System.out.println(initialposition);
			 
			 clp.setLoanFees(data.getFees());
			 logger.info("loan amount is passed");
				try {
			 Assert.assertNotEquals(initialposition, clp.getLoanFeesSlider());
			 reporter("LoanFeesAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LoanFeesAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LoanFeesAndSliderTallyCheck","Fail");
			 captureScreen(driver,"LoanFeesAndSliderTallyCheck");
			 report.onTestFailure("LoanFeesAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_01 is closed");
	}
	

}
