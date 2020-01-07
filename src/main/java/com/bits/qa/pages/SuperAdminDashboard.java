package com.bits.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bits.qa.base.TestBase;

public class SuperAdminDashboard extends TestBase{
	
	// Year Dropdown
	@FindBy(id="ddlYear1")
	WebElement csyear;
	
	// Period Dropdown
	@FindBy(id="ddlPeriod")
	WebElement csperiod;
	
	// Period Dropdown
	@FindBy(id="StartsPeriod")
	WebElement newhires;
	
	SuperAdminDashboard()
	{
		
		
		PageFactory.initElements(driver, this);
	}
	
	//**********************   INDIA   //**********************
	
	public void checkNewHiresIndia()
	{
		
		Select yearSel = new Select(csyear);
		yearSel.selectByValue("2019");
		System.out.println("test");
		
		Select periodSel = new Select(csperiod);
		periodSel.selectByValue("27");
		
		System.out.println(newhires.getText());
	}
	

}
