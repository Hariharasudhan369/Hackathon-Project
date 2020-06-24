
package utilities;


import java.io.IOException;
import java.util.ArrayList;

import utilities.XLUtilities.ImportFromExcel;



public class TakeExcelData {
//Method for getting car loan amount value from excel
public String getCarloan() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data=d.getdata("car loan amount");
String carloanamount=(String) data.get(1);
return carloanamount;
}
//Method for getting car loan Interest value from excel
public String getInterest() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("car interest rate");
String carinterestrate=(String) data1.get(1);
return carinterestrate;
}
//Method for getting car tenure value from excel
public String getTenureYr() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("car tenure Year");
String cartenureYear=(String) data1.get(1);
return cartenureYear;
}
//Method for getting car tenure month value from excel
public String getTenureMn() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("car tenure Month");
String cartenureMonth=(String) data1.get(1);
return cartenureMonth;
}
//Method for getting Home price value from excel
public String getHV() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home price");
String homeprice=(String) data1.get(1);
return homeprice;
}
//Method for getting Home downpayment value from excel
public String getDP() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home down payment");
String homedownpayment=(String) data1.get(1);
return homedownpayment;
}
//Method for getting Home loan insurance value from excel
public String getLI() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home loan insurance");
String homeloaninsurance=(String) data1.get(1);
return homeloaninsurance;
}
//Method for getting Home loan amount value from excel
public String getHL() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home loan amount");
String homeloanamount=(String) data1.get(1);
return homeloanamount;
}
//Method for getting Home loan interest value from excel
public String getIR() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home loan interest");
String homeloaninterest=(String) data1.get(1);
return homeloaninterest;
}
//Method for getting Home loan tenure value from excel
public String getLT() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home loan tenure");
String homeloantenure=(String) data1.get(1);
return homeloantenure;
}
//Method for getting Home loan fees value from excel
public String getLFees() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("home loan fees");
String homeloanfees=(String) data1.get(1);
return homeloanfees;
}
//Method for getting loan amount value from excel
public String getLoanAmount() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("loan Amount");
String loanAmount=(String) data1.get(1);
return loanAmount;
}
//Method for getting Interest Rate value from excel
public String getInterestRate() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("Interest Rate");
String InterestRate=(String) data1.get(1);
return InterestRate;
}
//Method for getting loan tenure value from excel
public String getLoanTenure() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("loan Tenure");
String loanTenure=(String) data1.get(1);
return loanTenure;
}
//Method for getting fees and charges value from excel
public String getFees() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("fees and charges");
String feesandcharges=(String) data1.get(1);
return feesandcharges;
}
//Method for getting EMI value from excel
public String getEMI() throws IOException
{
ImportFromExcel d= new ImportFromExcel();
ArrayList data1=d.getdata("EMI");
String EMI=(String) data1.get(1);
return EMI;
}



}