package com.project.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.project.Utilities.ExcelAPI;

public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties baseProperties;
	public static Properties childProperties; 
	public static ExcelAPI xls;
	
	@BeforeTest
	public static void init() throws Exception
	{
		System.out.println("iam before Test.....");
		
		fis = new FileInputStream(projectPath+"//src//test//resources//environment.properties");
		baseProperties = new Properties();
		baseProperties.load(fis);
		String envType = baseProperties.getProperty("env");
		System.out.println(envType);
		
		fis = new FileInputStream(projectPath + "//src//test//resources//" + envType + ".properties");
		childProperties = new Properties();
		childProperties.load(fis);
		String url = childProperties.getProperty("zohourl");
		System.out.println(url);
		
		//init the xls file
		//How do i come to know which suitex Excel file to load
		xls = new ExcelAPI(childProperties.getProperty("SuiteA_xls"));
	}

}
