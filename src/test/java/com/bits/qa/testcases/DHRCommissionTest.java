package com.bits.qa.testcases;

import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.DHRCommission;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;

public class DHRCommissionTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	DHRCommission dhrcomm;
	
	DHRCommissionTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("email"), prop.getProperty("password"));
		dhrcomm = homepage.navigateToDHRData();
		
	}
	
	@Test
	public void checkDHR1() throws ParseException
	{
		Assert.assertTrue(dhrcomm.checkPeriodCommDHR("anuj.hpatel"));
	}
	
	@Test
	public void checkDHR2() throws ParseException
	{
		Assert.assertTrue(dhrcomm.checkPeriodCommDHR("alex.hall"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
