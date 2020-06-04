package com.project.DriverProgrames;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Properties;

import com.project.Keywords.AppKeywords;
import com.project.Utilities.ExcelAPI;

public class DriverScript 
{
	public  Properties childProperties; 
	public  Properties orProp;
	AppKeywords app;
	
	
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
	
	


	public void executeKeywords(ExcelAPI xls, String testName, Hashtable<String, String> testData) throws Exception, Exception
	{
		System.out.println("iam driverScript classs");
		int rows = xls.getRowCount("Keyword");
		System.out.println("Rows : " + rows);
		app = new AppKeywords();
		app.setOrProp(orProp);
		
		
	
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcId = xls.getCellData("Keyword", "TCID", rNum);
			if(tcId.equals(testName))
			{
				String kWord = xls.getCellData("Keyword", "Keywords", rNum);
				String objectKey = xls.getCellData("Keyword", "Object", rNum);
				String dataKey = xls.getCellData("Keyword", "Data", rNum);
				String data = testData.get(dataKey);
				
				//System.out.println(tcId + "----" + kWord + "----" + orProp.getProperty(objectKey) + "----" + data);
				
				app.setObjectKey(objectKey);
				app.setDataKey(dataKey);
				app.setData(testData);
				app.setChildProperties(childProperties);
				
				
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
