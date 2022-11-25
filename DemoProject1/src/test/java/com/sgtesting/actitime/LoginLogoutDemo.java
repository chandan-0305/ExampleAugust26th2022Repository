package com.sgtesting.actitime;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginLogoutDemo {

	public static WebDriver oBrowser=null;
	@Test(priority = 1)
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
	@Test(priority = 2)
	private static void navigate()
	{
		WebElement oEle=null;
		try
		{
			oBrowser.get("http://localhost/login.do");
			Thread.sleep(5000);
			oEle=oBrowser.findElement(By.xpath("//td[text()='Please identify yourself']"));
			Assert.assertTrue(oEle.isDisplayed());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3,dataProvider = "login")
	private static void login(String user,String pwd)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
			String Filename="E:\\Example.png";
			captureScreenshotDemo(oBrowser,Filename);
			WebElement oLink=oBrowser.findElement(By.xpath("//a[contains(text(),'Administrator')]"));
			Assert.assertTrue(oLink.isDisplayed());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 4)
	private static void minimizeFlyOutwindow()
	{
		String expected;
		try
		{
			expected="Getting Started Shortcuts";
			WebElement oEle=oBrowser.findElement(By.xpath("//div[text()='Getting Started Shortcuts']"));
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
			String actual=oEle.getText();
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5)
	private static void logout()
	{
		String expected,actual;
		try
		{
			expected="actiTIME - Login";
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6)
	private static void closeApp()
	{
		try
		{
			oBrowser.quit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@DataProvider(name="login")
	public Object[][] getLoginData()
	{
		return new Object[][] {{"admin","manager"}};
	}
	
	
	private static void captureScreenshotDemo(WebDriver oBrowser ,String destFile)
	{
		try
		{
			TakesScreenshot obj = (TakesScreenshot) oBrowser;
			File srcFile=obj.getScreenshotAs(OutputType.FILE);
			File destFileName = new File(destFile);
			org.apache.commons.io.FileUtils.copyFile(srcFile, destFileName);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
