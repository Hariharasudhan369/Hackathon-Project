package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_11 extends DriverSetup {
	
	
	@Test
	public void LALoanInterestAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Interest Rate slider button under Loan Amount Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_11 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clickLoanAmtCal();
			 logger.info("loan amount calculator button is clicked");
			 
			 String initialposition = clp.getLoanInterestSlider();
			
			 
			 clp.setLoanInterest(data.getInterestRate());
			 logger.info("loan interest is passed");
			 
			 try {
			 Assert.assertNotEquals(initialposition, clp.getLoanInterestSlider());
			 reporter("LALoanInterestAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LALoanInterestAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LALoanInterestAndSliderTallyCheck","Fail");
			 captureScreen(driver,"LALoanInterestAndSliderTallyCheck");
			 report.onTestFailure("LALoanInterestAndSliderTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_11 is closed");
	}
	

}