package com.webTables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table5 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		String text = driver.findElement(By.xpath("//div[@id='leftcontainer']/table/tbody/tr[7]/td[4]")).getText();
		System.out.println(text);
		
		String text1 = driver.findElement(By.xpath("//a[contains(text(),'Titan Securities')]/parent::*/following-sibling::td[3]")).getText();
		System.out.println(text1);
	}

}
