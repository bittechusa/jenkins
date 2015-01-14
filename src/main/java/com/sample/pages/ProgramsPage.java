package com.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgramsPage 
{
	WebDriver browser;
	public ProgramsPage(WebDriver browser)
	{
		this.browser=browser;
	}
	public ExplorePage clickExplore()
	{
		browser.findElement(By.xpath(".//*[@id='mainNav']/ul/li[3]/a")).click();
		return new ExplorePage(browser);
	}
	

}
