package com.sgtesting.mobile.automation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
public class iosDemo1 {

	@Test
	public void desiredCapabalities() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabality = new DesiredCapabilities();
		File file = new File("/Users/gbyrappa/Documents/IntegrationApp.app");
		capabality.setCapability("platformName", "iOS");
		capabality.setCapability("platformVersion", "12.2");
		capabality.setCapability("deviceName", "iPhone XR");
		capabality.setCapability("automationName", "XCUITest");
		capabality.setCapability("bundleId", "com.facebook.wda.integrationApp");
		capabality.setCapability("app", file.getAbsolutePath());
		AppiumDriver<MobileElement> driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				capabality);
		Thread.sleep(5000);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Alerts\"]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Create App Alert\"]").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Will do\"]").click();

	}

}
