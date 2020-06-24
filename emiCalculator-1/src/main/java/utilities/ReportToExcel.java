package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ReportToExcel {

	//Method for passing result values to the excel
	public static void write(String testCaseName,String status)
    {
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\ResultReport.xlsx";

		try
		{
	
			FileInputStream fis=new FileInputStream(new File(filePath));
			
			XSSFWorkbook  xwb=new XSSFWorkbook(fis);
			XSSFSheet sheet= xwb.getSheet("Sheet1");
			
			 int totalRow=sheet.getLastRowNum();
			 
			 for(int i=1;i<=totalRow;i++)
			 {
				 XSSFRow row= sheet.getRow(i);
				 String cellValue=row.getCell(1).getStringCellValue();
				 if(cellValue.equalsIgnoreCase(testCaseName))
				 {
					 row.createCell(4).setCellValue(status);
					 fis.close();
					 FileOutputStream fos=new FileOutputStream(new File(filePath));
					 xwb.write(fos);
					 fos.close();
					 xwb.close();
					 break;
				 }
			 }
		
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

    
}
