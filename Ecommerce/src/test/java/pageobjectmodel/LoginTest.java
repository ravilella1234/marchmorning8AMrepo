package pageobjectmodel;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest 
{
	
	WebDriver driver;
	
  @BeforeMethod
  public void beforeMethod() 
  {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://automationpractice.com/index.php");
  }
  
  @Test
  public void f() throws Exception 
  {
	  
	  LoginPage p=new LoginPage(driver);
	  p.customerLogin();
	  
	  String expectedMsg="Authentication failed.";
	  Assert.assertEquals(p.verifyError(), expectedMsg);
	  
	  
	  
		/*
		 * driver.findElement(By.linkText("Sign in")).click(); Thread.sleep(2000);
		 * driver.findElement(By.id("email")).sendKeys("qatest876767@gmail.com");
		 * driver.findElement(By.id("passwd")).sendKeys("password");
		 * driver.findElement(By.id("SubmitLogin")).click();
		 * 
		 * String actualMsg =
		 * driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]"
		 * )).getText(); String expectedMsg="Authentication failed.";
		 * 
		 * Assert.assertEquals(actualMsg, expectedMsg);
		 */
  }

  @AfterMethod
  public void afterMethod() 
  {
	  
  }

}
