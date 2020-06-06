package com.read;

import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFSheet sh_all;

	// Constructor
	public ExcelRead(String excelName, String sheetName) throws Exception {
		wb =new XSSFWorkbook(excelName);
		sh = wb.getSheet(sheetName);
	}

	// Get row count of sheet
	public void getRowCnt() {

		int cnt = sh.getPhysicalNumberOfRows();
		System.out.println("Row count : "+cnt);
	}

	// Get the data of particular cell
	public void getData(int row, int col) {

		DataFormatter format = new DataFormatter();
		Object value = format.formatCellValue(sh.getRow(row).getCell(col));
		System.out.println("The value in row "+row+" and column "+col+" is : "+value);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String excel = "ExcelData.xlsx";
		String sheet = "test";
		try {
			ExcelRead read = new ExcelRead(excel, sheet);
			read.getRowCnt();
			read.getData(1, 1);
			
			// Iterate to all sheets
			for(int i =0;i<wb.getNumberOfSheets();i++) {
				sh_all = wb.getSheetAt(i);
				System.out.println("Showing data for sheet "+sh_all.getSheetName());

				// Iterate over one sheet and print all the data
				Iterator<Row> rowIt = sh_all.iterator();
				while(rowIt.hasNext()) {
					Row row = rowIt.next();
					Iterator<Cell> cellIt = row.cellIterator();

					while(cellIt.hasNext()) {

						Cell cell = cellIt.next();
						switch(cell.getCellType()) {

						case NUMERIC:
							System.out.print(cell.getNumericCellValue() + "\t");
							break;
						case STRING:
							System.out.print(cell.getStringCellValue() + "\t");
							break;
						default:
							System.out.print(cell.getStringCellValue() + "\t");
							break; 
						}
						System.out.println("");
					}
				}

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}