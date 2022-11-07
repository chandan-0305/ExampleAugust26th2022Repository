/*Write 20 Colors Names on 1st Sheet 10th Row of an Excel File */
package com.sgtesting.exceldemo;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment2Colours {

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
			sh=wb.createSheet("Colors Names");			
			String[] color = {"Voilet","Indigo","Blue","Green","Red","Yellow" ,"Orange"
					,"White","Black","Brown", "Azure","Pink","Purple ","Ivory",
					"Silver","Navy Blue","Pea Green","Grey","Maroon","Charcol"};
			row=sh.createRow(9);
			for (int i=0;i<color.length;i++)
			{
				
				cell=row.createCell(i);
				cell.setCellValue(color[i]);
			}
			fout=new FileOutputStream("E:\\EXCEL\\Colors.xlsx");
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
