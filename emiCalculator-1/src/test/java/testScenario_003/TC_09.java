package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_09 extends DriverSetup {
	
	
	@Test
	public void LAEMIAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the EMI slider button under Loan Amount Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_09 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clickLoanAmtCal();
			 logger.info("loan amount calculator button is clicked");
			 
			 String initialposition = clp.getEMISlider();
			
			 clp.setEmi(data.getEMI());
			 logger.info("loan amount is passed");
			 
				try {
			 Assert.assertNotEquals(initialposition, clp.getEMISlider());
			 reporter("LAEMIAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LAEMIAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("LAEMIAndSliderTallyCheck","Fail");
			captureScreen(driver,"LAEMIAndSliderTallyCheck");
			report.onTestFailure("LAEMIAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_09 is closed");
	}
	

}