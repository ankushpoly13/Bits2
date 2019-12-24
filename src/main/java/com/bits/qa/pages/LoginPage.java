package com.bits.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bits.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - Object Repository (OR):
	
	// E-Mail Address
	@FindBy(name ="loginfmt")
	WebElement Email;
	
	// Next Button
	@FindBy(id="idSIButton9")
	WebElement Next;
	
	// Password Field
	@FindBy(id="passwordInput")
	WebElement Password;
	
	//SignIn Button
	@FindBy(id="submitButton")
	WebElement Signin;
	
	//Stay signed in?
	@FindBy(id="idBtn_Back")
	WebElement No;
	
	//Initializing the Page Objects:
	public LoginPage() {	
		PageFactory.initElements(driver, this);
	}
	
	//Actions :
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		Email.sendKeys(un);
		Next.click();
		Password.sendKeys(pwd);
		Signin.click();
		No.click();
		
		return new HomePage();
	
	}

}
