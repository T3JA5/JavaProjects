package com.write;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			wb = new XSSFWorkbook();
			sh = wb.createSheet("Data"+System.currentTimeMillis());
						
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("1", new Object[] {"ID", "Name", "LastName"});
			data.put("2", new Object[] {"1", "Rahul", "Kumar"});
			data.put("3", new Object[] {"1", "Arun", "Trivedi"});
			
			Set<String> keyset = data.keySet();
	        int rownum = 0;
	        for (String key : keyset)
	        {
	            Row row = sh.createRow(rownum++);
	            Object [] objArr = (Object[]) data.get(key);
	            int cellnum = 0;
	            for (Object obj : objArr)
	            {
	               Cell cell = row.createCell(cellnum++);
	               if(obj instanceof String)
	                    cell.setCellValue((String)obj);
	                else if(obj instanceof Integer)
	                    cell.setCellValue((Integer)obj);
	            }
	        }	        
	        FileOutputStream fos = new FileOutputStream(new File("ExcelData1.xlsx"));
	        wb.write(fos);
	        fos.close();
	        System.out.println("Successful Created excel");
	        
			
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
