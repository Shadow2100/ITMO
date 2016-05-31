package webprogramming;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvBind;

public class Java_5 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream in = new FileInputStream("./eco.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(in);
		ArrayList<String[]> rows = new ArrayList<String[]>();
		ArrayList<String> row1 = new ArrayList<String>();
		Sheet sheet = wb.getSheetAt(0);
		Iterator<Row> it = sheet.iterator();
		String[] tempRow;
		while (it.hasNext()) {
			row1.clear();
			Row row = it.next();
			Iterator<Cell> cells = row.iterator();
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int cellType = cell.getCellType();
				switch (cellType) {
				case Cell.CELL_TYPE_STRING:
					row1.add(cell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					row1.add(Double.toString(cell.getNumericCellValue()));
					break;

				case Cell.CELL_TYPE_FORMULA:
					row1.add(Double.toString(cell.getNumericCellValue()));
					break;
				default:
					break;
				}
				
			}
			rows.add(row1.toArray(new String[0]));
		}
		CSVWriter writer;
		writer = new CSVWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./result.csv"), "UTF-8")));
		Iterator<String[]> itStringArray=rows.iterator();
		while(itStringArray.hasNext()){
			tempRow=itStringArray.next();
			writer.writeNext(tempRow);
		}
				writer.close();
	}

}