package com.sample.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest 
{
private static Logger log = Logger.getLogger(BaseTest.class.getName());
	
	//This browser object will be shared across the framework
	WebDriver browser;
	
	@Before
	public void startBrowser() throws Exception
	{
		DOMConfigurator.configure("log4j.xml");
		if(System.getProperty("browser").contains("FF"))
		{
			browser = new FirefoxDriver();
			log.info(" FF browser is initialized ");
		}
		else if(System.getProperty("browser").contains("GC"))
		{
			URL chromeDriverURL = BaseTest.class.getResource("/driver/chromedriver.exe");
			File file = new File(chromeDriverURL.getFile()); 
			System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, file.getAbsolutePath());
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--ignore-certificate-errors");
		
			browser = new ChromeDriver(options);
			log.info(" Google Chrome browser is initialized ");
		}
		
		else if(System.getProperty("browser").contains("IE"))
		{
			URL IEDriverURL = BaseTest.class.getResource("/driver/IEDriverServer.exe");
			File file = new File(IEDriverURL.getFile()); 
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY, file.getAbsolutePath());
			
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
			browser = new InternetExplorerDriver(capabilities);
			log.info(" Google Chrome browser is initialized ");
		}
		
		else if(System.getProperty("browser").contains("RM"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			String remoteUrl = System.getProperty("RURL");
			browser = new RemoteWebDriver(new URL("http://"+remoteUrl+":4444/wd/hub"), capabilities);
		}
		browser.get("http://www.expotv.com/");
		
	}
	 
	
	@After
	public void closeBrowser() throws Throwable
	{
		Thread.sleep(3000);
		
		// Quit the browser after each test
		browser.quit();
		log.info("Quit the browser after each test");
	}
	 


}
