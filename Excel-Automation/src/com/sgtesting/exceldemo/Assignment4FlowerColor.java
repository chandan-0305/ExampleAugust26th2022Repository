/* Write 20 Flower names and 20 Color names in sheet 1 in 1st and 2nd Column */
package com.sgtesting.exceldemo;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Assignment4FlowerColor {
	public static void main(String [] args)
	{
		writeContent();
		
	}
	private static void writeContent()
	{
		FileOutputStream fout = null;
		Workbook wb = null;
		Sheet sh = null;
		Row row=null;
		Cell cell= null;
		
		String[] flowerr = {"Rose","Jasmine","Lavender","Lily","Sunflower","Lotus" ,"Chrysanthemum"
				,"Narcissus","Daisy","Marigold", "Dahlia","Tulip","Hibiscus ","Arabian Jasmine",
				"Iris","Orchid","Primrose","Lilac","Magnolia","Pansy"};
		
		String[] color = {"Voilet","Indigo","Blue","Green","Red","Yellow" ,"Orange"
				,"White","Black","Brown", "Azure","Pink","Purple ","Ivory",
				"Silver","Navy Blue","Pea Green","Grey","Maroon","Charcol"};
		try
		{
			wb=new XSSFWorkbook();
			sh=wb.createSheet("Flower & City");
			
			for(int i=0;i<flowerr.length;i++)
			{
				row = sh.createRow(i);
				cell = row.createCell(0);
				cell.setCellValue(flowerr[i]);
				cell = row.createCell(1);
				cell.setCellValue(color[i]);
			}
			// Second column color names
			for(int j=0;j<color.length;j++)
			{
				//row = sh.createRow(j);
				
				
			}
			
			fout=new FileOutputStream("E:\\EXCEL\\FlowerColour.xlsx");
			wb.write(fout);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fout.close();
				wb.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
	}

}
