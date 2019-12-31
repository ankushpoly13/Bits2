package com.bits.qa.util;

import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.assertthat.selenium_shutterbug.utils.web.ScrollStrategy;

public class ScreenShot {
	
	public static void TakeFullPageScreenShot(WebDriver driver, String name)
	{System.out.println(name);
		Shutterbug.shootPage(driver, ScrollStrategy.WHOLE_PAGE, 1000).withName(name).save();
	}
}
