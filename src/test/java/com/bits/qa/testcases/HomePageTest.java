package com.bits.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage LogIn;
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		
		homePage = LogIn.login(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyLogo()
	{
		
	}
	
	@AfterTest
	public void tearDown()
	{
		
	}
	
}
