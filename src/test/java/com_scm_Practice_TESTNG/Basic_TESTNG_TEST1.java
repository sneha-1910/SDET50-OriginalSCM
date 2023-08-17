package com_scm_Practice_TESTNG;

import org.junit.Ignore;
import org.testng.annotations.Test;

public class Basic_TESTNG_TEST1 {

	@Ignore
	public void Createdata()
	{
		
		System.out.println("-----create data------");
	}

	@Test(priority=1)
	public void EditData()
	{
		int[]a= {1,2,3,4};
		System.out.println("----edit data---- "+a[6]);
	}
	
	@Test(dependsOnMethods = "EditData")
	public void DeleteData() 
	{
		System.out.println("-----delete data-----");
	}
	
	}


