package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_06 extends DriverSetup {
	
	
	@Test
	public void sliderAndLoanTermTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the loan tenure slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_06 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialvalue = clp.gettenurevalue();
			 
			
			 
			 clp.setLoanTermSlider();
			 logger.info("slider is setted");
			
				try {
			 Assert.assertNotEquals(initialvalue, clp.gettenurevalue());
			 reporter("sliderAndLoanTermTallyCheck","Pass");
			 report.onTestSuccess("sliderAndLoanTermTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("sliderAndLoanTermTallyCheck","Fail");
			 captureScreen(driver,"sliderAndLoanTermTallyCheck");
			 report.onTestFailure("sliderAndLoanTermTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_06 is closed");
	}
	

}