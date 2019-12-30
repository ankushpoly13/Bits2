package com.bits.qa.testcases;

import org.testng.annotations.BeforeMethod;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.LoginPage;

public class CommissionHistorySingledownload extends TestBase
{
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage(); 
	}
	
	
	
}
