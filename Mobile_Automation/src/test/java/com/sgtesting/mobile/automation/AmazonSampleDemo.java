package com.sgtesting.mobile.automation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class AmazonSampleDemo {
	@Test
	public void desiredCapabilities() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion","11");
		capability.setCapability("deviceName", "INGIINGAS4PFNFLV");
		capability.setCapability("appPackage","in.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		
		AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				capability);
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\'Select English\']").click();
		driver.findElementById("in.amazon.mShop.android.shopping:id/continue_button").click();
		Thread.sleep(4000);		
		driver.findElementById("in.amazon.mShop.android.shopping:id/skip_sign_in_button").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//android.view.View[@content-desc='Mobiles Mobiles']/android.view.View").click();
		Thread.sleep(5000);
		driver.findElementById("in.amazon.mShop.android.shopping:id/chrome_search_hint_view").sendKeys("iPhone 14");
		
	}

}
