package com.bits.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.CommissionHistorySingledownload;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;


import org.testng.Assert;


public class CommissionHistorySingledownloadTest extends TestBase
{
	LoginPage loginPage;
	HomePage homepage;
	CommissionHistorySingledownload CommissionHistory;
	
	public CommissionHistorySingledownloadTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		homepage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		CommissionHistory = homepage.navigate();
	}
	
	@Test
	public void GrandTotal_CommissionComparision() throws InterruptedException 
	{
	Double	value1= null;
	Double  value2= null;
	//homepage = loginPage.login(prop.getProperty("email"),prop.getProperty("password") );
	value1 = CommissionHistory.totalCommission1();
	System.out.println("value1 "+ value1);
	value2 = CommissionHistory.totalCommission2();
	System.out.println("value2 "+ value2);
	Assert.assertEquals(value1, value2,"GrandTotal_CommissionComparision Match Failed");
	}
	
	//@Test
	public void BankCalculations() throws InterruptedException 
	{
	Double	value1= null;
	Double  value2= null;
	//homepage = loginPage.login(prop.getProperty("email"),prop.getProperty("password") );
	value1 = CommissionHistory.totalCommission1();
	System.out.println("value1"+ value1);
	value2 = CommissionHistory.totalCommission2();
	System.out.println("value2"+ value1);
	Assert.assertEquals(value1, value2,"GrandTotal_CommissionComparision Match Failed");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	
	}

}