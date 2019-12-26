package com.bits.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bits.qa.base.TestBase;
import com.bits.qa.pages.HomePage;
import com.bits.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage(); 
		
	}
	
	@Test
	public void loginTest() 
	{
		homePage= loginPage.login(prop.getProperty("email"),prop.getProperty("password") );
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title,"Home Page");
		System.out.println(title);
		//loginpagetitletest();
	}
	
	//@Test
	public void loginpagetitletest() 
	{
	String title = loginPage.validateLoginPageTitle();
	Assert.assertEquals(title,"Home Page","Title Not Matched");
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
