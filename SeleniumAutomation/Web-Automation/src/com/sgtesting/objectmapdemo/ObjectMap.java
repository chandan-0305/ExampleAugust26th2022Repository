package com.sgtesting.objectmapdemo;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	
	public static Properties prop=null;
	public ObjectMap(String filename)
	{
		FileInputStream fin=null;
		try
		{
			fin=new FileInputStream(filename);
			prop=new Properties();
			prop.load(fin);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public By getLocator(String logicalname)
	{
		By by=null;
		try
		{
			String locatordetails=prop.getProperty(logicalname);
			System.out.println(locatordetails);
			String locator[]=locatordetails.split(";");
			for(int i=0;i<locator.length;i++)
			{
				System.out.println(locator[i]);
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return by;
	}

}
