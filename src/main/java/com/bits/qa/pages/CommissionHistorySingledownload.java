package com.bits.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bits.qa.base.TestBase;

public class CommissionHistorySingledownload extends TestBase{
	
	//User ID
	@FindBy(xpath="//div[contains(text(),'Select UserId')]")
	WebElement UserID;
	
	//'aakanksha.shaha'
	@FindBy(xpath="//span[contains(text(),'aakanksha.shaha')]")
	WebElement User;
	
	//Year
	@FindBy(xpath="//div[contains(text(),'Select Year')]")
	WebElement Year;

	//Period
	@FindBy(xpath="//button[@class='btn dropdown-toggle disabled btn-light']//div[@class='filter-option-inner-inner'][contains(text(),'Select Period')]")
	WebElement Period;
	
	//Submit
	@FindBy(xpath="//button[@class='btn btn-add col-md-3']")
	WebElement Submit;
	
	//Commission Text 1
	@FindBy(xpath="//*[@id=\"total_incentive_amount\"]")
	WebElement Comm1;
	
	//Show more
	@FindBy(id="TableShowMore")
	WebElement Showmore;
	
	//Commission Text 2
	@FindBy(xpath="//*[@id=\"ConsulatantTable_0\"]/tfoot[1]/tr[3]/td[41]")
	WebElement Comm2;
	
	//Bank(20%) Amount
	@FindBy(xpath="//div[@id='SingleDownloadSwitch']//tfoot//tr[4]//td[38]/following-sibling::td[1]")
	WebElement BankAmount;
	
	//Live
	@FindBy(xpath="//label[contains(text(),'Frozen')]")
	WebElement Live ;
	
	public CommissionHistorySingledownload()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Double totalCommission1() throws InterruptedException
	{
		
		//Select user = new Select (UserID); 
		//user.selectByIndex(1);
		Thread.sleep(5000);
		UserID.click();
		User.click();
		Thread.sleep(5000);
		Live.click();
		Submit.click();
		Thread.sleep(5000);
		Showmore.click();
		String Commission1 = Comm1.getText();
		Commission1= Commission1.replaceAll("[, ;]", "");
		System.out.println("String "+ Commission1);
		double NumCommission1 = Double.parseDouble(Commission1);
		System.out.println("After changing from string to double "+ NumCommission1);
				
		return NumCommission1;				
	}
	
	public Double totalCommission2()
	{
				
		String Commission2 = Comm2.getText();
		Commission2=Commission2.replaceAll("[, ;]", "");
		System.out.println("string "+ Commission2);
		double NumCommission2 = Double.parseDouble(Commission2);
		System.out.println("After changing from string to double "+ NumCommission2);
		return NumCommission2;				
	}
	
	public String BankAmount20Per()
	{
		String	BankAmount20 = BankAmount.getText();
		System.out.println(BankAmount20);
		return BankAmount20;
	}
	
	
}
