package com.project.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.project.DriverProgrames.DriverScript;
import com.project.Utilities.ExcelAPI;
import com.project.reports.ExtentManager;

public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public  Properties baseProperties;
	public  Properties childProperties; 
	public  Properties orProp;
	public static ExcelAPI xls;
	public String testName=null;
	public DriverScript ds;
	public static ExtentReports rep;
	public  ExtentTest test;
	
	@BeforeTest
	public void init() throws Exception
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
		
		fis = new FileInputStream(projectPath + "//src//test//resources//or.properties") ;
		orProp = new Properties();
		orProp.load(fis);
		
		//init the TestName
		testName = this.getClass().getSimpleName();
		System.out.println(testName);
		
		
		//How do i come to know which suite Excel file to load
		String[] pack = this.getClass().getPackage().getName().split("\\.");
		String suiteName = pack[pack.length-1];
		System.out.println(suiteName);
		
		//init the xls file
		xls = new ExcelAPI(childProperties.getProperty(suiteName+"_xls"));
		
		//init DriverScript Object
		ds= new DriverScript();
		ds.setOrProp(orProp);
	
	}
	
	
	@BeforeMethod
	public void initMethod()
	{
		System.out.println("iam Before Method.....");
		
		rep = ExtentManager.getInstance(baseProperties.getProperty("reportPath"));
		test = rep.createTest(testName);
		ds.setTest(test);
	}
	
	@AfterMethod
	public void quit()
	{
		System.out.println("iam After Method.....");
		if(ds!=null)
			ds.quit();
		
		if(rep!=null)
			rep.flush();
	}

}
