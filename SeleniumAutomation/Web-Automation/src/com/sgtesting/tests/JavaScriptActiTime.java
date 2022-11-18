package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptActiTime {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		displayURL();
		displayTitle();
		displayLinksCount();
		login();
		
	}
	private static void launchBrowser()
	{
		try
		{
			String path=System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", path+"\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void navigate()
	{
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the URL of the Web Page
	 */
	private static void displayURL()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		String url=(String) js.executeScript("var kk=document.URL;return kk;");
		System.out.println("URL :"+url);
	}
	/**
	 * Get the Title of the Web Page
	 */
	private static void displayTitle()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		String title=(String) js.executeScript("var kk=document.title;return kk;");
		System.out.println("Title :"+title);
	}
	
	/**
	 * Get the Number of Links in the Web Page
	 */
	private static void displayLinksCount()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		long linkscount=(long) js.executeScript("var kk=document.getElementsByTagName('A');return kk.length;");
		System.out.println("# of Links :"+linkscount);
	}
	
	private static void login()
	{
		WebElement oEle=oBrowser.findElement(By.xpath("//*[@id=\'username\']"));
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById(username).value=admin;");
			
	}
}
