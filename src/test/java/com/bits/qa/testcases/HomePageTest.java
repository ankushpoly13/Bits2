package com.bits.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.CommonDashboard;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	CommonDashboard commonDashboard;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	
	}
	
	
	
	@Test(priority=1)
	public void test()
	{
		
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
