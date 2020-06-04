package com.project.DriverProgrames;

import java.lang.reflect.Method;

public class ReflectDemo 
{

	public static void sampleTest()
	{
		System.out.println("iam sample Test......");
	}
	
	public static void sampleTest1()
	{
		System.out.println("iam sample Test1......");
	}
	
	
	
	public static void main(String[] args) throws  Exception 
	{
		String str= "sampleTest1";
		
		//if(str.equals("sampleTest"));
			//sampleTest();
			
		ReflectDemo api = new ReflectDemo();
		Method m = api.getClass().getMethod(str);
		m.invoke(m);

	}

}
