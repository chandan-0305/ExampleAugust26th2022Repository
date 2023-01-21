package com.sgtesting.mobile.automation;

import static java.time.Duration.ofMillis;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class iosScrollDemo {

	public AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void desiredCapabalities() throws MalformedURLException {
        DesiredCapabilities capabalities = new DesiredCapabilities();
        File file = new File("/Users/gbyrappa/Documents/IntegrationApp.app");
        capabalities.setCapability("platformName", "iOS");
        capabalities.setCapability("platformVersion", "12.2");
        capabalities.setCapability("automationName", "XCUITest");
        capabalities.setCapability("deviceName", "iPhone XR");
        capabalities.setCapability("bundleId", "com.facebook.wda.integrationApp");
        capabalities.setCapability("app", file.getAbsolutePath());
        driver = new IOSDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabalities);

    }

    @Test
    public void test1() throws InterruptedException {
        driver.findElementByXPath("//XCUIElementTypeButton[@name='Scrolling']").click();
        waitingTime();
        driver.findElementByXPath("//XCUIElementTypeButton[@name='ScrollView']").click();
        waitingTime();
        for(int i=0;i<3;i++) {
			this.verticalSwipeByPercentages(0.80, 0.40, 0.20);
			
        }
        System.out.println("Tet case passed*****************");
        
    }

    public void waitingTime() throws InterruptedException {
        Thread.sleep(2000);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

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
