package testScenario_002;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_02 extends DriverSetup {
	
	@Test 
	public void validHomeValueAmountTest() throws IOException {
		//Method for checking the Home value amount text box passing with valid data
		  Reporting report = new Reporting();
		  
		   try {
			   
			   
				logger.info("TS_02 . TC_01 is Started");
				logger.info("URL is opened");
				HomeLoanPage clp = new HomeLoanPage(driver);
				TakeExcelData data = new TakeExcelData();
				
				clp.clickCalculatorButton();
				logger.info("calculatorButton button is clicked");
				
				clp.clickHomeLoanSelectButton();
				logger.info("HomeLoanButton button is clicked");
				
				clp.setHomePriceAmount(data.getHV());
				logger.info("valid data Home price amount is passed");
				
				String ldata=data.getHV();
				String hpa=clp.getHomePriceAmount();
				 hpa=hpa.replaceAll("[^0-9]", ""); 
				Assert.assertEquals(ldata,hpa);
				reporter("validHomeValueAmountTest","Pass");
				report.onTestSuccess("validHomeValueAmountTest");
			} catch (AssertionError e) {
				reporter("validHomeValueAmountTest","Fail");
				captureScreen(driver,"validHomeValueAmountTest");
				report.onTestFailure("validHomeValueAmountTest");
			}
			    
			    RefreshPage();
			    logger.info("TS_02 . TC_02 is Completed");
			}
	 }