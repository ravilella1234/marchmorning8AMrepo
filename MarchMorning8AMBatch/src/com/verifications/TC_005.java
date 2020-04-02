package com.verifications;

import org.openqa.selenium.By;

import com.launcer.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_005 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_005");
		test.log(LogStatus.INFO, "Initializing Properties files......");
		
	
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + subprop.getProperty("amazonurl"));

		//String actualLink = driver.findElement(By.linkText("Customer Service")).getText();
		String actualLink = driver.findElement(By.linkText("Customer Service")).getAttribute("innerHTML");
		String expectedLink="Customer Ser";
		
		System.out.println("Actual Link :" + actualLink);
		System.out.println("Expected Link :" + expectedLink);
		
		//if(actualLink.equals(expectedLink))
		//if(actualLink.equalsIgnoreCase(expectedLink))
		if(actualLink.contains(expectedLink))
		{
			System.out.println("Both links are equal...");
		}	
		else
		{
			System.out.println("Both links are not equal...");
		}
			
		
	}

}
