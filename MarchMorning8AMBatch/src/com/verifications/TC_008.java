package com.verifications;

import com.launcer.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC_008 extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		init();
		test=report.startTest("TC_008");
		test.log(LogStatus.INFO, "Initializing Properties files......");
		
	
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + subprop.getProperty("amazonurl"));

		
		String expectedLink="Customer Ser";
		
		if(!isElementEqual(expectedLink))
			reportFailure("Both  Links are not equal...");
		else
			reportSuccess("Both  Links are equal...");
		
		report.endTest(test);
		report.flush();

	}

}
