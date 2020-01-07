package com.bits.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.CommonDashboard;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;

public class CommonDashboardTest extends TestBase{

	CommonDashboard commondashboard;
	LoginPage login;
	HomePage homepage;
	
	public CommonDashboardTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		login = new LoginPage();
		homepage = login.login(prop.getProperty("email"), prop.getProperty("password"));
		commondashboard = homepage.OpenCD();
		
		
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
