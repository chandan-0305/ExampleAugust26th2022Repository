/*Write 20 City Names on 1st Sheet 5th Column of an Excel File */
package com.sgtesting.exceldemo;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment3CityNames {
	
	public static void main(String[] args) {
		writeContent();

	}
	private static void writeContent()
	{
		FileOutputStream fout=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		
		
		try
		{
			wb=new XSSFWorkbook();
			sh=wb.createSheet("City Names");			
			String[] city = {"Bangalore","Mumbai","Chennai","Hyderabad","Cochin","Kolkata" ,"Hubli"
					,"Dharwad","Delhi","Noida", "SriNagar","Trivandrum","Kanyakumari ","Bhopal",
					"Pune","Belgaum","Tumkur","Hassan","Mysore","Dhavanagere"};
			
			for (int i=0;i<city.length;i++)
			{
				row=sh.createRow(i);
				cell=row.createCell(4);
				cell.setCellValue(city[i]);
			}
			fout=new FileOutputStream("E:\\EXCEL\\CityNames.xlsx");
			wb.write(fout);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fout.close();
				wb.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}

}
