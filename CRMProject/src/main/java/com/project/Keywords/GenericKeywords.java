package com.project.Keywords;

import java.util.Hashtable;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GenericKeywords 
{
	public  Properties childProperties; 
	public  Properties orProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	public WebDriver driver;
	
	

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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigating to website....." +objectKey);
		driver.get(objectKey);
	}
	
	public void click()
	{
		System.out.println("Clicking the element....."+orProp.getProperty(objectKey));
		driver.findElement(By.xpath(orProp.getProperty(objectKey))).click();
	}
	
	public void type()
	{
		System.out.println("Typing the Text......." + orProp.getProperty(objectKey) + "-----" + data.get(dataKey));
		driver.findElement(By.xpath(orProp.getProperty(objectKey))).sendKeys(data.get(dataKey));
	}

}
