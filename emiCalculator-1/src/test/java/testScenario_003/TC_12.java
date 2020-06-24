package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_12 extends DriverSetup {
	
	
	@Test
	public void LASliderAndLoanInterestTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the Interest Rate slider button under Loan Amount Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_12 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clickLoanAmtCal();
			 logger.info("loan amount calculator button is clicked");
			 
			 String initialvalue = clp.getintrtvalue();
			 
			
			 
			 clp.setLoanInterestSlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getintrtvalue());
			 reporter("LASliderAndLoanInterestTallyCheck","Pass");
			 report.onTestSuccess("LASliderAndLoanInterestTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LASliderAndLoanInterestTallyCheck","Fail");
			captureScreen(driver,"LASliderAndLoanInterestTallyCheck");
			report.onTestFailure("LASliderAndLoanInterestTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_12 is closed");
	}
	

}