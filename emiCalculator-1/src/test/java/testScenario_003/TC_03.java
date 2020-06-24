package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_03 extends DriverSetup {
	
	
	@Test
	public void LoanInterestAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Interest slider button under EMI Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_03 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialposition = clp.getLoanInterestSlider();
			 System.out.println(initialposition);
			 
			 clp.setLoanInterest(data.getInterestRate());
			 logger.info("loan interest is passed");
			 
				try {
			 Assert.assertNotEquals(initialposition, clp.getLoanInterestSlider());
			 reporter("LoanInterestAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LoanInterestAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LoanInterestAndSliderTallyCheck","Fail");
			captureScreen(driver,"LoanInterestAndSliderTallyCheck");
			report.onTestFailure("LoanInterestAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_03 is closed");
	}
	

}

