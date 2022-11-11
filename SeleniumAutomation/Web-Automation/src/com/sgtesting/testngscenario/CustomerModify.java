//5. launchBrowser --> navigate --> Login --> Create Customer -->Modify Customer --> delete Customer --> Logout --> CloseApplication
package com.sgtesting.testngscenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CustomerModify {
	public static WebDriver oBrowser=null;
	@Test(priority = 1)
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "E:\\ECLIPSETOOL\\ExampleAutomation\\SeleniumAutomation\\Web-Automation\\Library\\drivers\\chromedriver.exe");
			oBrowser=new ChromeDriver();
			oBrowser.manage().window().maximize();
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
    
	@Test(priority = 3, dataProvider = "login")
	private static void login(String user,String pwd)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(user);
			oBrowser.findElement(By.name("pwd")).sendKeys(pwd);
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
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
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(4000);
			WebElement oLink=oBrowser.findElement(By.xpath("//a[contains(text(),'Administrator')]"));
			Assert.assertTrue(oLink.isDisplayed());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
   
	@Test(priority = 5 , dataProvider="createuser")
	private static void createCustomer(String cname,String cdetails)
	{
		

		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'topnav\']/tbody/tr/td[3]/a/div[2]")).click();
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[1]/div[2]/div/div[2]")).click();
			oBrowser.findElement(By.xpath("/html/body/div[14]/div[1]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.id("customerLightBox_nameField")).sendKeys(cname);
			oBrowser.findElement(By.id("customerLightBox_descriptionField")).sendKeys(cdetails);
			oBrowser.findElement(By.xpath("//*[@id=\'customerLightBox_commitBtn\']/div/span")).click();
			Thread.sleep(3000);	
			WebElement iLink=oBrowser.findElement(By.xpath("//a[text()='All Customers']"));
			Assert.assertTrue(iLink.isDisplayed());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6 , dataProvider="modifycus")
	private static void modifyCustomer(String modc)
	{
		try
		{
			oBrowser.findElement(By.xpath("//div[text()=\'Wonderla\']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//div[text()=\'Wonderla\']")).clear();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//div[text()=\'Wonderla\']")).sendKeys(modc);
			Thread.sleep(2000);
			WebElement mcLink=oBrowser.findElement(By.xpath("///div[text()=\'Wonderla1\']"));
			Assert.assertTrue(mcLink.isDisplayed());
					
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority = 7)
	private static void deleteCustomer()
	{

		try
		{
			oBrowser.findElement(By.xpath("//*[@id=\'cpTreeBlock\']/div[2]/div[2]/div/div[2]/div/div[1]/div[2]/div[2]/div[4]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.className("actionButton")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id=\'taskListBlock\']/div[2]/div[4]/div/div[3]/div")).click();	
			Thread.sleep(1000);
			oBrowser.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@Test(priority = 8)
	private static void logout()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
    
	@Test(priority = 9)
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
	
	@DataProvider(name="createuser")
	public Object[] getcreateuser()
	{
		return new Object[][] {{"Wonderla","Amusment park Ticketing Software"}};
	}
	@DataProvider(name="modifycus")
	public Object[] getmodifycus()
	{
		return new Object[][] {{"Wonderla1"}};
	}
	

}
