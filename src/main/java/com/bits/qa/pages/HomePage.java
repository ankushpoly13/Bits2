package com.bits.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bits.qa.base.TestBase;

public class HomePage extends TestBase {

	
	// Initializing the Page Objects:
	public HomePage() 
	{
		PageFactory.initElements(driver, this);
	}

	public CommissionHistorySingledownload navigate() 
	{
		driver.navigate().to("https://apps.collabera.com/BITS_BETA/Commission/CommissionHistorySingledownload");
		return new CommissionHistorySingledownload();
	}

	
	}
	
	