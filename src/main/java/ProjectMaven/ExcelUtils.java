package ProjectMaven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	private static XSSFWorkbook workbook;
	private static XSSFSheet worksheet;
	
public static Object[][] readExcel(String filePath, String sheetName) {
	Object[][] data = null;
	try {
		FileInputStream file = new FileInputStream(filePath);
		workbook = new XSSFWorkbook(file);
		worksheet = workbook.getSheet(sheetName);
		int rowCount = worksheet.getLastRowNum();
		int column = worksheet.getRow(0).getLastCellNum();
	    data = new Object[rowCount][column];
		for (int i=1; i<rowCount; i++) {
			XSSFRow row = worksheet.getRow(i); //row
            for(int j=0; j<column; j++) {
                XSSFCell cell = row.getCell(j);
                DataFormatter formatter = new DataFormatter();
                String val = formatter.formatCellValue(cell);
                data[i-1][j] = val; //data[0][0], data[1][1], data[2][2], data[3][3]
            }
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
	return null;
	
}
}
