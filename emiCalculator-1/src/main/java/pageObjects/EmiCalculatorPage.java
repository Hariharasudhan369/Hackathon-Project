package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseClass;
import setup.DriverSetup;

public class EmiCalculatorPage extends DriverSetup {
	

WebDriver ldriver;
	
	public EmiCalculatorPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	     Actions actions = new Actions(driver);
	     
	
	    // WebElement of Calculator button in the top
		@FindBy(xpath = "/html/body/header/div/nav/div[2]/div/ul/li[1]/a")
		WebElement calculatorbutton;

		// WebElement of Loan Calculators
		@FindBy(xpath = "//*[@id=\"menu-item-2423\"]/a")
		WebElement loanCalculator;
	    
	    //WebElement of Loan amount text box
		@FindBy(id = "loanamount")
		WebElement loanAmount;
		
		//Webelement for the loan amount slider
		@FindBy(xpath="//*[@id=\"loanamountslider\"]/span")
		WebElement loanAmountSlider;
		
		//Webelement for the loan amount slider at different position
		@FindBy(xpath="//*[@id=\"loanamountsteps\"]/span[5]")
		WebElement loanAmountSliderSetter;
		
		//Webelement for the Interest rate slider
		@FindBy(xpath="//*[@id=\"loaninterestslider\"]/span")
		WebElement interestRateSlider;
		
		//Webelement for the Interest rate slider at different position
		@FindBy(xpath="//*[@id=\"loanintereststeps\"]/span[5]")
		WebElement interestRateSetter;
		
		//Webelement for the Loan Tenure slider
		@FindBy(xpath="//*[@id=\"loantermslider\"]/span")
		WebElement loanTermSlider;
		
		//Webelement for the Loan Tenure slider at different position
		@FindBy(xpath="//*[@id=\"loantermsteps\"]/span[4]")
		WebElement loanTermSliderSetter;
		
		//Webelement for the Fees and Charges slider
		@FindBy(xpath="//*[@id=\"loanfeesslider\"]/span")
		WebElement loanFeesSlider;
		
		//Webelement for the Fees and Charges slider at different position
		@FindBy(xpath="//*[@id=\"loanfeessteps\"]/span[3]")
		WebElement loanFeesSliderSetter;
		
		//Webelement for the EMI slider
		@FindBy(xpath="//*[@id=\"loanemislider\"]/span")
		WebElement EMISlider;
		
		//Webelement for the EMI slider at different position
		@FindBy(xpath="//*[@id=\"loanemisteps\"]/span[3]")
		WebElement EMISliderSetter;
		
		
		//WebElement of Loan Interest text box
		@FindBy(id = "loaninterest")
		WebElement loanInterest;
		
		//WebElement of Loan term text box
		@FindBy(xpath = "//*[@id=\"loanterm\"]")
		WebElement loanTerm;
		
		//WebElement of Loan Fees text box
		@FindBy(id = "loanfees")
		WebElement loanFees;
		
		//WebElement of EMI in arrears button
		@FindBy(xpath = "//*[@id=\"leschemewrapper\"]/div/div/div/div/label[2]")
		WebElement emiArrears;
		
		//Webelement for choosing the Loan Amount Calculator tab
		@FindBy(xpath="//*[@id=\"loan-amount-calc\"]/a[1]")
		WebElement loanAmountCalculatorButton;
		
		//Webelement for the emi text box
		@FindBy(id = "loanemi")
		WebElement loanEmi;
		
		//Webelement for choosing the Loan Tenure Calculator tab 
		@FindBy(xpath = "//*[@id=\"loan-tenure-calc\"]/a[1]")
		WebElement loanTenureCalculatorButton;
		
		//Method to click calculator drop down button
		public void clickCalculatorButton() throws Exception {
			//waitForElement(driver,calculatorbutton );
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			calculatorbutton.click();
			//logger.log(Status.INFO, "Calculator Button is clicked");
		}
		
		//Method to click loan calculator button
		public void clickLoanCalculatorButton() throws Exception {
			//waitForElement(driver,calculatorbutton );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanCalculator.click();
			//logger.log(Status.INFO, "Loan Calculator Button is clicked");
		}
		
		
		//Method to enter into Loan Amount textbox
		public void setLoanAmount(String loanAmt) throws Exception {
			//waitForElement(driver,loanAmount );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanAmount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			loanAmount.sendKeys(loanAmt);
			loanAmount.sendKeys(Keys.ENTER);
			//logger.log(Status.INFO, "Entered Loan amount");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//waitForText(driver, loanAmount, loanAmt);
		}
		
		//Method for the dragging the slider in the loan amount
		public void setLoanAmountSlider() throws Exception {
			//waitForElement(driver,loanAmountSliderSetter );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			actions.dragAndDrop(loanAmountSlider,loanAmountSliderSetter).perform(); 
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//logger.log(Status.INFO, "Setted Loan amount slider");
		}
		
		//Method for getting the Interest rate slider position
		public String getLoanInterestSlider() throws Exception {
			//waitForElement(driver,interestRateSlider );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return interestRateSlider.getAttribute("style");
		}
		
