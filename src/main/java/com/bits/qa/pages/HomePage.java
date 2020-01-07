package com.bits.qa.pages;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bits.qa.base.TestBase;

public class HomePage extends TestBase{
	
	
	// Logo element
	@FindBy(xpath="//div[@class='content-area text-center default-logo']")
	WebElement logo;
	

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SuperAdminDashboard OpenSD() 
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Dashboard/SuperAdmin");
		try {
			Runtime.getRuntime().exec("D:\\AutoITScripts\\autoit.exe");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new SuperAdminDashboard();
	}
	
	public CommonDashboard OpenCD() 
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Dashboard/CommonDashboard");
		try {
			Runtime.getRuntime().exec("D:\\AutoITScripts\\autoit.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
