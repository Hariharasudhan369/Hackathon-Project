package testScenario_001;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.CarLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import Base.BaseClass;

import org.testng.Assert;


public class TC_01 extends DriverSetup   {
  
	@Test
	public void carLoanPageTest() throws Exception 
	{  //Method for entering the carloan page
		
		Reporting report = new Reporting();
		
		logger.info("TS_01 . TC_01 is Started");
		logger.info("URL is opened");
		CarLoanPage clp = new CarLoanPage(driver);
		clp.clickCarLoan();
		logger.info("carloan button is clicked");
      
        
        	try {
        		Assert.assertEquals((driver.getTitle()), getInputDataProperties("CarLoanPageTitile"));
				reporter("carLoanPageTest","Pass");
				report.onTestSuccess("carLoanPageTest");
			} catch (Exception e) {
				// TODO Auto-generated catch block
	        	captureScreen(driver,"carLoanPageTest");
	        	reporter("carLoanPageTest","Fail");
	        	report.onTestFailure("carLoanPageTest");
			}
     
        RefreshPage();
        logger.info("TS_01 . TC_01 is Completed");
	}
}