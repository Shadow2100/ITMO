package webprogramming;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import com.opencsv.CSVWriter;

public class Java_5 {
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream("./wifi.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(in);
		ArrayList<String[]> tempRows = new ArrayList<String[]>();
		ArrayList<String> tempRow = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);
		for (Row row : sheet) {
			tempRow.clear();
			for (Cell cell : row) {
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					tempRow.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					tempRow.add(Double.toString(cell.getNumericCellValue()));
					break;

				case Cell.CELL_TYPE_FORMULA:
					tempRow.add(Double.toString(cell.getNumericCellValue()));
					break;
				default:
					break;
				}
			}
			tempRows.add(tempRow.toArray(new String[0]));
		}
		String[] tempRow2;
		wb.close();
		CSVWriter writer;
		writer = new CSVWriter(
				new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./result.csv"), "UTF-8")));
		Iterator<String[]> itStringArray = tempRows.iterator();
		while (itStringArray.hasNext()) {
			tempRow2 = itStringArray.next();
			writer.writeNext(tempRow2);
		}
		writer.close();
	}

}