/* There is an Excel File , sheet1 it has 20 Country names */
 /*Read the Content and Write into a sheet2 First Column*/

package com.sgtesting.exceldemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment6WriteSheet2 {
      static String country[] = new String[20];
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
			fin=new FileInputStream("E:\\EXCEL\\Country.xlsx");
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet("Country");
			int rc=sh.getPhysicalNumberOfRows();
			int k=-1;
			for(int r=0;r<rc;r++)
			{
				k=k+1;
				row=sh.getRow(r);
				int cc=row.getPhysicalNumberOfCells();
				for(int c=0;c<cc;c++)
				{
					
					cell=row.getCell(c);
					String data=cell.getStringCellValue();
					country[k]=data;	
				}
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
			fin=new FileInputStream("E:\\EXCEL\\Country.xlsx");
			wb=new XSSFWorkbook(fin);
			sh=wb.createSheet("Country Names");

			for (int i=0;i<country.length;i++)
			{
				row=sh.createRow(i);
				cell=row.createCell(0);
				cell.setCellValue(country[i]);
			}
			fout=new FileOutputStream("E:\\EXCEL\\Country.xlsx");
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
