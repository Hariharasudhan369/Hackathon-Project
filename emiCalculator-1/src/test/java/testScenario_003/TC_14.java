package testScenario_003;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_14 extends DriverSetup {
	
	
	@Test
	public void LAsliderAndLoanTermTallyCheck() throws Exception {
		//Method for checking the properly working of drag and drop option in the Loan Tenure slider button under Loan Amount Calculator Tab
			Reporting report = new Reporting();
			logger.info("TS_03 . TC_14 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 clp.clickLoanAmtCal();
			 logger.info("loan amount calculator button is clicked");
			 
			 String initialvalue = clp.gettenurevalue();
			 
			
			 
			 clp.setLoanTermSlider();
			 logger.info("slider is setted");
			 try {
			 Assert.assertNotEquals(initialvalue, clp.gettenurevalue());
			 reporter("LAsliderAndLoanTermTallyCheck","Pass");
			 report.onTestSuccess("LAsliderAndLoanTermTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LAsliderAndLoanTermTallyCheck","Fail");
			 captureScreen(driver,"LAsliderAndLoanTermTallyCheck");
			 report.onTestFailure("LAsliderAndLoanTermTallyCheck");
		}
		 RefreshPage();
		 logger.info("TS_03 . TC_14 is closed");
	}
	

}