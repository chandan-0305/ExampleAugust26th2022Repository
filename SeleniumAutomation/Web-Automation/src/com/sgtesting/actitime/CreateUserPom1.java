//1. launchBrowser --> navigate --> Login --> CreateUser --> DeleteUser --> Logout--> CloseApplication

package com.sgtesting.actitime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateUserPom1 {
	public static WebDriver oBrowser=null;
	public static ActiTimePage oPage=null;
	public static void main(String[] args) {
		launchBrowser();
		navigate();
		login();
		minimizeFlyOutWindow();
		createUser();
		logout();
		closeApplication();
	}

	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver","E:\\ECLIPSETOOL\\ExampleAutomation\\SeleniumAutomation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser = new ChromeDriver();
			oPage=new ActiTimePage(oBrowser);
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	private static void navigate()
	{
		try
		{
			oBrowser.navigate().to("http://localhost/login.do");
			Thread.sleep(3000);
			oBrowser.manage().window().maximize();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	private static void login()
	{
		try
		{
			oPage.getUserName().sendKeys("admin");
			oPage.getPassword().sendKeys("manager");
			oPage.getLogin().click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static void minimizeFlyOutWindow()
	{
		try
		{
			oPage.getFlyOutWindow().click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void createUser()
	{
		try
		{
			oPage.getUserButtons().click();
			oPage.getAddingUserButton().click();
			Thread.sleep(2000);
			oPage.getfirstname().sendKeys("demo");
			oPage.getmiddleName().sendKeys("A");
			oPage.getlastName().sendKeys("Useri");
			oPage.getemail().sendKeys("demo@gmail.com");
			oPage.getusername1().sendKeys("DemoUser1");
			oPage.getPassword().sendKeys("Welcome@123");
			oPage.getpasswordCopy().sendKeys("Welcome@123");
			Thread.sleep(2000);
			oPage.getcreateUserButton().click();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static void logout()
	{
		try
		{
			oPage.getLogoutLink().click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}




	private static void closeApplication()
	{
		try
		{
			oBrowser.quit();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
