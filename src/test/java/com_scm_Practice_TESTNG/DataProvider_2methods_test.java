package com_scm_Practice_TESTNG;

import org.testng.annotations.DataProvider;

 
public class DataProvider_2methods_test {	
	
	@DataProvider
	public Object[][] OneData()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="Belgaum";
  	    obj[0][1]="Gokak";
  	  
  	  obj[1][0]="Pune";
  	  obj[1][1]="Mumbai";
  	   return obj;
	}
	@DataProvider
	public Object[][] SecondData()
	{
		Object[][] obj=new Object[2][3];
		obj[0][0]="sneha";
		obj[0][1]="Sonu";
		obj[0][2]="Sne";
		
		obj[1][0]="Pa";
		obj[1][1]="ru";
		obj[1][2]="She";
		return obj;
	
				
	}
	
	
	
}
