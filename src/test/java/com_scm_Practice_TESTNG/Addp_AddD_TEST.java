package com_scm_Practice_TESTNG;

import org.testng.annotations.Test;

import com.crm.GenericUtility.BaseClass_TESTNG;


     public class Addp_AddD_TEST extends BaseClass_TESTNG {

	@Test
	public void addp()
	{
		System.out.println("product is added");	
		
	}
	
	@Test 
	public void addD()
	{
		System.out.println("distributor is added");
	}
	
	@Test
	public void logout()
	{
		System.out.println("logout");
	}
}
