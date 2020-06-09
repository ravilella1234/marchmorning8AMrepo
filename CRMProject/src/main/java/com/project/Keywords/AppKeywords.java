package com.project.Keywords;

public class AppKeywords extends GenericKeywords
{
	public void validateLogin()
	{
		System.out.println("Valdating Login......");
	}

	public void verifyTitle() 
	{
		
		System.out.println("Verified title..." + orProp.getProperty(objectKey));
		String expectedTitle =  orProp.getProperty(objectKey);
		String actualTitle = driver.getTitle();
		if(!expectedTitle.equals(actualTitle))
		{
			//Report the failure
		}
		
	}

}
