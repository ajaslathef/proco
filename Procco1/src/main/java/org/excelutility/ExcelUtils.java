package org.excelutility;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {


		public static String projectPath;
		public static XSSFWorkbook workbook;
		public static XSSFSheet sheet;
		
		
		public ExcelUtils(String excelpath, String sheetname) {
			
			try {
				projectPath = System.getProperty("user.dir");
				workbook = new XSSFWorkbook(excelpath);
				sheet = workbook.getSheet(sheetname);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
		
		public static int getRowCount() {
			int rowCount = 0;
			
			try {
				 rowCount = sheet.getPhysicalNumberOfRows();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
			return rowCount;	
		}
		
		public static int getcolCount() {
			int colCount = 0;
			
			try {
				
			 colCount = sheet.getRow(0).getPhysicalNumberOfCells();
						
			} catch (Exception e) {
				
			}
			return colCount;
		}
		
		public static String getcellData(int rownumber, int cellnumber) {
			String celldata = null;
			
			try {
				
				DataFormatter df = new DataFormatter();
				celldata = df.formatCellValue(sheet.getRow(rownumber).getCell(cellnumber));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return celldata;
			

		}

	}



