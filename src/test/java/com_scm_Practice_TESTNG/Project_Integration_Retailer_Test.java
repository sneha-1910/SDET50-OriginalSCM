package com_scm_Practice_TESTNG;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ObjectRepository_POM.Manufa_ManageStock_Invoice_Order_PAGE;
import com.ObjectRepository_POM.Manufacturer_LoginPage;
import com.ObjectRepository_POM.Retailer_HomePage;
import com.ObjectRepository_POM.Retailer_LoginPage;
import com.ObjectRepository_POM.Validate_AddRetailer_Page;
import com.crm.GenericUtility.BaseClass_TESTNG;

public class Project_Integration_Retailer_Test extends BaseClass_TESTNG {

	@Test
	public void Retailer_NewOrder() throws Throwable
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
			Retailer_HomePage rh=new Retailer_HomePage(driver);
 			rh.Retailer_Logout();
	}
	
	@Test
	public void manufaturer() throws Throwable
	{
		String URL = fLib.readDataFromPropertyFile("url1");
		 String USERNAME = fLib.readDataFromPropertyFile("username2");
		 String PASSWORD = fLib.readDataFromPropertyFile("password2");
		 String LOGINTYPE = fLib.readDataFromPropertyFile("loginType2");
		 driver.get(URL);
		 wLib.waitforPageLoad(driver);
		 
		 Manufacturer_LoginPage mlp=new Manufacturer_LoginPage(driver);
	   	mlp.ManufacturerLoginPage(USERNAME, PASSWORD, LOGINTYPE);
	   	 System.out.println("----login to Appln");
	     Assert.fail();
	 	Manufa_ManageStock_Invoice_Order_PAGE mnv=new Manufa_ManageStock_Invoice_Order_PAGE(driver);
	    	mnv.manuf_Orders();
	    	String text = eLib.readDataFromExcel("manufacturer", 1, 0);
	    	mnv.manu_val_order(text);
	
	
	}
	
	
	
}
