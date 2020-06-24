package testScenario_003;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_13 extends DriverSetup {
	
	
	@Test
	public void LALoanTermAndSliderTallyCheck() throws Exception {
		//Method for checking the properly working of the Loan Tenure slider button under Loan Amount Calculator Tab			
		Reporting report = new Reporting();
			logger.info("TS_03 . TC_05 is Started");
			 logger.info("URL is opened");
			 
			 EmiCalculatorPage clp = new EmiCalculatorPage(driver);
			 TakeExcelData data = new TakeExcelData();
			 
			 clp.clickCalculatorButton();
			 logger.info("calculatorButton button is clicked");
			 
			 clp.clickLoanCalculatorButton();
			 logger.info("loan calculator button is clicked");
			 
			 String initialposition = clp.getLoanTermSlider();
			
			 clp.setLoanTerm(data.getLoanTenure());
			 logger.info("loan Tenure is passed");
			 
			 try {

			 Assert.assertNotEquals(initialposition, clp.getLoanTermSlider());
			 reporter("LALoanTermAndSliderTallyCheck","Pass");
			 report.onTestSuccess("LALoanTermAndSliderTallyCheck");
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			 reporter("LALoanTermAndSliderTallyCheck","Fail");
			 captureScreen(driver,"LALoanTermAndSliderTallyCheck");
			 report.onTestFailure("LALoanTermAndSliderTallyCheck");
		} 
		 RefreshPage();
		 logger.info("TS_03 . TC_05 is closed");
	}
	

}