package com.bits.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bits.qa.base.TestBase;

public class HomePage extends TestBase{
	
	// Dashboard menu
	@FindBy(xpath="//a[@class='nav-link nav-toggle']//span[@class='title'][contains(text(),'Dashboard')]")
	WebElement dashboard;
	
	// Common Dashboard submenu
	@FindBy(xpath="//li[@class='nav-item start cdashboard open']//li[1]//a[1]//span[1]")
	WebElement commonDashboard;
	
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
	
	public void OpenCD()
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Dashboard/CommonDashboard");
	}
	
	
	
}
