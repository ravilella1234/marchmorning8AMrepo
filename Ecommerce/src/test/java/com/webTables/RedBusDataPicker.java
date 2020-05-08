package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class RedBusDataPicker {
	
	static String month;
	static WebDriver driver;
	

	public static void main(String[] args) throws Exception
	{
		String myDate="5-May 2020";
		String[] strarr = myDate.split("-");
		String startDate=strarr[0];
		String startMonth=strarr[1];
		
		System.out.println(startDate + " ----" + startMonth);
		

		System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Desktop\\drive\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
		
		Thread.sleep(4000);
		WebElement dt = driver.findElement(By.xpath("//input[@id='onward_cal']"));
		Actions a=new Actions(driver);
		a.click(dt).perform();
		
		getMonth(startDate, startMonth);
		
		
	}
	
	public static void getMonth(String sDate,String sMonth)
	{
		month = driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]")).getText();
		//System.out.println(month);
		
		if(!month.equals(sMonth))
			driver.findElement(By.xpath("//div[@id='rb-calendar_onward_cal']//button[contains(text(),'>')]")).click();
		getMonth(sDate, sMonth);
	}
	

}
