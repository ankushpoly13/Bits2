package com.bits.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bits.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			//C:\Users\aakash.paliwal\eclipse-workspace\bits\src\main\java\com\bits\qa\config
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/bits"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	public static void initialization() 
	{
		System.out.println("Inside");
		String browsername = prop.getProperty("browser");
		System.out.println(browsername);
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Automation\\chromedriver.exe");
			 driver = new ChromeDriver();			
		}
		else
			System.out.println("No Browser name found");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_lOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
}
	



}