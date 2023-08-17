package com_scm_Practice_TESTNG;

import org.testng.annotations.Test;

public class Fetch_Two_methodsTest {


	@Test(dataProviderClass=DataProvider_2methods_test.class,dataProvider="onedata")
	
	public void getdata1(String src,String dst ) 
    {
	System.out.println("From--->"+src+  "  To---->"+dst);
	}

	@Test(dataProviderClass=DataProvider_2methods_test.class, dataProvider="SecondData")
	
	public void getData2(String name,String nickname,String name2)
	{
		System.out.println("name:"+name+  "   nickname:"+nickname+  "  name2:"+name2);
	}
	
	
}
