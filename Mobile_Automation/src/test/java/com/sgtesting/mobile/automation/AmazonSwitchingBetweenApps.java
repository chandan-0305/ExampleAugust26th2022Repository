package com.sgtesting.mobile.automation;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AmazonSwitchingBetweenApps {
	AppiumDriver<MobileElement> driver;

	@BeforeTest

	public void desiredCapabilities() throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
	//	File file = new File("C:\\Users\\User\\Downloads\\AmazonNew.apk");
		capability.setCapability("platformName", "Android");
		capability.setCapability("platformVersion", "11");
		capability.setCapability("deviceName", "INGIINGAS4PFNFLV");
		capability.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capability.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
	//	capability.setCapability("app", file.getAbsolutePath());
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capability);
		Thread.sleep(15000);
	}

	@Test
	public void simpleLoginTest() throws InterruptedException {
        
		Thread.sleep(20000);
		driver.findElementByXPath("//*[@content-desc='Select English']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='Continue in English']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//*[@text='Skip sign in']").click();
		Thread.sleep(4000);
		this.switchApp("com.android.contacts", "com.android.mms.ui.SearchActivity");
        Thread.sleep(5000);
	}

	/*@AfterTest
	public void quitDriver() {
		driver.quit();
	}*/

	public void switchApp(String packageName, String appActivityNmae) {
		Activity activity = new Activity(packageName, appActivityNmae);
		activity.setStopApp(false);
		((AndroidDriver<MobileElement>) driver).startActivity(activity);
	}


}
