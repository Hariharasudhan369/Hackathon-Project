package testScenario_002;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomeLoanPage;
import setup.DriverSetup;
import utilities.Reporting;
import utilities.TakeExcelData;

public class TC_15 extends DriverSetup {

	@Test
	public void validDataHomeLoanTest() throws Exception {
		//Method for importing result data to excel by giving all valid data
		Reporting report = new Reporting();
		
		try {
			
			logger.info("TS_02 . TC_08 is Started");
			logger.info("URL is opened");
			HomeLoanPage clp = new HomeLoanPage(driver);
			TakeExcelData data = new TakeExcelData();
			
			clp.clickCalculatorButton();
			logger.info("calculatorButton button is clicked");
			
			clp.clickHomeLoanSelectButton();
			logger.info("HomeLoanButton button is clicked");
			
			clp.setHomePriceAmount(data.getHV());
			logger.info("valid Home price is passed");
			
			clp.setDownPayment(data.getDP());
			logger.info("valid Downpayment value is passed");
			
			clp.setHomeLoanInsuranceAmount(data.getLI());
			logger.info("valid home loan insurance amount is passed");
			
			clp.setHomeLoanAmount(data.getHL());
			logger.info("valid home loan amount is passed");
			
			clp.setHomeLoanInterest(data.getIR());
			logger.info("valid home loan interest value is passed");
			
			clp.setHomeLoanTerm(data.getLT());
			logger.info("valid home loan term value is passed");
			
			clp.setHomeLoanFees(data.getLFees());
			logger.info("valid home loan fees value is passed");
			
			clp.selectDateIncalendar("Jun/2020");
			logger.info("date setted successfully");
			
			clp.ExportToExcel();
			logger.info("data imported to excel successfully");
			
			reporter("validDataHomeLoanTest","Pass");
			report.onTestSuccess("validDataHomeLoanTest");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			reporter("validDataHomeLoanTest","Fail");
			report.onTestFailure("validDataHomeLoanTest");
			captureScreen(driver,"validDataHomeLoanTest");
		
		} 
		
	}
}
