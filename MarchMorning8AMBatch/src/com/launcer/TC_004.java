package com.launcer;

import com.relevantcodes.extentreports.LogStatus;

public class TC_004 extends BaseTest
{	
	
	public static void main(String[] args) throws Exception 
	{
		
		
		init();
		test=report.startTest("TC_004");
		test.log(LogStatus.INFO, "Initializing Properties files......");
		
	
		openBrowser("chromebrowser");
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + subprop.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","amazondropvalue");
		test.log(LogStatus.INFO, "Selected the option :- " + mainprop.getProperty("amazondropvalue") + " by using locator :- " + mainprop.getProperty("amazondropdown_id"));

		type("amazonsearchtext_id","amzonsearchtext");
		test.log(LogStatus.INFO, "Entered the text :- "+ mainprop.getProperty("amzonsearchtext") + " by using locator :- " + mainprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on element by using the locator :- " + mainprop.getProperty("amazonsearchbutton_xpath"));

		report.endTest(test);
		report.flush();
		
	}

}
