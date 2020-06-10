package com.project.Utilities;

import java.util.Hashtable;



public class DataUtils
{
	public static Object[][] getTestData(ExcelAPI xls,String sheetName,String testName)
	{
		//String sheetName="data";
		//String testCaseName="TestB";
		
		int testStartRowNum=0;
		while(!xls.getCellData(sheetName, 0, testStartRowNum).equals(testName)) 
		{
			testStartRowNum++;
		}
		System.out.println("Test Starts from row :-  " + testStartRowNum);
		
		
		int colStartRowNum=testStartRowNum+1;
		int dataStartRowNum=testStartRowNum+2;
		
		//calculate rows of data
		int rows=0;
		while(!xls.getCellData(sheetName, 0, dataStartRowNum+rows).equals("")) 
		{
			rows++;
		}
		System.out.println("Total rows are :-  "+ rows);
		
		//Calculate total Columns
		int cols=0;
		while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")) 
		{
			cols++;
		}
		System.out.println("Total Cols are :-  "+ cols);
		
		
		//read the data
		int dataRow=0;
		Object[][] data=new Object[rows][1];
		
		Hashtable<String,String> table=null;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++)
		{
			table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++) 
			{
				//System.out.println(e.getCellData(sheetName, cNum, rNum));
				//data[dataRow][cNum]=e.getCellData(sheetName, cNum, rNum);
				String key=xls.getCellData(sheetName, cNum, colStartRowNum);
				String value=xls.getCellData(sheetName, cNum, rNum);
				table.put(key, value);
			}	
			data[dataRow][0]=table;
			dataRow++;
		}
		return data;	
	}
	
	
	//function to check the reunmode of test
	// true  - N
	//false  - Y
	
	public static boolean isSkip(String testName, ExcelAPI xls)
	{
		int rows = xls.getRowCount(Constants.TESTCASES_SHEET);
		for(int rNum=1;rNum<rows;rNum++)
		{
			String tcid = xls.getCellData(Constants.TESTCASES_SHEET, Constants.TCID_COL, rNum);
			if(tcid.equals(testName)) {
				String runmode = xls.getCellData(Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rNum);
				if(runmode.equals(Constants.RUNMODE_NO))
					return true;
				else
					return false;	
			}	
		}
		return true;
	}
}
