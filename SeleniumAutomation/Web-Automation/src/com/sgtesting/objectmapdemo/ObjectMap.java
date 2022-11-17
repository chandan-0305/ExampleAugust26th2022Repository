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
		//	System.out.println(locatordetails);
			String locator[]=locatordetails.split(";");
			switch(locator[0].toLowerCase())
			{
			case "id":
				by=By.id(locator[1]);
				break;
			case "name":
				by=By.name(locator[1]);
				break;
			case "classname":
				by=By.className(locator[1]);
				break;
			case "xpath":
				by=By.xpath(locator[1]);
				break;
			case "cssselector":
				by=By.cssSelector(locator[1]);
				break;
			case "linktext":
				by=By.linkText(locator[1]);
				break;
			case "partiallinktext":
				by=By.partialLinkText(locator[1]);
				break;
			case "tagname":
				by=By.tagName(locator[1]);
				break;
			default:
				System.out.println("Invalid Locator Name!!!!");
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		return by;
	}

}
