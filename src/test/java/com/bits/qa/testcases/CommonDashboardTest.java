package com.bits.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.CommonDashboard;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;

public class CommonDashboardTest extends TestBase{

	CommonDashboard commonDashboard;
	LoginPage login;
	HomePage homePage;
	
	public CommonDashboardTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		login = new LoginPage();
		homePage = login.login(prop.getProperty("email"), prop.getProperty("password"));
		commonDashboard = homePage.OpenCD();
		
		
	}
	
	@Test
	public void verifyTitle()
	{
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
