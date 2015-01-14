package com.sample.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage>
{
	private WebDriver browser;
	public HomePage(WebDriver browser)
	{
		this.browser=browser;
	}
	public AboutPage clickAbout()
	{
		browser.findElement(By.xpath(".//*[@id='mainNav']/ul/li[1]/a")).click();
		return new AboutPage(browser);
	}
	@Override
	protected void load() {
		browser.navigate().to("http://www.expotv.com");
		
	}
	@Override
	protected void isLoaded() throws Error 
	{
		String url=browser.getCurrentUrl();
		Assert.assertTrue(browser.getCurrentUrl().equals(url));
		
		
	}

}
