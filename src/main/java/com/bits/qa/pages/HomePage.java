package com.bits.qa.pages;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bits.qa.base.TestBase;
import com.bits.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	
	// Logo element
	@FindBy(xpath="//div[@class='content-area text-center default-logo']")
	WebElement logo;
	

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SuperAdminDashboard OpenSD() throws InterruptedException
	{
		try 
		{
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.navigate().to("https://apps.collabera.com/BITS_BETA/Dashboard/SuperAdmin");
		} 
		catch (Exception e)
		{
			System.out.println("Exception handled for timeout");
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
		return new SuperAdminDashboard();
	}
	
	public CommonDashboard OpenCD() throws InterruptedException
	{
		try 
		{
			driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.navigate().to("https://apps.collabera.com/BITS_BETA/Dashboard/CommonDashboard");	
		} 
		catch (Exception e)
		{
			System.out.println("Exception handled for timeout");
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		}
		return new CommonDashboard(); 
	}
	
	public UsCanadaSingleDownload navigateToUSComm()
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Commission/UsCanadaSingleDownload");
		return new UsCanadaSingleDownload();
	}
	
	public DHRCommission navigateToDHRData()
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/DHR/CommissionData");
		return new DHRCommission();
	}
	
	
}
