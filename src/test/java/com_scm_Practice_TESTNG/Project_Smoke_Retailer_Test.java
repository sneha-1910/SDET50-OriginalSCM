package com_scm_Practice_TESTNG;


import org.testng.annotations.Test;

import com.ObjectRepository_POM.Retailer_LoginPage;
import com.ObjectRepository_POM.Validate_AddRetailer_Page;

import com.crm.GenericUtility.BaseClass_TESTNG;



public class Project_Smoke_Retailer_Test extends BaseClass_TESTNG{


	
	@Test(groups = "smoke")
	public void retailer() throws Throwable
	{
		String URL = fLib.readDataFromPropertyFile("url1");
		 String USERNAME = fLib.readDataFromPropertyFile("username3");
		 String PASSWORD = fLib.readDataFromPropertyFile("password3");
		 String LOGINTYPE = fLib.readDataFromPropertyFile("loginType3");
		 driver.get(URL);
		 wLib.waitforPageLoad(driver);
		 
		 Retailer_LoginPage rlp=new Retailer_LoginPage(driver);
			rlp.Retailer_Login(USERNAME, PASSWORD, LOGINTYPE);
			
		 String Text = eLib.readDataFromExcel("retailer", 1, 0);
		Validate_AddRetailer_Page vap=new Validate_AddRetailer_Page(driver);
		vap.My_Orders_Tab();
		vap.validate_MY_ORDER(Text);
		
		
	}
	
	}

