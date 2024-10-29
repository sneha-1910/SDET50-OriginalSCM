package com_scm_Practice_TESTNG;

import org.testng.annotations.Test;

public class Basic_TESTNG_TEST1 {

	@Test()
	public void createdata()
	{
		System.out.println("-----create data------");
	}

	@Test()
	public void EditData()
	{
		int[]a= {1,2,3,4};
		System.out.println("----edit data---- "+a[6]);
	}
	
	@Test(invocationCount = 3)
	public void DeleteData() 
	{
		System.out.println("-----delete data-----");
	}
	
	}


