package com.project.Keywords;

import java.util.Hashtable;
import java.util.Properties;

public class GenericKeywords 
{
	public  Properties childProperties; 
	public  Properties orProp;
	public String objectKey;
	public String dataKey;
	public Hashtable<String, String> data;
	
	

	public void setChildProperties(Properties childProperties) {
		this.childProperties = childProperties;
	}

	public void setOrProp(Properties orProp) {
		this.orProp = orProp;
	}

	public void setObjectKey(String objectKey) {
		this.objectKey = objectKey;
	}

	public void setDataKey(String dataKey) {
		this.dataKey = dataKey;
	}

	public void setData(Hashtable<String, String> data) {
		this.data = data;
	}

	public void openBrowser()
	{
		System.out.println("Opening the Browser....." + data.get(dataKey));
	}
	
	public void navigateUrl()
	{
		System.out.println("Navigating to website....." +objectKey);
	}
	
	public void click()
	{
		System.out.println("Clicking the element....."+orProp.getProperty(objectKey));
	}
	
	public void type()
	{
		System.out.println("Typing the Text......." + orProp.getProperty(objectKey) + "-----" + data.get(dataKey));
	}

}
