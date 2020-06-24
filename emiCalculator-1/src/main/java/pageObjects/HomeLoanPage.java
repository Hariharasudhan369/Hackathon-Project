package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.BaseClass;
import setup.DriverSetup;
 


public class HomeLoanPage extends DriverSetup {

WebDriver ldriver;

	
	public HomeLoanPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// WebElement of Calculator button in the top
	@FindBy(xpath = "//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement calculatorButton;
	
	// WebElement of Home Loan Emi Calculator button in drop down
	@FindBy(xpath = "//*[@id=\"menu-item-3294\"]/a")
	WebElement homeLoanSelectButton;
	
	//WebElement of Home Price amount text box
	@FindBy(id = "homeprice")
	WebElement homePriceAmount;
	
	//WebElement of Home Down Payment amount text box
	@FindBy(id = "downpayment")
	WebElement homeDownPayment;
	
	//WebElement of Home Loan Insurance amount text box
	@FindBy(id = "homeloaninsuranceamount")
	WebElement homeLoanInsuranceAmount;       
	
	//WebElement of Home Loan amount text box
	@FindBy(id = "homeloanamount")
	WebElement homeLoanAmount;
	
	//WebElement of Home Loan Interest amount text box
	@FindBy(id = "homeloaninterest")
	WebElement homeLoanInterest;
	
	//WebElement of Home Loan Term amount text box
	@FindBy(id = "homeloanterm")
	WebElement homeLoanTerm;

	//WebElement of Home Loan Fees amount text box
	@FindBy(id = "loanfees")
	WebElement homeLoanFees;

	//WebElement of Start Month and Year text box
    @FindBy(id = "startmonthyear")
	WebElement startMonthAndYear;
    
   //WebElement of year 2020
    @FindBy(css = "td#year2020")
	WebElement y2020;
    
  // Method for clicking Calculator button in the top
    public void clickCalculatorButton()
	{
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	calculatorButton.click();
    	//logger.log(Status.INFO, "Calculator Button is Clicked");
	}
    
   // Method for clicking Home Loan Emi Calculator button in drop down
    public void clickHomeLoanSelectButton()
	{
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	homeLoanSelectButton.click();
    	//logger.log(Status.INFO, "HomeLoan Button is Clicked");
	}
    
   //Method for passing value in Home Price amount text box
    public void setHomePriceAmount(String hpamt)
	{
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	homePriceAmount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
    	homePriceAmount.sendKeys(hpamt);
    	homePriceAmount.sendKeys(Keys.ENTER);
		//logger.log(Status.INFO, "Entered home value");
    	//waitForText(driver, loanTerm, loantenure);
	}
    
   //Method for passing value in Home Down Payment amount text box
    public void setDownPayment(String hdpamt)
   	{
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	homeDownPayment.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
    	homeDownPayment.sendKeys(hdpamt);
    	homeDownPayment.sendKeys(Keys.ENTER);
    	//logger.log(Status.INFO, "Entered Down Payment");
    	//waitForText(driver, loanTerm, loantenure);
   	}
   
    //Method for passing value in Home Loan Insurance amount text box
    public void setHomeLoanInsuranceAmount(String hliamt)
   	{
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	homeLoanInsuranceAmount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
    	homeLoanInsuranceAmount.sendKeys(hliamt);
    	homeLoanInsuranceAmount.sendKeys(Keys.ENTER);
    	//logger.log(Status.INFO, "Entered Loan Insurance");
    	//waitForText(driver, loanTerm, loantenure);
   	}
    
  //Method for passing value in Home Loan amount text box
    public void setHomeLoanAmount(String hlamt)
	{
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	homeLoanAmount.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
    	homeLoanAmount.sendKeys(hlamt);
    	homeLoanAmount.sendKeys(Keys.ENTER);
    	//logger.log(Status.INFO, "Entered Loan Amount");
    	//waitForText(driver, loanTerm, loantenure);
	}
	
  //Method for passing value in Home Loan Interest text box
	public void setHomeLoanInterest(String hlint)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homeLoanInterest.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		homeLoanInterest.sendKeys(hlint);
		homeLoanInterest.sendKeys(Keys.ENTER);
		//logger.log(Status.INFO, "Entered Interest Rate");
		//waitForText(driver, loanTerm, loantenure);
	}
	
