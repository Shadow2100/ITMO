package webtechnologies.openData;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ParseOpenData {
	public static Wifi[] Parse() throws IOException {
		InputStream in = new FileInputStream("/wifi.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Sheet sheet = wb.getSheetAt(0);
		List<Wifi> listOfWifi = new ArrayList<Wifi>();
		for (Row row : sheet) {
			Wifi tempEntry = new Wifi();
			switch (row.getCell(0).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setIndex(Integer.parseInt(row.getCell(0).getStringCellValue()));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setIndex((int) row.getCell(0).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setIndex((int) row.getCell(0).getNumericCellValue());
				break;
			default:
				break;
			}
			tempEntry.setName(row.getCell(1).getStringCellValue());
			tempEntry.setAddress(row.getCell(2).getStringCellValue());
			tempEntry.setPlace(row.getCell(3).getStringCellValue());
			tempEntry.setNameOfWifi(row.getCell(4).getStringCellValue());
			tempEntry.setArea(row.getCell(5).getStringCellValue());
			tempEntry.setStatus(row.getCell(6).getStringCellValue());
			switch (row.getCell(7).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setLongitude(Double.parseDouble((row.getCell(7).getStringCellValue())));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setLongitude(row.getCell(7).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setLongitude(row.getCell(7).getNumericCellValue());
				break;
			default:
				break;
			}
			switch (row.getCell(8).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setLatitude(Double.parseDouble((row.getCell(8).getStringCellValue())));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setLatitude(row.getCell(8).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setLatitude(row.getCell(8).getNumericCellValue());
				break;
			default:
				break;
			}
			tempEntry.setNote(row.getCell(9).getStringCellValue());

		}
		wb.close();
		return (Wifi[]) listOfWifi.toArray();
		
	}
}