package com.webTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table1 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement> tr_collection = driver.findElements(By.cssSelector("div[class='w3-white w3-padding notranslate w3-padding-16'] table tr"));
		for(WebElement trElement : tr_collection)
		{
			List<WebElement> td_collection = trElement.findElements(By.tagName("td"));
			for(WebElement td_Element : td_collection)
			{
				if(td_Element.getText().contains("Helen Bennett"))
				System.out.println(td_Element.getText());
			}
		}
		

	}

}
