package com.webTables;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Table3 
{

	public static void main(String[] args) throws Exception 
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://datatables.net/examples/advanced_init/dt_events.html");
		int pageMaxSize = driver.findElements(By.cssSelector("div#example_paginate>span>a")).size();
		
		List<String> names= new ArrayList<String>();
		
		for(int i=1 ; i<=pageMaxSize; i++)
		{
			String pageselector = "div#example_paginate>span>a:nth-child(" + i +")";
			driver.findElement(By.cssSelector(pageselector)).click();
			List<WebElement> elementNames = driver.findElements(By.cssSelector("table#example >tbody >tr >td:nth-child(1)"));
			
			for(WebElement elementName : elementNames)
			{
				names.add(elementName.getText());
			}
		}
		
		for(String name : names)
		{
			System.out.println(name);
		}
		
		int totalNames =names.size();
		System.out.println("Total no.of Names : " + totalNames);
		
		String displayedCount= driver.findElement(By.cssSelector("div#example_info")).getText().split(" ")[5];
		
		System.out.println("Total Number f Displated NAmes Count : " + displayedCount);
		
		Assert.assertEquals(displayedCount, String.valueOf(totalNames));
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
