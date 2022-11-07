/*Write 20 State Names on 1st Sheet diagonally in Excel File */
package com.sgtesting.exceldemo;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment5States {
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
			sh=wb.createSheet("States Names");			
			String[] states = {"Karnataka","Kerala","Tamilnadu","Andhra Pradesh","Telangana","Goa" ,"Maharashtra"
					,"Chattisgar","Orissa","Madhya Pradesh", "Uttarkhand","Assam","Bihar ","Uttar Pradesh",
					"Delhi","Mizoram","Nagaland","Manipur","Arunachal Pradesh","Punjab"};
			for (int i=0;i<states.length;i++)
			{
				row=sh.createRow(i);
				cell=row.createCell(i);
				cell.setCellValue(states[i]);
			}
			fout=new FileOutputStream("E:\\EXCEL\\States.xlsx");
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
