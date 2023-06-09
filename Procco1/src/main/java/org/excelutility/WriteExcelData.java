package org.excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

    public  WriteExcelData() {
	
		try {
			
			fis = new FileInputStream("D:\\eclipse-workspace\\PulseAssignement\\ExcelOutPut\\OutPut.xlsx");
			workbook = new XSSFWorkbook(fis);
			fis.close();
			
		} 
		
		catch (Exception e) {
			e.printStackTrace() ;
			
		}
		}
		
	public boolean SetStatus(int rowNum, String colName, String value) {
			
		try {
			
			int colNum = 0;
			sheet = workbook.getSheet("Input");
			row = sheet.getRow(0);
			for (int i=0; i<row.getLastCellNum(); i++) {
				
				if(row.getCell(i).getStringCellValue().trim().equals(colName)) {
						
					colNum = i;
					}
				}
				row = sheet.getRow(rowNum);
				if(row == null)
					row = sheet.createRow(rowNum);
				
				cell = row.getCell(colNum);
						if(cell == null)
					    cell = row.createCell(colNum);
						cell.setCellValue(value);
						fos = new FileOutputStream("D:\\eclipse-workspace\\PulseAssignement\\ExcelOutPut\\OutPut.xlsx");
						workbook.write(fos);
						fos.close();
				
			} catch (Exception e) {

				e.printStackTrace();
				return false;
			}
		
			return true;	

       }
}    
