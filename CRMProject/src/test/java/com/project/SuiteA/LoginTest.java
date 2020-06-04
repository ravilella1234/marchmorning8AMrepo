package com.project.SuiteA;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;
import com.project.Utilities.DataUtils;

public class LoginTest extends BaseTest
{
	
  @Test(dataProvider = "getData")
  public void loginTest(Hashtable<String, String> data) throws Exception 
  {
	  System.out.println("iam logintest....");
	  
	  if(data.get("Rumode").equals("N"))
		  throw new SkipException("Runmode is set to NO...");
	  
	  //ds = new DriverScript();
	  ds.executeKeywords(xls, testName, data);
  }
  
  @DataProvider
  public Object[][] getData()
  {
	  
	  System.out.println("iam dataProvider.....");
	  //String testName="LoginTest";
	  String sheetName="Data";
	  
	return DataUtils.getTestData(xls, sheetName, testName);
	  
  }
  
  
  
}
