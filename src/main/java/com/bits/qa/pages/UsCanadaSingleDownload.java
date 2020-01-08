package com.bits.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bits.qa.base.TestBase;
import com.bits.qa.util.ScreenShot;

public class UsCanadaSingleDownload extends TestBase{

	// Loading bar
	@FindBy(id="wait")
	WebElement loader;
	
	// User Select dropdown
	@FindBy(id="UserId")
	 WebElement userDropdown;
	
	// Year Select dropdown
	@FindBy(id="ddlYear")
	WebElement yearDropdown;
	
	// Period Select dropdown
	@FindBy(id="ddlPeriod")
	WebElement periodDropdown;
	
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

	// table
	@FindBy(id="ConsulatantTable")
	WebElement CommissionTable;
	
	// Freeze button
	@FindBy(id="btnFreeze")
	WebElement freezeBtn;
	
	// Freeze slider
	@FindBy(xpath="//label[contains(text(),'Live')]")
	WebElement freezeSld;
	
	public UsCanadaSingleDownload()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkCommission(String User) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		// Temp until dropdown auto select is resolved
		String year = "2019";
		String period = "80";
		
		
		Select uSel = new Select(userDropdown);
		uSel.selectByVisibleText(User);

		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		Select ySel = new Select(yearDropdown);
		ySel.selectByVisibleText(year);
		
		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		Select pSel = new Select(periodDropdown);
		pSel.selectByValue(period);
		
		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!freezeBtn.isDisplayed())
		{
			freezeSld.click();
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		subbtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		showMorebtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Float Total = Float.parseFloat(incentiveTotal.getText().replaceAll(",", ""));

		
		// check if table exists or not
		if(CommissionTable.isDisplayed())
		{
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
			ScreenShot.TakeFullPageScreenShot(driver,SSName,"USCASingle");
			
			Float CalculatedTotal = com1+com2;
			
			if(Math.floor(Total) == Math.floor(CalculatedTotal))
			{
				return true;
			}
			else
			{
				System.out.println("For user : "+User+",In summary total is "+Total+" but in table total is "+CalculatedTotal);
				return false;
			}
		}
		else
		{
			// Code for Screenshot
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();",incentiveTotal);
			String SSName = "checkCommission - "+User;
			ScreenShot.TakeFullPageScreenShot(driver,SSName,"USCASingle");
			if(Total==0.0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		
		
	}
}
