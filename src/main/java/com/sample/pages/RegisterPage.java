package com.sample.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage 
{
	WebDriver browser;
	public RegisterPage(WebDriver browser)
	{
		this.browser=browser;
	}
	public void sendEmail()
	{
		browser.findElement(By.xpath(".//*[@id='email']")).sendKeys("qashahidul@gmail.com");
	}
	public ProgramsPage clickPrograms()
	{
		browser.findElement(By.xpath(".//*[@id='mainNav']/ul/li[2]/a")).click();
		return new ProgramsPage(browser);
	}

}
