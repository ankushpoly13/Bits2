package com.bits.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bits.qa.base.TestBase;
import com.bits.qa.util.ScreenShot;

public class CommissionHistorySingledownload extends TestBase {

	// User ID
	@FindBy(id = "UserId")
	WebElement UserID;

	// Year
	@FindBy(id = "ddlYear")
	WebElement Year;

	// Period
	@FindBy(id = "ddlPeriod")
	WebElement Period;

	// Search Textbox
	@FindBy(xpath = "//*[@id=\"SingleDownloadSwitch\"]/div[1]/div/div[2]/div[1]/div[3]/div/div/div[1]/input")
	WebElement Search;

	// period '11/04/2019-12/01/2019'
	@FindBy(xpath = "//div[@class='col-md-3 form-field']//div[@class='filter-option-inner-inner'][contains(text(),'Select Period')]")
	WebElement Period19;

	// Submit
	@FindBy(xpath ="//button[@class='btn btn-add col-md-3']")
	WebElement Submit;

	// Commission Text 1
	@FindBy(xpath = "//*[@id=\"total_incentive_amount\"]")
	WebElement Comm1;

	// Show more
	@FindBy(id = "TableShowMore")
	WebElement Showmore;

	// Commission Text 2
	@FindBy(xpath = "//*[@id=\"ConsulatantTable_0\"]/tfoot[1]/tr[3]/td[41]")
	WebElement Comm2;

	// Bank(20%) Amount
	@FindBy(xpath = "//div[@id='SingleDownloadSwitch']//tfoot//tr[4]//td[38]/following-sibling::td[1]")
	WebElement BankAmount;

	// Live
	@FindBy(xpath = "//label[contains(text(),'Live')]")
	WebElement Live;

	// Frozen
	@FindBy(xpath = "//label[contains(text(),'Frozen')]")
	WebElement Frozen;
	
	// Loading bar
    @FindBy(id="wait")
    WebElement loader;

	public CommissionHistorySingledownload() {
		PageFactory.initElements(driver, this);
	}

	public void Common() throws InterruptedException
	{
		
			Select user = new Select (UserID); 
			user.selectByValue("aayam.patil");
			Select Y = new Select (Year);
			Y.selectByValue("2019");
			Select per =new Select(Period);
			per.selectByValue("27");
			Thread.sleep(2000);
			boolean b=	driver.findElement(By.xpath("//button[@id='btnFreeze']")).isDisplayed();
				if (b==false)
					{
						Frozen.click();
					}
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));
			Submit.click();
			Thread.sleep(1000);
			wait.until(ExpectedConditions.attributeContains(loader, "class", "hidden"));			
			Thread.sleep(1000);
			Showmore.click();        
	}

	public String verifycommissiontables() throws InterruptedException {
			boolean a = driver.findElements(By.xpath("//*[@id='ConsulatantTable_1_wrapper']")).size() != 0;
			if (a == true) {
				return "1";
			}
	
			else {
				return "0";
			}
	}

	public double rowcount0() throws InterruptedException {

			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='ConsulatantTable_0']/tfoot[1]/tr"));
			int row = rows.size();
			// System.out.println("Row size before subtracting: "+row);
	
			if (row == 8) {
				row = row - 5;
				// System.out.println("Row size after subtracting: "+row);
				String string1 = "//*[@id='ConsulatantTable_0']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("string1 + row + string2: "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission2 = Double.parseDouble(text);
				return Commission2;
			} else if (row == 4) {
				row = row - 3;
				// System.out.println("Row size after if "+row);
				String string1 = "//*[@id='ConsulatantTable_0']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("String "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission2 = Double.parseDouble(text);
				return Commission2;
			} else if (row == 2) {
				row = row - 1;
				// System.out.println("Row size after if "+row);
				String string1 = "//*[@id='ConsulatantTable_0']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("String "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission2 = Double.parseDouble(text);
				return Commission2;
			} else {
				row = row - 1;
				// System.out.println("Row size after if "+row);
				String string1 = "//*[@id='ConsulatantTable_0']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("String "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission2 = Double.parseDouble(text);
				return Commission2;
			}

	}

	public double rowcount1() throws InterruptedException {

			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='ConsulatantTable_1']/tfoot[1]/tr"));
			int row = rows.size();
			// System.out.println("Row size before if "+row);
	
			if (row == 8) {
				row = row - 5;
				// System.out.println("Row size after if row= row-5"+row);
				String string1 = "//*[@id='ConsulatantTable_1']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("string1 + row + string2: "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission3 = Double.parseDouble(text);
				return Commission3;
			} else if (row == 4) {
				row = row - 3;
				// System.out.println("Row size after if row= row-3 "+row);
				String string1 = "//*[@id='ConsulatantTable_1']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("String "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission3 = Double.parseDouble(text);
				return Commission3;
			} else if (row == 2) {
				row = row - 1;
				// System.out.println("Row size after if row= row-1 "+row);
				String string1 = "//*[@id='ConsulatantTable_1']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("String "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission3 = Double.parseDouble(text);
				return Commission3;
			} else {
				row = row - 1;
				// System.out.println("Row size after if row= row-1 "+row);
				String string1 = "//*[@id='ConsulatantTable_1']/tfoot[1]/tr[";
				String string2 = "]/td[41]";
				String rowcounts = string1 + row + string2;
				// System.out.println("String "+rowcounts);
				WebElement com = driver.findElement(By.xpath(rowcounts));
				String text = com.getText();
				text = text.replaceAll("[, ;]", "");
				double Commission3 = Double.parseDouble(text);
				return Commission3;
			}

	}

	public Double totalCommission1() throws InterruptedException {
				String Commission1 = Comm1.getText();
				Commission1 = Commission1.replaceAll("[, ;]", "");
				// System.out.println("String "+ Commission1);
				double NumCommission1 = Double.parseDouble(Commission1);
				// System.out.println("After changing from string to double "+ NumCommission1);
				return NumCommission1;
	}

	public void test() {

				Select dropdown = new Select(driver.findElement(By.id("UserId")));
				// Get all options
				List<WebElement> user = dropdown.getOptions();
		
				// Get the length
				System.out.println(user.size());
		
				// Loop to print one by one
				for (int j = 0; j < user.size(); j++) {
					String s = user.get(j).getText();
					dropdown.selectByValue(s);

		}

	}

	public int sizedropdown() throws InterruptedException {
				Select dropdown = new Select(driver.findElement(By.id("UserId")));
				List<WebElement> user = dropdown.getOptions();
				int userq = user.size();
				return userq;
				/*
				 * System.out.println(user.size()); for (int j = 1; j < user.size(); j++) {
				 * String s= user.get(j).getText(); dropdown.selectByValue(s); }
				 */
	}

	public void common2() {
				Select dropdown = new Select(driver.findElement(By.id("UserId")));
				List<WebElement> user = dropdown.getOptions();
				for (int j = 1; j < user.size(); j++) {
					String s = user.get(j).getText();
					dropdown.selectByValue(s);
				}

	}

}
