package com.sgtesting.actitime.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinitions {
	public static WebDriver oBrowser=null;
	/**
	 * I launch the chrome Browser
	 */
	@Given("^I launch the chrome Browser$")
	public void I_launch_the_chrome_Browser()
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
	
	/**
	 * I navigate the application url
	 */
	@And("^I navigate the application url$")
	public void I_navigate_the_application_url()
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
	 *  I enter username in username text field
	 */
	@When("^I enter username in username text field$")
	public void I_enter_username_in_username_text_field()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I enter password in password text field
	 */
	@And("^I enter password in password text field$")
	public void I_enter_password_in_password_text_field()
	{
		try
		{
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			Thread.sleep(1000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	

	/**
	 *  I click on Login button
	 */
	@And("^I click on Login button$")
	public void I_click_on_Login_button()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I find the home page
	 */
	@Then("^I find the home page$")
	public void I_find_the_home_page()
	{
		try
		{
			WebElement oEle=oBrowser.findElement(By.xpath("//td[text()='Enter Time-Track']"));
			Assert.assertTrue(oEle.isDisplayed());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I minimize the flyout window
	 */
	@And("^I minimize the flyout window$")
	public void I_minimize_the_flyout_window()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I click on create User
	 */
	@And("^I click on create User$")
	public void I_click_on_create_User()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I enter the user details
	 */
	@Then("^I enter the user details")
	public void I_enter_the_user_details()
	{
		try
		{
			oBrowser.findElement(By.name("firstName")).sendKeys("demo");
			oBrowser.findElement(By.name("middleName")).sendKeys("A");
			oBrowser.findElement(By.name("lastName")).sendKeys("User1");
			oBrowser.findElement(By.name("email")).sendKeys("demo@gmail.com");
			oBrowser.findElement(By.name("username")).sendKeys("demoUser1");
			oBrowser.findElement(By.name("password")).sendKeys("Welcome123");
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("Welcome123");
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I click on create user button
	 */
	@And("^I click on create user button$")
	public void I_click_on_create_user_button()
	{
		try
		{
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I click on User 
	 */
	@And("^I click on User$")
	public void I_click_on_User()
	{
		try
		{   Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id='userListTableContainer']/table/tbody/tr[2]/td[1]/table/tbody/tr/td/div[1]/span[2]")).click();
			
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I click on delete User 
	 */
	@And("^I click on delete User$")
	public void I_click_on_delete_User()
	{
		try
		{
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(2000);
			Alert oAlert=oBrowser.switchTo().alert();
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I click on Logout link
	 */
	@When("^I click on Logout link$")
	public void I_click_on_Logout_link()
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
	
	/**
	 *  I find the login page
	 */
	@Then("^I find the login page$")
	public void I_find_the_login_page()
	{
		String expected,actual;
		try
		{
			expected="actiTIME - Login";
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I close the application
	 */
	@And("^I close the application$")
	public void I_close_the_application()
	{
		try
		{
			oBrowser.close();
			Thread.sleep(2000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
