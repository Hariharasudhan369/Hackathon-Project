package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_19 extends DriverSetup {
	
	
	@Test
	public void LTEMIAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the EMI slider button under Loan Tenure Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_19 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialposition = clp.getEMISlider();
			
			 clp.setEmi(data.getEMI());
			 logger.info("loan amount is passed");
			 
			 try {
			 Assert.assertNotEquals(initialposition, clp.getEMISlider());
			 reporter("LTEMIAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LTEMIAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LTEMIAndSliderTallyCheck","Fail");
			captureScreen(driver,"LTEMIAndSliderTallyCheck");
			report.onTestFailure("LTEMIAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_19 is closed");
	}
	

}