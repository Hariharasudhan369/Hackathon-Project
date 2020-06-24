package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_24 extends DriverSetup {
	
	
	@Test
	public void LTsliderAndLoanFeesTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the Fees and Charges slider button under Loan Tenure Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_24 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialvalue = clp.getfeesvalue();
			 
			
			 
			 clp.setLoanFeesSlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getfeesvalue());
			 reporter("LTsliderAndLoanFeesTallyCheck","Pass");
			 report.onTestSuccess("LTsliderAndLoanFeesTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LTsliderAndLoanFeesTallyCheck","Fail");
			 captureScreen(driver,"LTsliderAndLoanFeesTallyCheck");
			 report.onTestFailure("LTsliderAndLoanFeesTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_24 is closed");
	}
	

}