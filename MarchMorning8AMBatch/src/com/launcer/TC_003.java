package com.launcer;

import org.apache.log4j.Logger;

public class TC_003 extends BaseTest
{

	private static final Logger log=Logger.getLogger(TC_003.class);
	
	
	public static void main(String[] args) throws Exception 
	{
		init();
		log.info("Initializing Properties files......");
		
		openBrowser("chromebrowser");
		log.info("Opened the browser :- " + p.getProperty("chromebrowser"));
		
		navigateUrl("amazonurl");
		log.info("Navigated to url :- " + subprop.getProperty("amazonurl"));
		
		selectOption("amazondropdown_id","amazondropvalue");
		log.info("Selected the option :- " + mainprop.getProperty("amazondropvalue") + " by using locator :- " + mainprop.getProperty("amazondropdown_id") );
			
		type("amazonsearchtext_id","amzonsearchtext");
		log.info("Entered the text :- "+ mainprop.getProperty("amzonsearchtext") + " by using locator :- " + mainprop.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");
		log.info("Clicked on element by using the locator :- " + mainprop.getProperty("amazonsearchbutton_xpath"));
		
	}

}
