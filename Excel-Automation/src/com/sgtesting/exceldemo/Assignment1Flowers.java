/*Write a 20 flower names into 1st sheet 1st column of an Excel File */

package com.sgtesting.exceldemo;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment1Flowers {

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
			sh=wb.createSheet("Flower Names");			
			String[] flowerr = {"Rose","Jasmine","Lavender","Lily","Sunflower","Lotus" ,"Chrysanthemum"
					,"Narcissus","Daisy","Marigold", "Dahlia","Tulip","Hibiscus ","Arabian Jasmine",
					"Iris","Orchid","Primrose","Lilac","Magnolia","Pansy"};
			for (int i=0;i<flowerr.length;i++)
			{
				row=sh.createRow(i);
				cell=row.createCell(0);
				cell.setCellValue(flowerr[i]);
			}
			fout=new FileOutputStream("E:\\EXCEL\\Flowers.xlsx");
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
