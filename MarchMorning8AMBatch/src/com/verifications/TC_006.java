package com.verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.launcer.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_006 extends BaseTest
{

	public static void main(String[] args) throws Exception
	{
		init();
		test=report.startTest("TC_006");
		test.log(LogStatus.INFO, "Initializing Properties files......");
		
	
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + subprop.getProperty("amazonurl"));
		
		WebElement loc = driver.findElement(By.id("twotabsearchtextbox"));
		
		loc.sendKeys("sony");
		String val = loc.getAttribute("value");
		System.out.println("Text is :- " + val);

	}

}
