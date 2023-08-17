package com.scm_Practice;

import org.testng.annotations.Test;

public class TestNGTest {

	@Test(priority = 2)
	public void createDataTest()
	{
		System.out.println("--- created data ------");
	}
	
	@Test(priority = 1, dependsOnMethods = "createDataTest")
	public void editTest()
	{
		System.out.println("--- Edited data ----");
	}
	
	@Test(priority = 3)
	public void deleteTest()
	{
		System.out.println("--- Deleted data");
	}
}