		//Method for the dragging the slider in the Interest rate
       public void setLoanInterestSlider() throws Exception {
    	   //waitForElement(driver,interestRateSetter );
    	   //Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	   actions.dragAndDrop(interestRateSlider,interestRateSetter).perform();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	   //logger.log(Status.INFO, "Setted Loan interest slider");
		}
		
     //Method for getting the Loan tenure slider position
		public String getLoanTermSlider() throws Exception {
			//waitForElement(driver,loanTermSlider );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanTermSlider.getAttribute("style");
		}
		
		//Method for the dragging the slider in the Loan tenure
        public void setLoanTermSlider() throws Exception {
        	//waitForElement(driver,loanTermSliderSetter );
        	//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	actions.dragAndDrop(loanTermSlider,loanTermSliderSetter).perform();
        	//logger.log(Status.INFO, "Setted Loan term slider");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
      //Method for getting the Fees and charges slider position
		public String getLoanFeesSlider() throws Exception {
			//waitForElement(driver,loanFeesSlider );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanFeesSlider.getAttribute("style");
		}
		
		//Method for the dragging the slider in the Fees and charges
         public void setLoanFeesSlider() throws Exception {
        	// waitForElement(driver,loanFeesSliderSetter );
        	// Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	 actions.dragAndDrop(loanFeesSlider,loanFeesSliderSetter).perform();
        	 //logger.log(Status.INFO, "Setted Loan fees slider");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
       //Method for getting the EMI slider position
		public String getEMISlider() throws Exception {
			//waitForElement(driver,EMISlider );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return EMISlider.getAttribute("style");
		}
		
		//Method for the dragging the slider in the EMI
        public void setEMISlider() throws Exception {
        	//waitForElement(driver,EMISliderSetter );
        	//Thread.sleep(3000);
        	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        	actions.dragAndDrop(EMISlider,EMISliderSetter).perform();
        	//logger.log(Status.INFO, "Setted EMI slider");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
      //Method for getting the Loan Amount slider position
		public String getLoanAmountSlider() throws Exception {
			//waitForElement(driver,loanAmountSlider );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanAmountSlider.getAttribute("style");
		}
		
		//Method to enter into Loan Interest textbox
		public void setLoanInterest(String loanInt) throws Exception {
			//waitForElement(driver,loanInterest );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanInterest.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			loanInterest.sendKeys(loanInt);
			loanInterest.sendKeys(Keys.ENTER);
			//logger.log(Status.INFO, "Entered Loan Interest");
			//waitForText(driver, loanInterest, loanInt);
			}
		
		//Method to enter into Loan Tenure textbox
		public void setLoanTerm(String loantenure) throws Exception {
			//waitForElement(driver,loanTerm );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanTerm.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END)); 
			loanTerm.sendKeys(loantenure);
			loanTerm.sendKeys(Keys.ENTER);
			//logger.log(Status.INFO, "Entered Loan Tenure");
			//waitForText(driver, loanTerm, loantenure);
		}
		
		////Method to enter into Loan Fees textbox
		public void setLoanFees(String loanfees) throws Exception {
			//waitForElement(driver,loanFees );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanFees.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			loanFees.sendKeys(loanfees);
			loanFees.sendKeys(Keys.ENTER);
			//logger.log(Status.INFO, "Entered Loan Fees");
			//waitForText(driver, loanFees, loanfees);
		}
		
		//Method to click emi arrear button 
		public void clickemiarr() throws Exception {
			//waitForElement(driver,emiArrears );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			emiArrears.click();
			//logger.log(Status.INFO, "EMI arrears button is clicked");
			
		}
		
		//Method to click Loan Amount Calculator button
		public void clickLoanAmtCal() throws Exception {
			//waitForElement(driver,loanAmountCalculatorButton );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanAmountCalculatorButton.click();
			//logger.log(Status.INFO, "Loan amount calculator button is clicked");
		}
		
		//Method to click Loan Tenure Calculator button
		public void clicktenureCalcButton() throws Exception {
			//waitForElement(driver,loanTenureCalculatorButton );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanTenureCalculatorButton.click();
			//logger.log(Status.INFO, "Loan tenure calculator Button is clicked");
		}
		
		//Method to enter EMI amount 
		public void setEmi(String EMIAmount) throws Exception {
			//waitForElement(driver,loanEmi );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loanEmi.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
			loanEmi.sendKeys(EMIAmount);
			loanEmi.sendKeys(Keys.ENTER);
			//logger.log(Status.INFO, "Entered EMI ");
			//waitForText(driver, loanEmi, EMIAmount);
		}
		
		
		//Methods to get the entered values in text boxes
		public String getlnamntvalue() throws Exception {
			//waitForElement(driver,loanAmount );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanAmount.getAttribute("value");
		}
		public String getintrtvalue() throws Exception {
			//waitForElement(driver,loanInterest );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanInterest.getAttribute("value");
		}
		public String gettenurevalue() throws Exception {
			//waitForElement(driver,loanTerm );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanTerm.getAttribute("value");
		}
		public String getfeesvalue() throws Exception {
			//waitForElement(driver,loanFees );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanFees.getAttribute("value");
		}
		public String getEMIvalue() throws Exception {
			//waitForElement(driver,loanEmi );
			//Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return loanEmi.getAttribute("value");
		}	
	

}