package com.project.DriverProgrames;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.project.Keywords.AppKeywords;
import com.project.Utilities.Constants;
import com.project.Utilities.ExcelAPI;

public class DriverScript 
{
	public  Properties childProperties; 
	public  Properties orProp;
	AppKeywords app;
	public ExtentTest test;
	
	
	public void setTest(ExtentTest test) {
		this.test = test;
	}

	public Properties getChildProperties() {
		return childProperties;
	}

	public void setChildProperties(Properties childProperties) {
		this.childProperties = childProperties;
	}

	public  Properties getOrProp() {
		return orProp;
	}

	public  void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}
	
	public void quit()
	{
		if(app!=null)
			app.quit();
	}


	public void executeKeywords(ExcelAPI xls, String testName, Hashtable<String, String> testData) throws Exception, Exception
	{
		System.out.println("iam driverScript classs");
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		System.out.println("Rows : " + rows);
		app = new AppKeywords();
		app.setOrProp(orProp);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcId = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.TCID_COL, rNum);
			if(tcId.equals(testName))
			{
				String kWord = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.KEYWORD_COL, rNum);
				String objectKey = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.OBJECT_COL, rNum);
				String dataKey = xls.getCellData(Constants.KEYWORDS_SHEET, Constants.DATA_COL, rNum);
				String data = testData.get(dataKey);
				
				//System.out.println(tcId + "----" + kWord + "----" + orProp.getProperty(objectKey) + "----" + data);
				//test.log(Status.INFO, tcId + "----" + kWord + "----" + orProp.getProperty(objectKey) + "----" + data);
				app.setObjectKey(objectKey);
				app.setDataKey(dataKey);
				app.setData(testData);
				app.setChildProperties(childProperties);
				app.setTest(test);
				
				/*
				 * if(kWord.equals("openBrowser")) app.openBrowser(); else
				 * if(kWord.equals("navigateUrl")) app.navigateUrl(); else
				 * if(kWord.equals("click")) app.click(); else if(kWord.equals("type"))
				 * app.type(); else if(kWord.equals("validateLogin")) app.validateLogin(); else
				 * if(kWord.equals("verifyTitle")) app.verifyTitle();
				 */
				
				//Replection API
				Method method;
				try 
				{
					method = app.getClass().getMethod(kWord);
					method.invoke(app);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				
			}
			
		}
		
	}

}
