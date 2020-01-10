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
	WebElement newHires;
	
	SuperAdminDashboard()
	{
		
		
		PageFactory.initElements(driver, this);
	}
	
	//**********************   INDIA   //**********************
	
	public void checkNewHiresIndia()
	{
		sleep(7000);
		Select yearSel = new Select(csyear);
		yearSel.selectByValue("2019");
		sleep(7000);
		Select periodSel = new Select(csperiod);
		periodSel.selectByValue("27");
		sleep(5000);
		System.out.println(newHires.getText());
	}
	
	public static void sleep(int i)
	{
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
