package com.webTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Table2 
{
	public static WebDriver driver;
	public static WebDriverWait wait ;
		
	
	public static void selectDate(String day, String year) throws Exception
	{
		 wait=new WebDriverWait(driver, 60);
		List<WebElement> elements = driver.findElements(By.cssSelector("div[class='rsdc-months'] span[class='rsdc-month'] > span:first-child"));
		for(int i=0;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
			if(elements.get(i).getText().equals(year))
			{
				List<WebElement> days = driver.findElements(By.xpath("//div[@class='rsdc-months']/span["+ (i+1)+ "]/span"));
				for(WebElement d : days) 
				{
					if(d.getText().equals(day))
					{
						d.click();
						return;
					}
				}
			}
		}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='rsdc-next rsdc-nav ui_icon single-chevron-right-circle']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='rsdc-next rsdc-nav ui_icon single-chevron-right-circle']"))).click();
		
		Thread.sleep(2000);
		selectDate(day, year);
	}
	

	public static void main(String[] args) throws Exception 
	{
		driver = new ChromeDriver();
		wait=new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("https://www.tripadvisor.in/");
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[title='Flights']"))).click();
		
		
		//CheckIn
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-datetype='DEPARTURE'] span[class='picker-label target']"))).click();
		String date="4-Jul 2020";
		String splitter1[] = date.split("-");
		String checkInDay = splitter1[0];
		String checkInMonth = splitter1[1];
		selectDate(checkInDay, checkInMonth);
		
		//CheckOut
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span[data-datetype='RETURN'] span[class='picker-label target']"))).click();
		String date1="8-Sep 2020";
		String splitter2[]=date1.split("-");
		String checkOutday=splitter2[0];
		String checkOutMonth =splitter2[1];
		selectDate(checkOutday, checkOutMonth);
	}

}
