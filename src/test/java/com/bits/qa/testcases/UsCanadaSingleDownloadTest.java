package com.bits.qa.testcases;

import org.openqa.selenium.By;
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
		String User="adeline.wilkop";
		
		USCommData.submitUser(User);
		
		/////////////////
		// For users with 1 plan
		if(USCommData.checkNoOfPlans()==1)
		{
			
			Float Total = USCommData.getCommFromSummary();
			Float CommissionInTable;
			String planName = USCommData.planName(1);
			USCommData.showMore();
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
		// For users with 2 plans
		else
		{
			float Total = USCommData.getCommFromSummary();
			float CommissionInTable = (float) 0;
			USCommData.showMore();	
			for(int k=1;k<=2;k++)
			{
				String planName = USCommData.planName(k);
				if(USCommData.checkTableExistance())
				{
					if(planName.equals("111"))
					{
						CommissionInTable = CommissionInTable + USCommData.commissionFor111(User);
					}
					else if(planName.equals("101"))
					{
						CommissionInTable = CommissionInTable + USCommData.commissionFor101(User);
					}
					else
					{
						CommissionInTable = CommissionInTable + USCommData.commissionForDefault(User);
					}	
					USCommData.switchTab();
				}
				
			}
			Assert.assertEquals(Math.floor(Total), Math.floor(CommissionInTable));
		}
		////////////////////////
		
	}
	
	

	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
