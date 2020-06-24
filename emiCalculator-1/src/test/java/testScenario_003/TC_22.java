package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_22 extends DriverSetup {
	
	
	@Test
	public void LTSliderAndLoanInterestTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the Interest Rate slider button under Loan Tenure Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_22 . TC_04 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialvalue = clp.getintrtvalue();
			 
			
			 
			 clp.setLoanInterestSlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getintrtvalue());
			 reporter("LTSliderAndLoanInterestTallyCheck","Pass");
			 report.onTestSuccess("LTSliderAndLoanInterestTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LTSliderAndLoanInterestTallyCheck","Fail");
			captureScreen(driver,"LTSliderAndLoanInterestTallyCheck");
			report.onTestFailure("LTSliderAndLoanInterestTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_22 is closed");
	}
	

}