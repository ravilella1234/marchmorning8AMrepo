package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.Ecommerce.BaseTest;

public class FaceBook extends BaseTest
{

	public static void main(String[] args) throws Exception 
	{
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		
		ExcelAPI e=new ExcelAPI("C:\\Users\\DELL\\Desktop\\testdata.xlsx");
		
		for(int i=1;i<e.getRowCount("login");i++)
		{
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(e.getCellData("login", "UserName", i));
			
			driver.findElement(By.id("pass")).clear();
			driver.findElement(By.id("pass")).sendKeys(e.getCellData("login", "Password", i));
			
			Thread.sleep(2000);
		}
		
		
		
		

	}

}
