package testScenario_003;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.CarLoanPage;
import pageObjects.EmiCalculatorPage;
import setup.DriverSetup;
import utilities.Reporting;
import Base.BaseClass;

import org.testng.Assert;


public class TC_001 extends DriverSetup   {
  
	@Test
	public void EMICalculatorPageTest() throws Exception 
	{
		//Method for entering the EMI calculator page
		Reporting report = new Reporting();
		logger.info("TS_03 . TC_001 is Started");
		logger.info("URL is opened");
		EmiCalculatorPage clp = new EmiCalculatorPage(driver);
		
		clp.clickCalculatorButton();
		logger.info("calculator is clicked");
		
		clp.clickLoanCalculatorButton();
		logger.info("loan calculator is clicked");
        
        	try {
        		Assert.assertEquals(driver.getTitle(), getInputDataProperties("LoanCalculatorPageTitle"));
				reporter("EMICalculatorPageTest","Pass");
				report.onTestSuccess("validDataHomeLoanTest");
			} catch (AssertionError e) {
				reporter("EMICalculatorPageTest","Fail");
	        	captureScreen(driver,"EMICalculatorPageTest");
	        	report.onTestFailure("EMICalculatorPageTest");
			}
        
        RefreshPage();
        logger.info("TS_03 . TC_001 is Completed");
	}
}