package com.sgtesting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class FirefoxProfilesDemo {
	public static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		
	}
	
	private static void launchBrowser()
	{
		try
		{
		/*	ProfilesIni profilesini=new ProfilesIni();
			FirefoxProfile ffprofile=profilesini.getProfile("sgtesting");
			FirefoxOptions options=new FirefoxOptions(); //http://sgtestinginstitute.com/
			options.setProfile(ffprofile); */
		
			FirefoxProfile ffprofile=new FirefoxProfile();
			ffprofile.setPreference("browser.startup.homepage", "http://localhost/login.do");
			FirefoxOptions options=new FirefoxOptions();
			options.setProfile(ffprofile); 
			System.setProperty("webdriver.gecko.driver", "E:\\GitRepository\\CurrentWorkspace\\ExampleAugust26th2022Repository\\SeleniumAutomation\\Web-Automation\\Library\\drivers\\geckodriver.exe");
			oBrowser=new FirefoxDriver(options);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
