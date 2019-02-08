package test1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class TestReadExcel {
  

public static Object[][] testdata() {
	  
	  Object obj[][]=null;
	  String path = "src//test//resources//testdata.xlsx";
	  
	  File file = new File(path);
	  try {
		InputStream is = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rows = sheet.getPhysicalNumberOfRows();
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		obj = new Object[rows-1][];
		for (int i=1;i<rows;i++)
		{
			obj[i-1]=new Object[columns];
			for(int j=0;j<columns;j++)
			{
				obj[i-1][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println("The Result("+i+","+j+")  ="+sheet.getRow(i).getCell(j).getStringCellValue());
			}
		}
		workbook.close();
		
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return obj; 
  }
  
  
}
