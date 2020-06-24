package setup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Base.BaseClass;
import pageObjects.CarLoanPage;

import utilities.Reporting;

public class DriverSetup extends BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public ExtentReports Report = Reporting.onStart();
	

	//Method for invoking the browser
	//@Parameters({"browsers"})
	@BeforeSuite
	public void getDriver() throws Exception  {
		
		

		logger = Logger.getLogger("EMICalculator");
		PropertyConfigurator.configure("Log4j.properties");
	    String browserName = getInputDataProperties("browser");
	    String environment= getInputDataProperties("Environment");
	  //System.out.println(".............INVOKING "+browserName+" BROWSER.............");
	    
	    if(environment.equalsIgnoreCase("Grid")) {
	    	
	    	String hubUrl="http://localhost:4444/wd/hub";
	

	    	DesiredCapabilities capabilities=new DesiredCapabilities();
	    	capabilities.setBrowserName(browserName);
	    	capabilities.setPlatform(Platform.WINDOWS);

	    	if(browserName.equalsIgnoreCase("chrome"))
	    	{
	    	ChromeOptions options= new ChromeOptions();
	    	options.merge(capabilities);

	    	try {
	    	driver= new RemoteWebDriver(new URL(hubUrl),options);
	    	} catch (MalformedURLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    	}
	    	}

	    	else if(browserName.equalsIgnoreCase("firefox"))
	    	{
	    	FirefoxOptions firefoxOptions=new FirefoxOptions();
	    	firefoxOptions.merge(capabilities);
	    	firefoxOptions.addPreference("log", "{level: trace}");
			
	    	capabilities.setCapability("marionette", true);

	    	try {
	    	driver=new RemoteWebDriver(new URL(hubUrl),firefoxOptions);
	    	} catch (MalformedURLException e) {
	    	e.printStackTrace();
	    	}

	    	}
	    	
	    }
		
	    else if(environment.equalsIgnoreCase("Local")) {
         
		if (browserName.equalsIgnoreCase("Chrome")) {
			browserName = getInputDataProperties("Browser1");
			String driverPath = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			browserName = getInputDataProperties("Browser2");
			String driverPath1 = System.getProperty("user.dir") + "\\Drsivers\\msedgedriver.exe";
			System.setProperty("webdriver.edge.driver", driverPath1);
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			browserName = getInputDataProperties("Browser3");
			String driverPath1 = System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", driverPath1);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("INVALID DRIVER");
		}
	    }
		
		String URL = getInputDataProperties("baseURL"); // Gets the URL
		driver.get(URL); // Navigates to the 'EMI' web page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
	//Method for Refreshing the page
	public static void RefreshPage() {
		driver.navigate().refresh(); // Refreshes the entire web page
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit(); // Closes the browser
		Report.flush();
	}

}
