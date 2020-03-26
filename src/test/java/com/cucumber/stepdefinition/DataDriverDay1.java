package com.cucumber.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriverDay1 {

	public static void updateData(int rowNum, int cellNum, String value) throws Exception {

		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheet("ABC");
		Row row = sheetAt.getRow(rowNum);
		if (row == null) {
			System.out.println("Row Created");
			row = sheetAt.createRow(rowNum);
		}
		Cell cell = row.getCell(cellNum);
		if (cell == null) {
			System.out.println("Cell Created");
			cell = row.createCell(cellNum);
		}
		cell.setCellValue(value);
		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
		wb.close();
	}

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 100; i++) {
			LocalDateTime now = LocalDateTime.now();

			updateData(i, 0, String.valueOf(now));

		}
	}

	public static void readData() throws Exception {

		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(1);
		int noofRows = sheetAt.getPhysicalNumberOfRows();
		String value = null; // to get the whole cell values
		for (int i = 0; i < noofRows; i++) {
			Row row = sheetAt.getRow(i);
			if (row == null) {
				row = sheetAt.createRow(i);
			}
			int noofCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j < noofCells; j++) {
				Cell cell = row.getCell(j);
				if (cell == null) {
					cell = row.createCell(j);
					cell.setCellValue("Blank cell");
					
				}
				CellType cellType = cell.getCellType();

				if (cellType.equals(CellType.STRING))

					value = cell.getStringCellValue();
				else if (cellType.equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					value = String.valueOf(l);
				}
				System.out.println(value);
			}

		}
		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
		wb.close();
	}

	private static void printSingleColumn(int colNum) throws Exception {
		System.out.println("Printing particular column-------------------------------");
		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(1);
		int noofRows = sheetAt.getPhysicalNumberOfRows();
		for (int i = 0; i < noofRows; i++) {
			Row row = sheetAt.getRow(i);
			int noofCells = row.getPhysicalNumberOfCells();

			Cell cell = row.getCell(colNum);
			CellType cellType = cell.getCellType();
			String value = null;
			if (cellType.equals(cellType.STRING))

				value = cell.getStringCellValue();
			else if (cellType.equals(cellType.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}

			System.out.println(value);
		}

	}

	public static String showParticularCellValue(int rowNum, int colNum) throws Exception {
		System.out.println("Printing particular cell value-------------------------" + "\n");
		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(1);
		int noofRows = sheetAt.getPhysicalNumberOfRows();
		// to get the particular cell value
		Row row = sheetAt.getRow(rowNum);
		Cell cell = row.getCell(colNum);
		CellType cellType = cell.getCellType();
		String value = null;
		if (cellType.equals(cellType.STRING))

			value = cell.getStringCellValue();
		else if (cellType.equals(cellType.NUMERIC)) {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}

		return value;

	}

	public static void printSingleRow() throws Exception {
		System.out.println("Printing particular row------------------------" + "\n");

		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(1);
		int noofRows = sheetAt.getPhysicalNumberOfRows();
		// to get the particular row
		Row row = sheetAt.getRow(5);
		int noofCells = row.getPhysicalNumberOfCells();
		String value = null;
		for (int j = 0; j < noofCells; j++) {
			Cell cell = row.getCell(j);
			CellType type = cell.getCellType();
			if (type.equals(type.STRING))
				value = cell.getStringCellValue();
			else if (type.equals(type.NUMERIC)) {
				double numericCellValue = cell.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);
			}
			System.out.println(value);
		}

	}

}
