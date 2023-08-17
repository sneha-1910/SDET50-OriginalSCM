package com_scm_Practice_TESTNG;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ObjectRepository_POM.Manuf_HomePage;
import com.ObjectRepository_POM.Manufacturer_LoginPage;
import com.crm.GenericUtility.BaseClass_TESTNG;

public class Project_System_manuf_Invoice_Test extends BaseClass_TESTNG {

	@Test
	public void Manuf_Invoice() throws Throwable
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
	    	 
//	    	 String sear="Invoice Id";
//	     	String Id="2";
	     	Manuf_HomePage mvh=new Manuf_HomePage(driver);
	     	mvh.InvoiceSearch("Invoice Id", "2");
	     	
	     	String generate= eLib.readDataFromExcel("invoices", 1, 0);
	     	mvh.ValidateInVoiceByID(generate);
	     	
	     	mvh.Manuf_Logout();
		 
	}
	
	
	
}
