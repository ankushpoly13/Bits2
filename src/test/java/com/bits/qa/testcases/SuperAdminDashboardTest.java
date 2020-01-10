package com.bits.qa.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;
import com.bits.qa.pages.SuperAdminDashboard;

public class SuperAdminDashboardTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	SuperAdminDashboard superdashboard;
	
	SuperAdminDashboardTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp() 
	{
		initialization();
		loginpage= new LoginPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		try {
			superdashboard = homepage.OpenSD();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	@Test
	public void newHiresIndia()
	{
		superdashboard.checkNewHiresIndia();	
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
}
