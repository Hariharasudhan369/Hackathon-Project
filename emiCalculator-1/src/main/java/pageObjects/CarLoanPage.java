package pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseClass;
import setup.DriverSetup;

public class CarLoanPage extends DriverSetup {
	

WebDriver ldriver;
	
	public CarLoanPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	


	//Webelement of the Car Loan Tab
	@FindBy(xpath = "//*[@id=\"car-loan\"]/a")
	WebElement buttonCarLoan;
	
	//Webelement for the Car loan amount
	@FindBy(name="loanamount")
	WebElement carLoanAmount;
	
	//Webelement for the car loan amount slider
	@FindBy(xpath = "//*[@id=\"loanamountslider\"]/span")
	WebElement amountSlider;
	
	//Webelement for the Loan Interest Rate
	@FindBy(name="loaninterest")
	WebElement carLoanInterest;
	
	//Webelement for the Interest rate slider
	@FindBy(xpath = "//*[@id=\"loaninterestslider\"]/span")
	WebElement interestSlider;
	
	//Webelement for the Loan Tenure
	@FindBy(name="loanterm")
	WebElement carLoanTerm;
	
	//Webelement for the loan tenure slider
	@FindBy(xpath = "//*[@id=\"loantermslider\"]/span")
	WebElement termSlider;
	
	//Webelement for the month button in the loan tenure
	@FindBy(xpath = "//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[2]")
	WebElement monthButton;
	
	//Webelement for the EMI Arrears button
	@FindBy(xpath = "//*[@id='leschemewrapper']/div/div/div/div/label[2]")
	WebElement EMIInArrearButton;
	
	//Webelement for the Calculator drop down box
	@FindBy(xpath = "//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement dropDownButton;
	
	//Webelement for the year 2020 drop down in the result
	@FindBy(id = "year2020")
	WebElement yearButton;
	
	//Webelement of the Principal column in the table
	@FindBy(xpath = "//*[@id=\"monthyear2020\"]/td/div/table/tbody/tr[1]/td[2]")
	WebElement principalAmountCar;
	
	//Webelement of the Interest column in the table
	@FindBy(xpath = "//*[@id=\"monthyear2020\"]/td/div/table/tbody/tr[1]/td[3]")
	WebElement interestAmountCar;
	
	//Method for clicking the Car Loan Tab
	public void clickCarLoan() throws Exception
	{
		//waitForElement(driver,buttonCarLoan );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		buttonCarLoan.click();
		
	}
	
	//Method for passing value in the Car loan amount text box
	public void setCarLoanAmount(String clamt) throws Exception
	{
		//waitForElement(driver,carLoanAmount );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		carLoanAmount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		carLoanAmount.sendKeys(clamt);
		carLoanAmount.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waitForText(driver, carLoanAmount, clamt);
		//logger.log(Status.INFO, "Entered Car Loan value");
	}
	
	//Method for the car loan amount slider
	public String getLoanAmountSlider() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return amountSlider.getAttribute("style");
	}
	
	//Method for passing value in the Loan Interest Rate text box
	public void setCarLoanInterest(String clint) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waitForElement(driver,carLoanInterest );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		carLoanInterest.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		carLoanInterest.sendKeys(clint);
		carLoanInterest.sendKeys(Keys.ENTER);
		//waitForText(driver, carLoanInterest, clint);
		//logger.log(Status.INFO, "Entered Interest value");
	}

	//Method for the car loan Interest Rate slider
    public String getLoanInterestSlider() throws Exception {
		
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return amountSlider.getAttribute("style");
	}
	
    //Webelement for passing values in the Loan Tenure text box	
    public void setCarLoanTerm(String clterm) throws Exception
	{
		//waitForElement(driver,carLoanTerm );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		carLoanTerm.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		carLoanTerm.sendKeys(clterm);
		carLoanTerm.sendKeys(Keys.ENTER);
		//logger.log(Status.INFO, "Entered Term value");
		//waitForText(driver, carLoanTerm, clterm);
	}
	
  //Method for the car Tenure Rate slider
   public String getLoanTermSlider() throws Exception {
		
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return amountSlider.getAttribute("style");
	}

   //Method for clicking the month button in the loan tenure
	public void clickMonthButton() 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForElement(driver,monthButton );
		monthButton.click();	
	}
	
	//Method for clicking the EMI Arrears button
	public void clickEMIInArrearButton() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitForElement(driver,EMIInArrearButton );
		EMIInArrearButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//Method for clicking the year 2020 drop down in the result
	public void clickYearButton() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//waitForElement(driver,yearButton );
		yearButton.click();
		//logger.log(Status.INFO, "Year Button is clicked");
	}
	
	//Method for getting the Principal column from the table
	public String getPrincipalAmountCarLoan() {
		//waitForElement(driver,principalAmountCar );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println(principalAmountCar.getText());
		//logger.log(Status.INFO, "Principal amount for first month Is "+principalAmountCar.getText());
		return principalAmountCar.getText();

	}

	// method to get the Interest amount from the table
	public String getInterestAmountCarLoan() 
	{
		//waitForElement(driver,interestAmountCar );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//System.out.println(interestAmountCar.getText());
		//logger.log(Status.INFO, "Interest amount for first month Is "+interestAmountCar.getText());
		return interestAmountCar.getText();
	}
	
	//returns the values entered in the text boxes
	public String getCarLoanAmount() {
		//waitForElement(driver,carLoanAmount );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return carLoanAmount.getAttribute("value");
	}
	public String getCarLoanInterest() {
		//waitForElement(driver,carLoanInterest );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return carLoanInterest.getAttribute("value");
	}
	public String getCarLoanTerm() {
		//waitForElement(driver,carLoanTerm );
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return carLoanTerm.getAttribute("value");
	}
}