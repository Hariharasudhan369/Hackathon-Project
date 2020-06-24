package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_02 extends DriverSetup {
	
	
	@Test
	public void sliderAndLoanAmountTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the Loan amount slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_02 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialvalue = clp.getlnamntvalue();
			 
			
			 
			 clp.setLoanAmountSlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getlnamntvalue());
			 reporter("sliderAndLoanAmountTallyCheck","Pass");
			 report.onTestSuccess("sliderAndLoanAmountTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("sliderAndLoanAmountTallyCheck","Fail");
			 captureScreen(driver,"sliderAndLoanAmountTallyCheck");
			 report.onTestFailure("sliderAndLoanAmountTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_02 is closed");
	}
	

}
