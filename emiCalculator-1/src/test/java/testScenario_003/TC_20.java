package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_20 extends DriverSetup {
	
	
	@Test
	public void LTsliderAndEMITallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the EMI slider button under Loan Tenure Calculator Tab
			 Reporting report = new Reporting();
			logger.info("TS_03 . TC_20 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clicktenureCalcButton();
			 logger.info("loan tenure calculator button is clicked");
			 
			 String initialvalue = clp.getEMIvalue();
			 
			
			 
			 clp.setEMISlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getEMIvalue());
			 reporter("LTsliderAndEMITallyCheck","Pass");
			 report.onTestSuccess("LTsliderAndEMITallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LTsliderAndEMITallyCheck","Fail");
			 captureScreen(driver,"LTsliderAndEMITallyCheck");
			 report.onTestFailure("LTsliderAndEMITallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_20 is closed");
	}
	

}