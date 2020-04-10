package com.project.Ecommerce;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

public class TC_002 extends BaseTest
{
	
  @BeforeMethod(groups = {"regression","sanity"})
  @Parameters("browser")
  public void startProcess(String bType) throws Exception 
  {
	    init();
		test=report.startTest("TC_002");
		test.log(LogStatus.INFO, "Initializing Properties files......");
		
	
		openBrowser(bType);
		test.log(LogStatus.INFO, "Opened the browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		test.log(LogStatus.INFO, "Navigated to url :- " + subprop.getProperty("amazonurl"));
  }	
	
  @Test(groups = {"regression","sanity"})
  public void amazon() 
  {
	    selectOption("amazondropdown_id","amazondropvalue");
		test.log(LogStatus.INFO, "Selected the option :- " + mainprop.getProperty("amazondropvalue") + " by using locator :- " + mainprop.getProperty("amazondropdown_id"));

		type("amazonsearchtext_id","amzonsearchtext");
		test.log(LogStatus.INFO, "Entered the text :- "+ mainprop.getProperty("amzonsearchtext") + " by using locator :- " + mainprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		test.log(LogStatus.INFO, "Clicked on element by using the locator :- " + mainprop.getProperty("amazonsearchbutton_xpath"));
  }
  

  @AfterMethod(groups = {"regression","sanity"})
  public void endProcess() 
  {
	  report.endTest(test);
	  report.flush();
		
	  driver.quit();
  }

}
