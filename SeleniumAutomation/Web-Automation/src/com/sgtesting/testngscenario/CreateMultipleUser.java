//3. launchBrowser --> navigate --> Login --> Create User1 --> Create User2--> Create User3 --> Logout from admin --> Login as User1 --> logout as user1 --> Login as User2 --> logout as User2 --> Login as User3 --> logout as user3 --> Login as User1 --> Modify Password --> Logout as user1 -->Login as User2 --> Modify Password --> Logout as user2 -->Login as User3 --> Modify Password --> Logout as user3 --> Login as User1 using new pasword --> Logout as User1 -->Login as User2 using new pasword --> Logout as User2 --> Login as User3 using new pasword --> Logout as User3 --> Login as Admin --> Modify Password for 
//User1 , User2, User3 --> Logout as Admin --> Login as User1 using new pasword --> Logout as User1 -->Login as User2 using new pasword --> Logout as User2 --> Login as User3 using new pasword --> Logout as User3 -->Login as Admin --> Delete User1, User2, User3 --> Logout as Admin

package com.sgtesting.testngscenario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateMultipleUser {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		
	}
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
   
	@Test(priority =5,dataProvider="userdata1")	
	private static void User1(String fn,String mn,String ln,String mail,String uname,String pwd,String pwdc)
	{
		WebElement cele= null;
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.name("firstName")).sendKeys(fn);
			oBrowser.findElement(By.name("middleName")).sendKeys(mn);
			oBrowser.findElement(By.name("lastName")).sendKeys(ln);
			oBrowser.findElement(By.name("email")).sendKeys(mail);
			oBrowser.findElement(By.name("username")).sendKeys(uname);
			oBrowser.findElement(By.name("password")).sendKeys(pwd);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(pwdc);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(5000);
			cele = oBrowser.findElement(By.xpath("//span[text()='3 accounts left']"));
			Assert.assertTrue(cele.isDisplayed());
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	@Test(priority =6,dataProvider="userdata2")	
	private static void User2(String fn,String mn,String ln,String mail,String uname,String pwd,String pwdc)
	{
		
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(3000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(4000);
			oBrowser.findElement(By.name("firstName")).sendKeys(fn);
			oBrowser.findElement(By.name("middleName")).sendKeys(mn);
			oBrowser.findElement(By.name("lastName")).sendKeys(ln);
			oBrowser.findElement(By.name("email")).sendKeys(mail);
			oBrowser.findElement(By.name("username")).sendKeys(uname);
			oBrowser.findElement(By.name("password")).sendKeys(pwd);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys(pwdc);
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(3000);
			
			
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void User3()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("firstName")).sendKeys("demo");
			oBrowser.findElement(By.name("middleName")).sendKeys("s");
			oBrowser.findElement(By.name("lastName")).sendKeys("niki");
			oBrowser.findElement(By.name("email")).sendKeys("niki@gmail.com");
			oBrowser.findElement(By.name("username")).sendKeys("Demouser3");
			oBrowser.findElement(By.name("password")).sendKeys("121212");
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("121212");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
			Thread.sleep(2000);
			
			
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Logout()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void LoginUser1()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser1");
			oBrowser.findElement(By.name("pwd")).sendKeys("12345a");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Start exploring actiTIME']")).click();

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Logoutuser1()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void LoginUser2()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser2");
			oBrowser.findElement(By.name("pwd")).sendKeys("123321");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Start exploring actiTIME']")).click();

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Logoutuser2()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void LoginUser3()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser3");
			oBrowser.findElement(By.name("pwd")).sendKeys("121212");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Start exploring actiTIME']")).click();

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Logoutuser3()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void SecontimeLoginUser1()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser1");
			oBrowser.findElement(By.name("pwd")).sendKeys("12345a");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Modifyuser1()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='vin, demo v.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("vini");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("vini");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void SecondtimeLogoutuser1()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void SecondtimeLoginUser2()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser2");
			oBrowser.findElement(By.name("pwd")).sendKeys("123321");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Modifyuser2()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='sam, demo s.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("sam");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("sam");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void SecondtimeLogoutuser2()
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
	public static void SecondtimeLoginUser3()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser3");
			oBrowser.findElement(By.name("pwd")).sendKeys("121212");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Modifyuser3()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='niki, demo s.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("niki");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("niki");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void SecondtimeLogoutuser3()
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
	public static void SecondtimeadminLogin()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void AdminModifyuser1()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='vin, demo v.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("vinayak");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("vinayak");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='sam, demo s.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("sami");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("sami");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='niki, demo s.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.name("password")).sendKeys("nikki");
			Thread.sleep(1000);
			oBrowser.findElement(By.name("passwordCopy")).sendKeys("nikki");
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='Save Changes']")).click();
			Thread.sleep(2000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void SecondtimeAdminlogout()
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
	public static void ThirdtimeLoginUser1()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser1");
			oBrowser.findElement(By.name("pwd")).sendKeys("vinayak");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Thirdtimeuser1logout()
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
	public static void ThirdtimeLoginUser2()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser2");
			oBrowser.findElement(By.name("pwd")).sendKeys("sami");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			
		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Thirdtimeuser2logout()
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
	public static void ThirdtimeLoginUser3()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("Demouser3");
			oBrowser.findElement(By.name("pwd")).sendKeys("nikki");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);
			

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void Thirdtimeuser3logout()
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
	public static void thirdtimeadminLogin()
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys("admin");
			oBrowser.findElement(By.name("pwd")).sendKeys("manager");
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(1000);

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void DeleteUesers()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='vin, demo v.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(1000);
			Alert oAlert=oBrowser.switchTo().alert();
			String content=oAlert.getText();
			System.out.println(content);
			oAlert.accept();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='sam, demo s.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(1000);
			oAlert.accept();
			oBrowser.findElement(By.xpath("//*[@id='topnav']/tbody/tr[1]/td[5]/a/div[2]")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.xpath("//span[text()='niki, demo s.']")).click();
			Thread.sleep(1000);
			oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
			Thread.sleep(1000);
			oAlert.accept();

		}catch(Exception e)

		{
			e.printStackTrace();
		}
	}
	public static void ThirdtimeAdminlogout()
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
	public static void CloseBrowser()
	{
		try
		{
			oBrowser.close();
			Thread.sleep(3000);


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
	
	@DataProvider(name="userdata1")
	public Object[] getuserData1()
	{
		return new Object[][] {{"demo","A","User1","demo@gmail.com","demoUser1","Welcome123","Welcome123"}};
	}
	@DataProvider(name="userdata2")
	public Object[] getuserData2()
	{
		return new Object[][] {{"demo","s","sam","sam@gmail.com","Demouser2","123321","123321"}};
	}

}
