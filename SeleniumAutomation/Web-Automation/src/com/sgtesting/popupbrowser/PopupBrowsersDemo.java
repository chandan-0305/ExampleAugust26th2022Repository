package com.sgtesting.popupbrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopupBrowsersDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		handlePopUps();
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
	
	private static void handlePopUps()
	{
		try
		{
			System.out.println("Before Click on Link, Numbers of Popups :"+getPopupCount());
			Thread.sleep(2000);
			oBrowser.findElement(By.linkText("actiTIME Inc.")).click();
			Thread.sleep(4000);
			System.out.println("After Click on Link, Numbers of Popups :"+getPopupCount());
			if(getPopupCount()>0)
			{
				popupBrowsers();
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static int getPopupCount()
	{
		int count=0;
		try
		{
			count=oBrowser.getWindowHandles().size()-1;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}
	
	private static void popupBrowsers()
	{
		try
		{
			String parentBrowser;
			parentBrowser=oBrowser.getWindowHandle();
			System.out.println("Parent Browser :"+parentBrowser);
			Object popups[]=oBrowser.getWindowHandles().toArray();
			for(int i=1;i<popups.length;i++)
			{
				String childBrowser=popups[i].toString();
				System.out.println("Child Browser :"+childBrowser);
				oBrowser.switchTo().window(childBrowser);
				Thread.sleep(2000);
				oBrowser.findElement(By.linkText("Try Free")).click();
				Thread.sleep(2000);
				//Again Switch back to Parent Browser
				oBrowser.switchTo().defaultContent();
				oBrowser.switchTo().window(parentBrowser);
				oBrowser.findElement(By.linkText("actiTIME Inc.")).click();
				Thread.sleep(4000);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
