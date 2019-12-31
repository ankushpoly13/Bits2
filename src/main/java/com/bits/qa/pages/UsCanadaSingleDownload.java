package com.bits.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bits.qa.base.TestBase;
import com.bits.qa.util.ScreenShot;

public class UsCanadaSingleDownload extends TestBase{

	// User Select dropdown
	@FindBy(id="UserId")
	private WebElement userDropdown;
	
	// Submit button
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	WebElement subbtn;
	
	// Total incentive
	@FindBy(id="total_incentive_amount")
	WebElement incentiveTotal;
	
	// Show more Button
	@FindBy(xpath="//button[contains(text(),'Show More')]")
	WebElement showMorebtn;
	
	// Table element
	@FindBy(xpath="//*[@id=\"ConsulatantTable\"]/tbody/tr")
	List<WebElement> rows;
	
	// static path for table	
	@FindBy(xpath="//*[@id=\"ConsulatantTable\"]/tbody")
	WebElement staticPath;

	
	public UsCanadaSingleDownload()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkCommission(String User) throws InterruptedException
	{
		Select slc = new Select(userDropdown);
		slc.selectByVisibleText(User);
		Thread.sleep(5000);
		subbtn.click();
		Thread.sleep(5000);
		showMorebtn.click();
		Float total = Float.parseFloat(incentiveTotal.getText().replaceAll(",", ""));

		// dynamic table handling code STARTS here
		int CommissionRow = rows.size();
		WebElement comm1 = staticPath.findElement(By.xpath("//tr["+CommissionRow+"]/td[15]"));
		WebElement comm2 = staticPath.findElement(By.xpath("//tr["+CommissionRow+"]/td[20]"));
		// dynamic table handling code ENDS here
		
		Float com1 = Float.parseFloat(comm1.getText().replaceAll(",", ""));
		Float com2 = Float.parseFloat(comm2.getText().replaceAll(",", ""));
		
		
		// Code for Screenshot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",comm2);
		String SSName = "checkCommission - "+User;
		ScreenShot.TakeFullPageScreenShot(driver,SSName);
		
		
		
		if(Math.floor(total) == Math.floor(com1+com2))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
