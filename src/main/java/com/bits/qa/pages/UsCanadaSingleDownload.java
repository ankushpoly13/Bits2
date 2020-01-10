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
	
	// Show more button for multiple
	@FindBy(id="TableShowMore")
	WebElement showMorebtnMul;
	
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
	
	// Plan name tab
	@FindBy(xpath="//ul[@id=\"AddPlanTab\"]/li")
	List<WebElement> plans;
	
	
	
	public UsCanadaSingleDownload()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void submitUser(String User) 
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

		sleep(1000);
		if(!freezeBtn.isDisplayed())
		{
			freezeSld.click();
		}
		
		sleep(2000);
		subbtn.click();
		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		
	}
	
	public void showMore()
	{
		sleep(2000);
		showMorebtn.click();
		sleep(2000);
	}
	
	public void showMoreMul()
	{
		sleep(2000);
		showMorebtnMul.click();
		sleep(2000);
	}

	public float getCommFromSummary()
	{
		sleep(3000);
		return Float.parseFloat(incentiveTotal.getText().replaceAll(",", ""));
	}

	public boolean checkTableExistance()
	{
		return CommissionTable.isDisplayed();
	}
	
	public float commissionFor111(String User)
	{
		int numberOfRows = 3;
		WebElement comm1 = driver.findElement(By.xpath("//table[@id=\"TableSlab\"]/tbody/tr["+numberOfRows+"]/td[3]"));
		WebElement comm2 = driver.findElement(By.xpath("//table[@id=\"TableSlab\"]/tbody/tr["+numberOfRows+"]/td[4]"));
		Float com1 = Float.parseFloat(comm1.getText().replaceAll(",", ""));
		Float com2 = Float.parseFloat(comm2.getText().replaceAll(",", ""));
		
		jsScreenshot(User,comm2);
		return com1+com2;
	}
	
	public float commissionFor101(String User)
	{
		WebElement comm1 = driver.findElement(By.xpath("//*[@id=\"TblEffectivePer\"]/tbody/tr[1]/td[11]"));
		WebElement comm2 = driver.findElement(By.xpath("//*[@id=\"TblEffectivePer\"]/tbody/tr[2]/td[11]"));
		
		Float com1 = Float.parseFloat(comm1.getText().replaceAll(",", ""));
		Float com2 = Float.parseFloat(comm2.getText().replaceAll(",", ""));
		
		jsScreenshot(User,comm2);
		return com1+com2;
	}
	
	public float commissionForDefault(String User)
	{
		// dynamic table handling code STARTS here
		System.out.println(rows.size());
		int CommissionRow = rows.size();
		WebElement comm1;
		WebElement comm2;
		if(plans.size()>1)
		{
			comm1 = driver.findElement(By.xpath("//*[@id=\"ConsulatantTable\"]/tfoot/tr[1]/td[15]"));
			comm2 = driver.findElement(By.xpath("//*[@id=\"ConsulatantTable\"]/tfoot/tr[1]/td[20]"));
		}
		else
		{
			comm1 = staticPath.findElement(By.xpath("//tr["+CommissionRow+"]/td[15]"));
			comm2 = staticPath.findElement(By.xpath("//tr["+CommissionRow+"]/td[20]"));			
		}
		// dynamic table handling code ENDS here
		
		Float com1 = Float.parseFloat(comm1.getText().replaceAll(",", ""));
		Float com2 = Float.parseFloat(comm2.getText().replaceAll(",", ""));
		System.out.println(com1);
		System.out.println(com2);
		jsScreenshot(User,comm2);
		return com1+com2;
	}
	
	
	public boolean noTable(String User, Float Total)
	{
		jsScreenshot(User,incentiveTotal);
		if(Total==0.0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void jsScreenshot(String User, WebElement we)
	{
		// Code for Screenshot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",we);
		String SSName = "checkCommission - "+User;
		ScreenShot.TakeFullPageScreenShot(driver,SSName,"USCASingle");
	}
	
	public void switchTab()
	{
		driver.findElement(By.xpath("//*[@id=\"AddPlanTab\"]/li[2]/a")).click();
		sleep(1000);
	}
	
	public static void sleep(int ms)
	{
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public int checkNoOfPlans()
	{
		return plans.size();
	}
	
	public String planName(int i)
	{
		return (driver.findElement(By.xpath("//ul[@id=\"AddPlanTab\"]//li["+i+"]//a")).getText());
	}

}
