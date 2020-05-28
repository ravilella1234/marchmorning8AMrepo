package com.project.SuiteA;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.BaseClass.BaseTest;
import com.project.Utilities.DataUtils;

public class LoginTest extends BaseTest
{
	
  @Test(dataProvider = "getData")
  public void loginTest(Hashtable<String, String> data) 
  {
	  System.out.println("iam logintest....");
  }
  
  @DataProvider
  public Object[][] getData()
  {
	  
	  System.out.println("iam dataProvider.....");
	  String testName="LoginTest";
	  String sheetName="Data";
	  
	return DataUtils.getTestData(xls, sheetName, testName);
	  
  }
  
  
  
}
