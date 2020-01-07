package com.bits.qa.pages;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class DHRCommission extends TestBase{
	
	
	// Loading bar
	@FindBy(id="wait")
	WebElement loader;
	
	// User name dropdown
	@FindBy(id="UserId")
	WebElement DHRUser;
	
	// Year dropdown
	@FindBy(id="ddlYear")
	WebElement DHRYear;
	
	// Period dropdown
	@FindBy(id="ddlPeriod")
	WebElement DHRPeriod;
	
	// Commission amount for the selected period
	@FindBy(id="incentiveAmt")
	WebElement PeriodComm;
	
	// Success message
	@FindBy(id="spnTitle")
	WebElement SuccessMsg;
	
	// Table rows
	@FindBy(xpath="//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr")
	List<WebElement> rows;
	
	// Pagination
	@FindBy(xpath="//select[@name=\"TBL_DHRConsultantDetail_length\"]")
	WebElement pagination;
	
	/////////////////////// 
	
	// Payout date
	@FindBy(id="spnpayoutdate")
	WebElement payoutDate;
	
	
	DHRCommission()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkPeriodCommSal(String User) throws ParseException
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String year = "2019";
		String period = "26";
		String records = "100";
		
		Select userSel = new Select(DHRUser);
		userSel.selectByVisibleText(User);
		
		Select yearSel = new Select(DHRYear);
		yearSel.selectByVisibleText(year);

		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		
		Select periodSel = new Select(DHRPeriod);
		periodSel.selectByValue(period);		
		
		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		
		Select paginationSel = new Select(pagination);
		paginationSel.selectByValue(records);
		
		String amount = PeriodComm.getAttribute("value");
		String[] list = amount.split(" ");
		Float commAmount= Float.parseFloat(list[list.length-1].replaceAll(",", ""));
		
		
		
		String date[] = periodSel.getFirstSelectedOption().getText().split(" ");
		String date1 = date[0];
		String date2 = date[date.length-1];
		
		 SimpleDateFormat sdfo = new SimpleDateFormat("MM/dd/yyyy");
		 Date d1 = sdfo.parse(date1);
		 Date d2 = sdfo.parse(date2);

		int NoOfRows = rows.size();
		
		String[] CollectionDates = new  String[NoOfRows] ;
		for(int i=0;i<NoOfRows;i++)
		{
			String xpath = "//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr["+(i+1)+"]/td[13]";
			CollectionDates[i]=driver.findElement(By.xpath(xpath)).getText().toString();
		}
		
		Date[] dateToCompare = new Date[NoOfRows];
		Float total = (float) 0;
		for(int i=0;i<NoOfRows;i++)
		{
			dateToCompare[i]= sdfo.parse(CollectionDates[i]);
			if(dateToCompare[i].compareTo(d1) >= 0  && dateToCompare[i].compareTo(d2) <= 0)
			{
				//dateToCompare[i] is after d1  && dateToCompare[i] is before d2
				String xpathForComm= "//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr["+(i+1)+"]/td[25]";
				String amountInRow = driver.findElement(By.xpath(xpathForComm)).getText();
				String[] list1 = amountInRow.split(" ");
				Float amt= Float.parseFloat(list1[list1.length-1].replaceAll(",", ""));
				total=total+amt;
			}
		}
		String xpathForLastRow = "//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr["+(NoOfRows-1)+"]/td[25]";
		
		
		// Code for Screenshot
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(xpathForLastRow)));
		String SSName = "checkPeriodComm - "+User;
		ScreenShot.TakeFullPageScreenShot(driver,SSName,"DHRCommission");

		
		if(total.equals(commAmount))
		{
			System.out.println("correct");
			return true;
		}
		else
		{
			System.out.println(commAmount);
			System.out.println(total);
			System.out.println("incorrect");
			return false;
		}
			
	}
	
	
	
	
	public void checkPeriodCommDra(String User) throws ParseException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		String year = "2019";
		String period = "24";
		String records = "100";
		
		Select userSel = new Select(DHRUser);
		userSel.selectByVisibleText(User);
		
		Select yearSel = new Select(DHRYear);
		yearSel.selectByVisibleText(year);

		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		
		Select periodSel = new Select(DHRPeriod);
		periodSel.selectByValue(period);		
		
		wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
		
		Select paginationSel = new Select(pagination);
		paginationSel.selectByValue(records);
		
		String amount = PeriodComm.getAttribute("value");
		String[] list = amount.split(" ");
		Float commAmount= Float.parseFloat(list[list.length-1].replaceAll(",", ""));
		
		System.out.println(commAmount);
		
		
		String podate = payoutDate.getText();
		
		
//		String date[] = periodSel.getFirstSelectedOption().getText().split(" ");
//		String date1 = date[0];
//		String date2 = date[date.length-1];
//		
//		SimpleDateFormat sdfo = new SimpleDateFormat("MM/dd/yyyy");
//		Date d1 = sdfo.parse(date1);
//		Date d2 = sdfo.parse(date2);

		 
		int NoOfRows = rows.size();
		////////////////
//		String[] CollectionDates = new  String[NoOfRows] ;
//		for(int i=0;i<NoOfRows;i++)
//		{
//			String xpath = "//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr["+(i+1)+"]/td[13]";
//			CollectionDates[i]=driver.findElement(By.xpath(xpath)).getText().toString();
//		}
		
//		Date[] dateToCompare = new Date[NoOfRows];
//		Float total = (float) 0;
//		for(int i=0;i<NoOfRows;i++)
//		{
//			dateToCompare[i]= sdfo.parse(CollectionDates[i]);
//			if(dateToCompare[i].compareTo(d1) >= 0  && dateToCompare[i].compareTo(d2) <= 0)
//			{
//				//dateToCompare[i] is after d1  && dateToCompare[i] is before d2
//				String xpathForComm= "//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr["+(i+1)+"]/td[25]";
//				String amountInRow = driver.findElement(By.xpath(xpathForComm)).getText();
//				String[] list1 = amountInRow.split(" ");
//				Float amt= Float.parseFloat(list1[list1.length-1].replaceAll(",", ""));
//				total=total+amt;
//			}
//		}
//		
//		String xpathForLastRow = "//*[@id=\"TBL_DHRConsultantDetail\"]/tbody/tr["+(NoOfRows-1)+"]/td[25]";
		
		
		// Code for Screenshot
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath(xpathForLastRow)));
//		String SSName = "checkPeriodComm - "+User;
//		ScreenShot.TakeFullPageScreenShot(driver,SSName,"DHRCommission");

		
//		if(total.equals(commAmount))
//		{
//			System.out.println("correct");
//			return true;
//		}
//		else
//		{
//			System.out.println(commAmount);
//			System.out.println(total);
//			System.out.println("incorrect");
//			return false;
//		}
			
	}
}
