/*Amazon Home Page-> click on Mobiles ---> Add a Mobile To cart*/
package com.sgtesting.mobile.automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Assignment1 {
	AppiumDriver<MobileElement> driver ;
	
	@BeforeTest
	public void desiredCapabilitiies () throws Exception  {
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "11");
		capability.setCapability("deviceName", "INGIINGAS4PFNFLV");
		capability.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		Thread.sleep(15000);
	}
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		Thread.sleep(20000);
		driver.findElementByXPath("//*[@content-desc='Select English']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='Continue in English']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='Skip sign in']").click();
		Thread.sleep(5000);
		
		
	}
	

}
