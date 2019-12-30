package com.bits.qa.pages;

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
	
	public boolean checkLogo()
	{
		return logo.isDisplayed();
	}
	
	public CommonDashboard OpenCD()
	{
		
		driver.get("https://apps.collabera.com/BITS_BETA/Dashboard/CommonDashboard");
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new CommonDashboard();
	}
	
	
	
}
