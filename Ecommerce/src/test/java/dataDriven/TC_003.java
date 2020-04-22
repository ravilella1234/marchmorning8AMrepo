package dataDriven;

import org.testng.annotations.Test;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

public class TC_003 
{
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(Hashtable<String, String> data) 
  {
	 //if(data.get("RunMode").equals("y"))
		System.out.println(data.get("Runmode")+"-------"+data.get("Col1")+"-----"+data.get("Col2")+"-----"+data.get("Col3")+"-----"+data.get("Col4"));
		//System.setProperty("webdriver.chrome.driver", "D:\\Browser_Drivers\\chromedriver.exe");
		//driver=new ChromeDriver();
		//driver.manage().window().maximize();
		///driver.get("https://www.facebook.com");
		
		//driver.findElement(By.id("email")).sendKeys(data.get("fbuser"));
		//driver.findElement(By.id("pass")).sendKeys(data.get("fbpassword"));
  }

  @DataProvider
  public Object[][] dp() throws Exception 
  {
	   ExcelAPI xls=new ExcelAPI("C:\\Users\\DELL\\Desktop\\SuiteA.xlsx");
		String sheetName="Data";
		String testCaseName="TestB";
	  
	   return DataUtils.getTestData(xls, sheetName, testCaseName);
  }
}
