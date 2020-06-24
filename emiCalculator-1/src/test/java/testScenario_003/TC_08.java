package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_08 extends DriverSetup {
	
	
	@Test
	public void sliderAndLoanFeesTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the fees and chargers slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_08 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialvalue = clp.getfeesvalue();
			 
			 clp.setLoanFeesSlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getfeesvalue());
			 reporter("sliderAndLoanFeesTallyCheck","Pass");
			 report.onTestSuccess("sliderAndLoanFeesTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("sliderAndLoanFeesTallyCheck","Fail");
			captureScreen(driver,"sliderAndLoanFeesTallyCheck");
			report.onTestFailure("sliderAndLoanFeesTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_08 is closed");
	}
	

}