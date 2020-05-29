package com.project.DriverProgrames;

import java.util.Hashtable;

import com.project.Utilities.ExcelAPI;

public class DriverScript 
{
	public void executeKeywords(ExcelAPI xls, String testName, Hashtable<String, String> data)
	{
		System.out.println("iam driverScript classs");
		int rows = xls.getRowCount("Keyword");
		System.out.println("Rows : " + rows);
		
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcId = xls.getCellData("Keyword", "TCID", rNum);
			if(tcId.equals(testName))
			{
				String kWord = xls.getCellData("Keyword", "Keywords", rNum);
				String objectKey = xls.getCellData("Keyword", "Object", rNum);
				String dataKey = xls.getCellData("Keyword", "Data", rNum);
				
				System.out.println(tcId + "----" + kWord + "----" + objectKey + "----" + dataKey);
			}
			
		}
		
	}

}
