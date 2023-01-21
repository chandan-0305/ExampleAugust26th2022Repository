package com.sgtesting.mobile.automation;

import java.io.File;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import static java.time.Duration.ofMillis;
import java.net.URL;
import io.appium.java_client.android.AndroidDriver;

public class AmazonScrollDemo {
	AppiumDriver<MobileElement> driver;

	@BeforeTest

	public void desiredCapabilities() throws Exception {
		DesiredCapabilities capability = new DesiredCapabilities();
		//File file = new File("E:\\EXAMPLE\\AmazonNew.apk");
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
		for (int i = 0; i < 10; i++) {
			this.verticalSwipeByPercentages(0.80, 0.40, 0.20);

			System.out.println("Scrolling the page");
		}
	}

/*	@AfterTest
	public void quitDriver() {
		driver.quit();
	}*/

	public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);
		new TouchAction(driver).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(ofMillis(1000))).moveTo(PointOption.point(anchor, endPoint))
				.release().perform();
	}
}

/*
 * public void verticalSwipeByPercentages(double startPercentage, double
 * endPercentage, double anchorPercentage) { Dimension size =
 * driver.manage().window().getSize(); int anchor = (int) (size.width *
 * anchorPercentage); int startPoint = (int) (size.height * startPercentage);
 * int endPoint = (int) (size.height * endPercentage); new
 * TouchAction(driver).press(PointOption.point(anchor, startPoint))
 * .waitAction(WaitOptions.waitOptions(ofMillis(1000))).moveTo(PointOption.point
 * (anchor, endPoint)) .release().perform(); }
 * 
 * 
 * import io.appium.java_client.TouchAction; import
 * io.appium.java_client.touch.WaitOptions; import
 * io.appium.java_client.touch.offset.PointOption; import static
 * java.time.Duration.ofMillis;
 */
