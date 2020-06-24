package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_10 extends DriverSetup {
	
	
	@Test
	public void sliderAndEMITallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the EMI slider button under Loan Amount Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_10 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clickLoanAmtCal();
			 logger.info("loan amount calculator button is clicked");
			 
			 String initialvalue = clp.getEMIvalue();
			 
			
			 
			 clp.setEMISlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.getEMIvalue());
			 reporter("sliderAndEMITallyCheck","Pass");
			 report.onTestSuccess("sliderAndEMITallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			reporter("sliderAndEMITallyCheck","Fail");
			captureScreen(driver,"sliderAndEMITallyCheck");
			report.onTestFailure("sliderAndEMITallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_10 is closed");
	}
	

}
