package com.project.Ecommerce;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class RadioButton1 extends BaseTest
{


	@BeforeMethod
	@Parameters("browser")
	  public void beforeMethod(String bType) throws Exception 
	  {
		init();
		test=report.startTest("RadioButton1");
		test.log(LogStatus.INFO, "Initializing the Properties Files....");
		
		openBrowser(bType);
		test.log(LogStatus.INFO, "Opened the browser :-" + p.getProperty("chromebrowser"));
		
		navigateUrl("radiourl");
		test.log(LogStatus.INFO, "Navigated to url :-" + subprop.getProperty("radiourl"));
			
	  }
	
	
	@Test
	public void radioTest() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
	  
	  report.endTest(test);
	  report.flush();
  }
	
}
