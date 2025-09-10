package xml_TESTNG;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class Excel_Data {
	
	public static void main(String[] args) throws Exception {

		
		FileInputStream fis = new FileInputStream( System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("Data");
		    if (sheet == null) throw new RuntimeException("Sheet 'Data' not found!");

		    Row row = sheet.getRow(2);
		    if (row == null) throw new RuntimeException("Row 2 not found!");

		    Cell col = row.getCell(0);
		    if (col == null) throw new RuntimeException("Cell (2,2) not found!");
		  
		    System.out.println("Value: " + col.toString());

	}

	public static String Exceldata(int row,int col) throws Exception {
		String value ="";
		FileInputStream fis = new FileInputStream( System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		 Sheet sheet = wb.getSheet("Data");
		 value = sheet.getRow(row).getCell(col).toString();
		 System.out.println(value);
		 return value;
		
	}
}
