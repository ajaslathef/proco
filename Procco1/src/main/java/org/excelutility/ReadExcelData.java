package org.excelutility;

public class ReadExcelData {
	
public static Object[][] testdata(String excelpath, String sheetname) {
		
		ExcelUtils excel = new ExcelUtils(excelpath, sheetname);
		int rowCount = excel.getRowCount();
		int getcolCount = excel.getcolCount();
		
		Object[][] data = new Object[rowCount-1][getcolCount];
		for (int i = 1; i <rowCount ; i++) {
			for (int j = 0; j < getcolCount; j++) {
				String getcellData = excel.getcellData(i, j);
				data[i-1][j]=getcellData;
				
				
			}
			
		}
		
		return data;

	}

}
