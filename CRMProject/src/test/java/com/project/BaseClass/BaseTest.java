package com.project.BaseClass;

import java.io.FileInputStream;
import java.util.Properties;

public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static FileInputStream fis;
	public static Properties baseProperties;
	public static Properties childProperties; 
	
	public static void init() throws Exception
	{
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
	}

}
