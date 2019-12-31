package com.bits.qa.pages;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
	
	
	
	public CommonDashboard OpenCD() throws AWTException, InterruptedException
	{
		
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Dashboard/CommonDashboard");
		Thread.sleep(15000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_A);
		
	
		return new CommonDashboard();
	}
	
	public UsCanadaSingleDownload navigateToUSComm()
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Commission/UsCanadaSingleDownload");
		return new UsCanadaSingleDownload();
	}
	
	
}
