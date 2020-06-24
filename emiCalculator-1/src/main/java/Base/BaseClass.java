package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import setup.DriverSetup;
import utilities.ReportToExcel;
import utilities.Reporting;




public class BaseClass  {

	
	    // Wait for the visibility of the element
		public void waitForElement(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}

		// wait for the text to be present in the element
		public void waitForText(WebDriver driver, WebElement element, String text) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		}
		
		//Method to report testcase Status
		public static void reporter(String TestCaseName , String status) {
			ReportToExcel.write(TestCaseName, status);
		}

		
		
		
		// To read the properties file
		public static String getInputDataProperties(String key) throws IOException {
			Properties prop = new Properties();
			FileInputStream Input = new FileInputStream(System.getProperty("user.dir") + "//src//test//java//testData//InputData.properties");
			prop.load(Input);
			return prop.getProperty(key);
		}
		
	    //Method to screenshot
		public static void captureScreen(WebDriver driver,String screenshotName){
			
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
			
			try {
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source=ts.getScreenshotAs(OutputType.FILE);
				File target = new File(System.getProperty("user.dir") +"\\Screenshots\\"+screenshotName+".png");
				FileUtils.copyFile(source, target);
				System.out.println("Screenshot taken");
			} catch (Exception e) {
				
				System.out.println("Exception while taking Screenshot"+e.getMessage());
			} 
		}
		
		

}