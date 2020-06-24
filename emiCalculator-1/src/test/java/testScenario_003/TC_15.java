package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_15 extends DriverSetup {
	
	
	@Test
	public void LALoanFeesAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Fees and charges slider button under Loan Amount Calculator Tab	
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_15 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clickLoanAmtCal();
			 logger.info("loan amount calculator button is clicked");
			 
			 String initialposition = clp.getLoanFeesSlider();
			 
			 clp.setLoanFees(data.getFees());
			 logger.info("loan amount is passed");
			 try {
			 Assert.assertNotEquals(initialposition, clp.getLoanFeesSlider());
			 reporter("LALoanFeesAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LALoanFeesAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LALoanFeesAndSliderTallyCheck","Fail");
			 captureScreen(driver,"LALoanFeesAndSliderTallyCheck");
			 report.onTestFailure("LALoanFeesAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_15 is closed");
	}
	

}
