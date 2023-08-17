package com_scm_Practice_TESTNG;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository_POM.Retailer_HomePage;
import com.ObjectRepository_POM.Retailer_LoginPage;
import com.ObjectRepository_POM.Validate_AddRetailer_Page;
import com.crm.GenericUtility.BaseClass_TESTNG;

@Listeners(com.crm.GenericUtility.iListernerImplement_ExtendReport_Class.class)
public class Project_System_Retiler_Order extends BaseClass_TESTNG {

	@Test
	public void RetilerNewOrder() throws Throwable
	{
		String URL = fLib.readDataFromPropertyFile("url1");
		 String USERNAME = fLib.readDataFromPropertyFile("username3");
		 String PASSWORD = fLib.readDataFromPropertyFile("password3");
		 String LOGINTYPE = fLib.readDataFromPropertyFile("loginType3");
		 driver.get(URL);
		 wLib.waitforPageLoad(driver);
		 
		 Retailer_LoginPage rlp=new Retailer_LoginPage(driver);
			rlp.Retailer_Login(USERNAME, PASSWORD, LOGINTYPE);
		 
		 String page= eLib.readDataFromExcel("retailer", 1, 0);
		 Validate_AddRetailer_Page vap=new Validate_AddRetailer_Page(driver);
			vap.POST_ORDER_TAB(2, 4, page);
			
		    Assert.fail();
			Retailer_HomePage rh=new Retailer_HomePage(driver);
			rh.Retailer_Logout();
	}
	
	
	
	
}