	//Method for passing value in Home Loan Tenure text box
	public void setHomeLoanTerm(String hlterm)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homeLoanTerm.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		homeLoanTerm.sendKeys(hlterm);
		homeLoanTerm.sendKeys(Keys.ENTER);
		//logger.log(Status.INFO, "Entered Tenure");
		//waitForText(driver, loanTerm, loantenure);
	}
	//Method for passing value in Loan Fees and Charger text box
	public void setHomeLoanFees(String hlfees)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homeLoanFees.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
		homeLoanFees.sendKeys(hlfees);
		homeLoanFees.sendKeys(Keys.ENTER);
		//logger.log(Status.INFO, "Entered Fees");
		
		//waitForText(driver, loanTerm, loantenure);
	}
	
	//Method to select the starting month and year
		public void selectDateIncalendar(String date) throws Exception {
			startMonthAndYear.click();
			Date currentDate = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MMM/yyyy");
			Date expectedDate = dateFormat.parse(date);

			// String day = new SimpleDateFormat("dd").format(expectedDate);
			String month = new SimpleDateFormat("MMM").format(expectedDate);
			String year = new SimpleDateFormat("yyyy").format(expectedDate);

			String expectedYear = year;
			

			while (true) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String displayDate = driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[2]"))
						.getText();

				if (expectedYear.equals(displayDate)) {
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

					driver.findElement(By.xpath("//span[text()= '" + month + "']")).click();

					break;
				} else if (expectedDate.compareTo(currentDate) > 0) {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[3]")).click();
				} else {
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/thead/tr[2]/th[1]")).click();
				}

			}
			//logger.log(Status.INFO, "Date is Selected");

		}
		
		//Method for passing the values taken from result table to excel
		public void ExportToExcel() throws FileNotFoundException {
			File source = new File(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\writing.xlsx");

			FileInputStream fis = new FileInputStream(source);

			try {
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sh = wb.getSheet("Sheet1");

			String BeforePath = "//*[@id='paymentschedule']/table/tbody/tr[";
			String AfterPathPrincipal ="]/td[2]";
			String AfterPathInterest ="]/td[3]";
			String AfterPathTax ="]/td[4]";
			String AfterPathTotal ="]/td[5]";
			String AfterPathBalance ="]/td[6]";
			String AfterPathPaidPerct ="]/td[7]";

			String h0=driver.findElement(By.xpath("//*[@id='yearheader']")).getText();
			String h1=driver.findElement(By.xpath("//*[@id='principalheader']")).getText();
			String h2=driver.findElement(By.xpath("//*[@id='interestheader']")).getText();
			String h3=driver.findElement(By.xpath("//*[@id='insuranceandtaxesheader']")).getText();
			String h4=driver.findElement(By.xpath("//*[@id='totalheader']")).getText();
			String h5=driver.findElement(By.xpath("//*[@id='balanceheader']")).getText();
			String h6=driver.findElement(By.xpath("//*[@id='paidtodateheader']")).getText();


			sh.createRow(2).createCell(0).setCellValue(h0);
			sh.getRow(2).createCell(1).setCellValue(h1);
			sh.getRow(2).createCell(2).setCellValue(h2);
			sh.getRow(2).createCell(3).setCellValue(h3);
			sh.getRow(2).createCell(4).setCellValue(h4);
			sh.getRow(2).createCell(5).setCellValue(h5);
			sh.getRow(2).createCell(6).setCellValue(h6);
			int year =2020;
			int j=3;


			for(int i= 2; i<=12 ;i=i+2)
			{
			String ActualPrincipal = BeforePath+i+AfterPathPrincipal;
			String ActualInterest = BeforePath+i+AfterPathInterest;
			String ActualTax = BeforePath+i+AfterPathTax;
			String ActualTotal = BeforePath+i+AfterPathTotal;
			String ActualBalance = BeforePath+i+AfterPathBalance;
			String ActualLoanpaid = BeforePath+i+AfterPathPaidPerct;

			String amount1 = driver.findElement(By.xpath(ActualPrincipal)).getText();
			String amount2 = driver.findElement(By.xpath(ActualInterest)).getText();
			String amount3 = driver.findElement(By.xpath(ActualTax)).getText();
			String amount4 = driver.findElement(By.xpath(ActualTotal)).getText();
			String amount5 = driver.findElement(By.xpath(ActualBalance)).getText();
			String amount6 = driver.findElement(By.xpath(ActualLoanpaid)).getText();


			sh.createRow(j).createCell(0).setCellValue(year);
			sh.getRow(j).createCell(1).setCellValue(amount1);
			sh.getRow(j).createCell(2).setCellValue(amount2);
			sh.getRow(j).createCell(3).setCellValue(amount3);
			sh.getRow(j).createCell(4).setCellValue(amount4);
			sh.getRow(j).createCell(5).setCellValue(amount5);
			sh.getRow(j).createCell(6).setCellValue(amount6);
			year++;
			j++;

			System.out.println(amount1+"  "+amount2+"   "+amount3+"  "+amount4+"  "+amount5+"  "+amount6);

			}

			FileOutputStream fos = new FileOutputStream(source);

			wb.write(fos);
			wb.close();
			//	reportPass("Sucessfully Stroed data in Excel");
			} catch (IOException e) {
				//reportFail(e.getMessage());
			}
			//logger.log(Status.INFO, "Data Exported to Excel");

		}
		
		//Methods to get the entered values from text boxes
		public String getHomePriceAmount() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homePriceAmount.getAttribute("value");

		}

		public String getHomeDownPayment() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homeDownPayment.getAttribute("value");

		}

		public String getHomeLoanInsuranceAmount() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homeLoanInsuranceAmount.getAttribute("value");

		}

		public String getHomeLoanInterest() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homeLoanInterest.getAttribute("value");

		}
		
		public String getHomeLoanAmount() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homeLoanAmount.getAttribute("value");
		}

		public String getHomeLoanTerm() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homeLoanTerm.getAttribute("value");

		}

		public String getHomeLoanFees() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return homeLoanFees.getAttribute("value");

		}

}