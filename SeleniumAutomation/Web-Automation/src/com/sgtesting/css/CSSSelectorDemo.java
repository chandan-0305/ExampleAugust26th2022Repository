package com.sgtesting.css;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSSelectorDemo {
	public static WebDriver oBrowser = null;
	
	public static void main(String[] args) {
		launchBrowser();
		navigate();
	//	absoluteCSS();
	//	relativeCSSUsingTagName();
	//	relativeCSSUsingTagNameWithIDAttributeValue();
	//	relativeCSSUsingIDAttributeValue();
	//	relativeCSSUsingTagNameWithClassAttributeValue();
	//	relativeCSSUsingClassAttributeValue();
	//	relativeCSSUsingTagNameWithAttributeNameValue();
	//	relativeCSSUsingTagNameWithMultipleAttributeNameValue();
	//	relativeCSSUsingWithoutTagNameOnlyAttributeNameValue();
	//	relativeCSSUsingTagNameWithPartialAttributeValue();
	//	relativeCSSUsingTagNameWithAttributeName();
	//	relativeCSSUsingTagNameWithAttributeName_1();
	//	relativeCSSUsingTagNameWithAttributeName_2();
	//	relativeCSSUsingParentElementReference();
	//	relativeCSSUsingNthChildConcept();
		relativeCSSUsingSiblingConcept();
	}
	
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
	
	private static void navigate()
	{
		try
		{
			oBrowser.get("file:///E:/HTML/Sample.html");
			Thread.sleep(5000);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void absoluteCSS()
	{
		oBrowser.findElement(By.cssSelector("html body div form input")).sendKeys("DemoUser1");
	}
	/**
	 * Case 1: Identify the Element based on <tagName>
	 * Syntax: <tagName>
	 */
	private static void relativeCSSUsingTagName()
	{
		oBrowser.findElement(By.cssSelector("input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 2: Identify the Element based on <tagName> with id attribute value
	 * Syntax: <tagName>#<id attribute value>
	 */
	private static void relativeCSSUsingTagNameWithIDAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input#pwd1pass1word1")).sendKeys("DemoUser1");
	}

	/**
	 * Case 3: Identify the Element based on id attribute value alone
	 * Syntax: #<id attribute value>
	 */
	private static void relativeCSSUsingIDAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("#pwd1pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 4: Identify the Element based on <tagName> with class attribute value
	 * Syntax: <tagName>.<class attribute value>
	 */
	private static void relativeCSSUsingTagNameWithClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input.pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 5: Identify the Element based on class attribute value alone
	 * Syntax: .<class attribute value>
	 */
	private static void relativeCSSUsingClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector(".pass1word1")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 6: Identify the Element based on TagName With Attribute Name and Value combination
	 * Syntax: <tagName>[attributename='attributevalue']
	 */
	private static void relativeCSSUsingTagNameWithAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit']")).click();
	}
	
	/**
	 * Case 7: Identify the Element based on TagName With Multiple Attribute Name and Value combination
	 * Syntax: <tagName>[attributename='attributevalue'][attributename='attributevalue']
	 */
	private static void relativeCSSUsingTagNameWithMultipleAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit'][name='submit1btn1']")).click();
	}
	
	/**
	 * Case 8: Identify the Element based on TagName With Attribute Name and Value combination
	 * Syntax: *[attributename='attributevalue']
	 */
	private static void relativeCSSUsingWithoutTagNameOnlyAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("*[value='Submit']")).click();
	}
	
	/**
	 * Case 9: Identify the Element based on Partial Matching of Attribute Value combination
	 * 
	 * Syntax: <tagName>[attributename ^='partial attributevalue']
	 * Syntax: <tagName>[attributename $='partial attributevalue']
	 * Syntax: <tagName>[attributename *='partial attributevalue']
	 */
	private static void relativeCSSUsingTagNameWithPartialAttributeValue()
	{
		//oBrowser.findElement(By.cssSelector("input[id ^='btn1']")).click();
		oBrowser.findElement(By.cssSelector("input[id *='mit1']")).click();
	}
	
	/**
	 * Case 10: Identify the Element based on TagName With Attribute Name 
	 * Syntax: <tagName>[attributename]
	 */
	private static void relativeCSSUsingTagNameWithAttributeName()
	{
		// Display Number of links availabe
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		System.out.println("# of Links are :"+oLinks.size());
	}
	
	private static void relativeCSSUsingTagNameWithAttributeName_1()
	{
		// Display Each Link Names
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));

		for(int i=0;i<oLinks.size();i++)
		{
			WebElement oLink=oLinks.get(i);
			String linkname=oLink.getText();
			System.out.println(linkname);
		}
	}
	
	private static void relativeCSSUsingTagNameWithAttributeName_2()
	{
		// Exception in thread "main" org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// element is not attached to the page document
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));

		for(int i=0;i<oLinks.size();i++)
		{
			WebElement oLink=oLinks.get(i);
			String linkname=oLink.getText();
			if(linkname.endsWith("Apache"))
			{
				oLink.click();
			}
		}
	}
	
	/**
	 * Case 11: Identify the Element based on Parent Tag Details
	 * Syntax: parent Element > child Element
	 */
	private static void relativeCSSUsingParentElementReference()
	{
		oBrowser.findElement(By.cssSelector("form#frm2 > input")).click();
	}
	
	/**
	 * Case 12: Identify the Element based on nth-child
	 * Syntax: nth-child(number)
	 */
	private static void relativeCSSUsingNthChildConcept()
	{
	//	oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(5)")).sendKeys("DemoUser5");
		oBrowser.findElement(By.cssSelector("form#frm3 > :nth-child(7)")).sendKeys("DemoUser7");
	}
	
	/**
	 * Case 13: Identify the Element based on Siblings
	 * Syntax:  <tagName> + <tagName> + <tagName>
	 */
	private static void relativeCSSUsingSiblingConcept()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 > input + input + input + input")).sendKeys("DemoUser4");
	}
	

}
