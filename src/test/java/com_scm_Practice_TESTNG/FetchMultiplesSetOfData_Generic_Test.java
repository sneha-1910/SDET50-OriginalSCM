package com_scm_Practice_TESTNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericUtility.excelUtility;

public class FetchMultiplesSetOfData_Generic_Test {

	@Test(dataProvider="ReadData")
	public void fetchData(String S_Id,String S_name,String S_branch,String S_place)
	{
		System.out.println("S_Id--"+S_Id+  "    S_name---"+S_name+  "    S_branch ---"+S_branch+  "   S_place--- "+S_place);    
	}
	
	
	@DataProvider
	public Object[][] ReadData() throws Throwable
	{
		excelUtility eLib=new excelUtility();
		Object[][] value = eLib.DataProviderMultiplesetOfData("DataProvider");
		return value;
	}
	
}
