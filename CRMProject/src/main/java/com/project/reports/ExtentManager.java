package com.project.reports;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager
{
	private static ExtentReports extent;
	
	public static ExtentReports getInstance(String reportPath)
	{
		if(extent == null)
		{
			Date dt = new Date();
			String fileName = dt.toString().replace(':', '_').replace(' ', '_')+".html";
			System.out.println(reportPath + fileName);
			createInstance(reportPath + fileName);
		}
		
		return extent;
	}

	public static ExtentReports createInstance(String filePath)
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("HTML Reports");
		htmlReporter.config().setReportName("Report - Automation Testing.");
		
		extent  = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		return extent;
	}
	

}
