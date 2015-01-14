package com.sample.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import com.sample.pages.AboutPage;
import com.sample.pages.ExplorePage;
import com.sample.pages.HomePage;
import com.sample.pages.ProgramsPage;
import com.sample.pages.RegisterPage;

public class SmokeTest extends BaseTest
{
	HomePage hp;
	AboutPage ap;
	RegisterPage rp;
	ProgramsPage pp;
	ExplorePage ep;
	@Test
	public void test1()
	{
		browser.manage().window().maximize();
		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		hp=new HomePage(browser);
		ap=hp.clickAbout();
		rp=ap.clickJoin();
		pp=rp.clickPrograms();
		ep=pp.clickExplore();
	}
	

}
