package com.sample.browser.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Share 
{

	private WebDriver browser;

	public Share(WebDriver browser) 
	{
		this.browser = browser;
	}
	
	public boolean isElementPresent(WebElement ele)
	{
		try
		{
			ele.isDisplayed();
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
			
	}
	
	public boolean isElementPresent(By by)
	{
		try
		{
			browser.findElement(by);
			return true;
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
			
	}
	
	


}
