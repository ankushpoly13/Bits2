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
	public void verifyCommission1() 
	{
		String User="abby.hayden";
		
		USCommData.submitUser(User);
		
		// For users with single plan
		if(USCommData.checkNoOfPlans()<2)
		{
			String planName = USCommData.planName(1);
			
			
			Float Total = USCommData.getCommFromSummary();
			Float CommissionInTable;
			if(USCommData.checkTableExistance())
			{
				if(planName.equals("111"))
				{
					CommissionInTable = USCommData.commissionFor111(User);
				}
				else if(planName.equals("101"))
				{
					CommissionInTable = USCommData.commissionFor101(User);
				}
				else
				{
					CommissionInTable = USCommData.commissionForDefault(User);
				}				
				Assert.assertEquals(Math.floor(Total), Math.floor(CommissionInTable));
			}
			else
			{
				Assert.assertTrue(USCommData.noTable(User, Total));
			}
			
		}
		

		
	}
	
	

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
