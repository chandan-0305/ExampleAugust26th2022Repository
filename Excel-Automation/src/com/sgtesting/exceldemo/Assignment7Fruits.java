/*In First Sheet 10th Column it has 20 Fruit names Read the Content,
  and Write it into a sheet2 10th row*/
package com.sgtesting.exceldemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment7Fruits {
	static String fruits[] = new String[20];
	public static void main(String[] args) {
		readContent();
		writeContent();

	}
	private static void readContent()
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			fin=new FileInputStream("E:\\EXCEL\\Fruits.xlsx");
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet("Fruits");
			int k=-1;
			for(int r=0;r<20;r++)
			{
				k=k+1;
				row=sh.getRow(r);
					cell=row.getCell(9);
					String data=cell.getStringCellValue();
					fruits[k]=data;	
				
				
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}


	private static void writeContent()
	{
		FileOutputStream fout=null;
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			fin=new FileInputStream("E:\\EXCEL\\Fruits.xlsx");
			wb=new XSSFWorkbook(fin);
			sh=wb.createSheet("Fruits Names");
			row=sh.createRow(9);
			for (int i=0;i<fruits.length;i++)
			{
				cell=row.createCell(i);
				cell.setCellValue(fruits[i]);
			}
			fout=new FileOutputStream("E:\\EXCEL\\Fruits.xlsx");
			wb.write(fout);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
				fout.close();
			}catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	

}
