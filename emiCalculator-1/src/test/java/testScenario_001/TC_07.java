
package testScenario_001;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_07 extends DriverSetup {

	@Test
	public void invalidDataCarLoanTenureBoxTest() throws Exception {
		//Method for checking the Car loan tenure text box passing with invalid data
		Reporting report = new Reporting();
		
		 logger.info("TS_01 . TC_07 is Started");
		 logger.info("URL is opened");
		CarLoanPage clp = new CarLoanPage(driver);

		clp.clickCarLoan();
		 logger.info("carloan button is clicked");

		String positionOfSlider = clp.getLoanAmountSlider();
		 System.out.println(positionOfSlider);

		clp.setCarLoanAmount(getInputDataProperties("invalidCarloanamountValue"));
		logger.info("invalid car loan amount is passed");

		clp.setCarLoanInterest(getInputDataProperties("invalidCarInterestrateValue"));
		 logger.info("invalid car interest rate is passed");

		clp.setCarLoanTerm(getInputDataProperties("invalidCarLoanTenureValue"));
		 logger.info("invalid car loan tenure is passed");

	
		
			try {
				Assert.assertEquals(positionOfSlider, getInputDataProperties("invalidCheck"));
				reporter("invalidDataCarLoanTenureBoxTest", "Pass");
				 logger.info("invalid data car loan tenure test is passed");
				 report.onTestSuccess("invalidDataCarLoanTenureBoxTest");
			} catch (AssertionError e) {
				reporter("invalidDataCarLoanTenureBoxTest", "Fail");
				captureScreen(driver, "invalidDataCarLoanTenureBoxTest");
				report.onTestFailure("invalidDataCarLoanTenureBoxTest");
				 logger.info("invalid data car loan tenure test is failed");
			}
		

		RefreshPage();
		 logger.info("TS_01 . TC_07 is Completed");

	}

}