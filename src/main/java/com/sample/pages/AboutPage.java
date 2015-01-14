package com.sample.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sample.browser.util.Share;

public class AboutPage 
{
private static Logger log = Logger.getLogger(AboutPage.class.getName());
	
	private WebDriver browser;
	
	
	
	public AboutPage(WebDriver browser)
	{
		this.browser = browser; 
		
		log.info("Visiting Home page");
		
	}
	public RegisterPage clickJoin()
	{
		browser.findElement(By.xpath(".//*[@id='siteFooter']/div/a")).click();
		return new RegisterPage(browser);
	}
	

}
