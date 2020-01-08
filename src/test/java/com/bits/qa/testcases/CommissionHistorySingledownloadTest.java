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
	Double  value3 =0.00;
	Double  sum=null;
	CommissionHistory.Common();
	value1 = CommissionHistory.totalCommission1();
	String g= CommissionHistory.verifycommissiontables();
	System.out.println("Value of g is :" +g);
	if (g=="0")
	{
		value2 = CommissionHistory.rowcount0();
	}	
	if (g=="1")
	{
		value2 = CommissionHistory.rowcount0();
		value3 = CommissionHistory.rowcount1();
	}
	System.out.println("Value 2: "+value2 );
	System.out.println("Value 3 "+value3 );
	sum =value2+value3;
	System.out.println("Value 1: "+ value1);
	System.out.println("Sum of Value 2 and 3 is:  "+sum );
	Assert.assertEquals(value1, sum,"GrandTotal_CommissionComparision Match Failed");
	}
	
	//@Test
	public void test1() 
	{
	CommissionHistory.test();
	}
	
	
	//@Test
	public void allvalues() throws InterruptedException
	{
		int  h= CommissionHistory.sizedropdown();
		for (h = 1; h <h ; h++) 
		{		
		Double	value1= null;
		Double  value2= null;
		Double  value3 =0.00;
		Double  sum=null;
		CommissionHistory.Common();
		value1 = CommissionHistory.totalCommission1();
		String g= CommissionHistory.verifycommissiontables();
		if (g=="0")
		{
			value2 = CommissionHistory.rowcount0();
		}	
		if (g=="1")
		{
			value2 = CommissionHistory.rowcount0();
			value3 = CommissionHistory.rowcount1();
		}
		else 
			System.out.println("g value not found");
		
		System.out.println("Value 2: "+value2 );
		System.out.println("Value 3 "+value3 );
		sum =value2+value3;
		System.out.println("Value 1: "+ value1);
		System.out.println("Sum of Value 2 and 3 is:  "+sum );
		Assert.assertEquals(value1, sum,"GrandTotal_CommissionComparision Match Failed");
		}
	}
	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	
	}

}