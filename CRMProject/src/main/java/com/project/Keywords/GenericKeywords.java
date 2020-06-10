package com.project.Keywords;

import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords 
{
	public  Properties childProperties; 
	public  Properties orProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	public static WebDriver driver;
	
	

	public void setChildProperties(Properties childProperties) {
		this.childProperties = childProperties;
	}

	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void openBrowser()
	{
		String browser = data.get(dataKey);
		System.out.println("Opening the Browser....." + browser);
		
		if(browser.equals("chrome"))
		{
			//Create & invoke userdefined ChromeProfile
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			//Create & invoke userdefined FirefoxProfile
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\MayBatch Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Maximizing window & set implicit wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigating to website....." +objectKey);
		driver.get(objectKey);
	}
	
	public void click() throws Exception
	{
		System.out.println("Clicking the element....."+orProp.getProperty(objectKey));
		//driver.findElement(By.xpath(orProp.getProperty(objectKey))).click();
		getElement(objectKey).click();
	}
	
	public void type()
	{
		System.out.println("Typing the Text......." + orProp.getProperty(objectKey) + "-----" + data.get(dataKey));
		//driver.findElement(By.xpath(orProp.getProperty(objectKey))).sendKeys(data.get(dataKey));
		getElement(objectKey).sendKeys(data.get(dataKey));
	}
	
	public  WebElement getElement(String objectKey)
	{
		WebElement element=null;
		
		try 
		{
			if(objectKey.endsWith("_id")) {
				element = driver.findElement(By.id(orProp.getProperty(objectKey)));
			}if(objectKey.endsWith("_name")) {
				element = driver.findElement(By.name(orProp.getProperty(objectKey)));
			}if(objectKey.endsWith("_xpath")) {
				element = driver.findElement(By.xpath(orProp.getProperty(objectKey)));
			}if(objectKey.endsWith("_css")) {
				element = driver.findElement(By.cssSelector(orProp.getProperty(objectKey)));
			}
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//To check visibility of Object
			wait.until(ExpectedConditions.visibilityOf(element));
			
			//To check state of the Object whether it is clickable or not
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} 
		catch (Exception e) 
		{
			//Report the failure Status
		}
		
		return element;
		
	}
	
	
	public void validateElementPresent()
	{
		if(!isElementPresent(objectKey))
		//Report the failure Status
		reportFailure("Element is not found :- " + objectKey);
	}
	
	public boolean isElementPresent(String objectKey) 
	{
		List<WebElement> element = null;
		
		if(objectKey.endsWith("_id")) {
			element = driver.findElements(By.id(orProp.getProperty(objectKey)));
		}if(objectKey.endsWith("_name")) {
			element = driver.findElements(By.name(orProp.getProperty(objectKey)));
		}if(objectKey.endsWith("_xpath")) {
			element = driver.findElements(By.xpath(orProp.getProperty(objectKey)));
		}if(objectKey.endsWith("_css")) {
			element = driver.findElements(By.cssSelector(orProp.getProperty(objectKey)));
		}
		
		if(element.size()==0)
			return false;
		else
			return true;
	}
	
	
	
	//  ***********************  Reporing Functions   ****************************
	
	public void reportFailure(String failureMsg)
	{
		//Fail the test in giving Fail Status
		System.out.println(failureMsg);
		
		//Take the screenshots , and embedded the screenshots in physical location as well in extent reports
		
	
	}
	

	public void quit()
	{
		if(driver!=null)
			driver.quit();
	}

}
