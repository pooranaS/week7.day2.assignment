package week7.day2.assignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] readData(String excelFileName) throws IOException {

		// Open the Excel sheet
		XSSFWorkbook book = new XSSFWorkbook("./TestData/" + excelFileName + ".xlsx");

		// get to sheet where data is available

		XSSFSheet sheet = book.getSheetAt(0);

		// get row count
		int rowCount = sheet.getLastRowNum();
		System.out.println("The Row Count is " + rowCount);

		// get column count
		XSSFRow headerRow = sheet.getRow(0);
		short colCount = headerRow.getLastCellNum();
		System.out.println("The Column count is " + colCount);

		// getting datas from each cell

		String[][] data1 = new String[rowCount][colCount];

		for (int i = 1; i <= rowCount; i++) {

			XSSFRow eachRow = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {

				XSSFCell eachCol = eachRow.getCell(j);
				String data = eachCol.getStringCellValue();
				System.out.print(data + "\t");
				data1[i - 1][j] = data;

			}

			System.out.println();
		}

		return data1;

	}
}
