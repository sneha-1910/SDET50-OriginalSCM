package com_scm_Practice_TESTNG;

import org.testng.annotations.Test;

public class FetchData {
       
	@Test(dataProviderClass=DataProviderTEST.class,dataProvider="data")
     public void getData(String src,String dst)
     {
		System.out.println("From--->"+src+   " To---->"+dst);
	}
	
 
}
