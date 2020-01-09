package com.bits.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;
import com.bits.qa.pages.UsCanadaSingleDownload;

public class UsCanadaSingleDownloadTest extends TestBase{

	LoginPage Login;
	HomePage homePage;
	UsCanadaSingleDownload USCommData;
	
	UsCanadaSingleDownloadTest()
	{
		super();
	}
	
	
	@BeforeMethod()
	public void setUp()
	{
		initialization();
		Login = new LoginPage();
		homePage = Login.login(prop.getProperty("email"), prop.getProperty("password"));
		USCommData = homePage.navigateToUSComm();
	}
	
	@Test(priority=1)
	public void verifyCommission1() throws InterruptedException
	{
		Assert.assertTrue(USCommData.checkCommission("alan.mars"));	
	}
	
	
	//@Test(priority=2)
	public void verifyCommission2() throws InterruptedException
	{
		Assert.assertTrue(USCommData.checkCommission("alexander.liua"));	
	}
	
	//@Test(priority=3)
	public void verifyCommission3() throws InterruptedException
	{
		Assert.assertTrue(USCommData.checkCommission("celine.tracy"));	
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
