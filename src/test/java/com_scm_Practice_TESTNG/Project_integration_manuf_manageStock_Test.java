package com_scm_Practice_TESTNG;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ObjectRepository_POM.Manuf_HomePage;
import com.ObjectRepository_POM.Manufa_ManageStock_Invoice_Order_PAGE;
import com.ObjectRepository_POM.Manufacturer_LoginPage;
import com.crm.GenericUtility.BaseClass_TESTNG;

public class Project_integration_manuf_manageStock_Test extends BaseClass_TESTNG{

	
	@Test
	public void manuf_manageStock() throws Throwable
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
   	 
   	Manufa_ManageStock_Invoice_Order_PAGE mio=new Manufa_ManageStock_Invoice_Order_PAGE(driver);
	mio.Manuf_Manage_Stock(driver, 46,"Pizza Sauce");
	Thread.sleep(2000);
	
	
	Manuf_HomePage mh=new Manuf_HomePage(driver);
	mh.Manuf_Logout();
	
	}
	
}
