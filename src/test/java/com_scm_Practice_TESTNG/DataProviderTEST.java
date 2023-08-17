package com_scm_Practice_TESTNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTEST {

	@Test(dataProvider= "data")
	public void getData(String src,String dst)  
	{
	
      System.out.println("From---->"+src+   "To----->"+dst);
     
	}
       @DataProvider
       public Object[][] data()
       {
    	  Object[][] obj=new Object[2][2];
    	  
    	  obj[0][0]="Belgaum";
    	  obj[0][1]="Gokak";
    	  
    	  obj[1][0]="Pune";
    	  obj[1][1]="Mumbai";
    	  return obj;
       }
}
