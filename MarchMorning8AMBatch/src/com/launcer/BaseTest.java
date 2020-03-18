package com.launcer;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	public static Properties p;
	
	public static void init() throws Exception 
	{
		FileInputStream fis = new FileInputStream(projectpath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
	}
	
	
	public static void openBrowser(String browser)
	{
		if(p.getProperty(browser).equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\driver sources\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(p.getProperty(browser).equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\driver sources\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
	}
	
	
	public static void navigateUrl(String url) 
	{
		driver.get(p.getProperty(url));
	}

}
