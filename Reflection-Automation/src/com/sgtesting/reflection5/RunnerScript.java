/* Sheet1 = CreateCustomer
 * Sheet2 = CreateUserScenario
 * Sheet3 = CreateProject
 * Sheet4 = CustomerModify
 * Sheet5 = ModifyProject
 * Sheet6 = ModifyUserScenario
 * Sheet7 = CreateMultipleUser
 */
package com.sgtesting.reflection5;

import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RunnerScript {
	public static void main(String[] args) {
		executeMethods();

	}
	
	private static void executeMethods()
	{
		FileInputStream fin=null;
		Workbook wb=null;
		Sheet sh=null;
		Row row=null;
		Cell cell=null;
		try
		{
			fin=new FileInputStream(".\\DataFiles\\MethodNames.xlsx");
			wb=new XSSFWorkbook(fin);
			sh=wb.getSheet("Sheet3");
			int rc=sh.getPhysicalNumberOfRows();
			for(int r=1;r<rc;r++)
			{
				row=sh.getRow(r);
				cell=row.getCell(0);
				String methodname=cell.getStringCellValue();
				cell=row.getCell(1);
				String pkgclassname=cell.getStringCellValue();
				System.out.println(methodname+ " --->"+pkgclassname);
				
				Class clsObject=Class.forName(pkgclassname);
				Object obj=clsObject.getConstructor().newInstance();
				
				Method method=obj.getClass().getMethod(methodname, null);
				method.invoke(obj, null);
			} 
	/*	try
		{
			fin=new FileInputStream(".\\DataFiles\\MethodNames.xlsx");
			wb=new XSSFWorkbook(fin);
			for(int i=1;i<7;i++)
			{
			sh=wb.getSheet("Sheet"+i);
			int rc=sh.getPhysicalNumberOfRows();
			for(int r=1;r<rc;r++)
			{
				row=sh.getRow(r);
				cell=row.getCell(0);
				String methodname=cell.getStringCellValue();
				cell=row.getCell(1);
				String pkgclassname=cell.getStringCellValue();
				System.out.println(methodname+ " --->"+pkgclassname);
				
				Class clsObject=Class.forName(pkgclassname);
				Object obj=clsObject.getConstructor().newInstance();
				
				Method method=obj.getClass().getMethod(methodname, null);
				method.invoke(obj, null);
			 }
			}*/
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fin.close();
				wb.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


}
