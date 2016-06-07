package webtechnologies.openData;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class ParseOpenData {
	public static Wifi[] Parse() throws IOException {
		InputStream input = new URL("http://localhost:8888/wifi.xlsx").openStream();
		XSSFWorkbook wb = new XSSFWorkbook(input);
		Sheet sheet = wb.getSheetAt(0);
		List<Wifi> wifiArray = new ArrayList<Wifi>();
		int i;
		for (i=1;i<sheet.getLastRowNum()+1;i++) {
			Wifi tempEntry = new Wifi();
			switch (sheet.getRow(i).getCell(0).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setIndex(Integer.parseInt(sheet.getRow(i).getCell(0).getStringCellValue()));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setIndex((int) sheet.getRow(i).getCell(0).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setIndex((int) sheet.getRow(i).getCell(0).getNumericCellValue());
				break;
			default:
				break;
			}
			tempEntry.setName(sheet.getRow(i).getCell(1).getStringCellValue());
			tempEntry.setAddress(sheet.getRow(i).getCell(2).getStringCellValue());
			tempEntry.setPlace(sheet.getRow(i).getCell(3).getStringCellValue());
			tempEntry.setNameOfWifi(sheet.getRow(i).getCell(4).getStringCellValue());
			switch (sheet.getRow(i).getCell(5).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setRadius(Integer.parseInt((sheet.getRow(i).getCell(5).getStringCellValue())));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setRadius((int) sheet.getRow(i).getCell(5).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setRadius((int) sheet.getRow(i).getCell(5).getNumericCellValue());
				break;
			default:
				break;
			}
			tempEntry.setStatus(sheet.getRow(i).getCell(6).getStringCellValue());

			switch (sheet.getRow(i).getCell(7).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setLatitude(Double.parseDouble((sheet.getRow(i).getCell(7).getStringCellValue())));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setLatitude(sheet.getRow(i).getCell(7).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setLatitude(sheet.getRow(i).getCell(7).getNumericCellValue());
				break;
			default:
				break;
			}
			switch (sheet.getRow(i).getCell(8).getCellType()) {
			case Cell.CELL_TYPE_STRING:
				tempEntry.setLongitude(Double.parseDouble((sheet.getRow(i).getCell(8).getStringCellValue())));
				break;
			case Cell.CELL_TYPE_NUMERIC:
				tempEntry.setLongitude(sheet.getRow(i).getCell(8).getNumericCellValue());
				break;

			case Cell.CELL_TYPE_FORMULA:
				tempEntry.setLongitude(sheet.getRow(i).getCell(8).getNumericCellValue());
				break;
			default:
				break;
			}
			tempEntry.setNote(sheet.getRow(i).getCell(9).getStringCellValue());
			wifiArray.add(tempEntry);

		}
		
		wb.close();
		input.close();
		return wifiArray.toArray(new Wifi[wifiArray.size()]);
		
	}
}