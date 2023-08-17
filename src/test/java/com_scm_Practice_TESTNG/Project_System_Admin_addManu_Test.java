package com_scm_Practice_TESTNG;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepository_POM.AdminloginPage;
import com.ObjectRepository_POM.admin_addR_addM_addD_Page;
import com.crm.GenericUtility.BaseClass_TESTNG;

public class Project_System_Admin_addManu_Test extends BaseClass_TESTNG {

	@Test
	public void add_manufacturee() throws Throwable
	{
		String URL = fLib.readDataFromPropertyFile("url1");
		 String USERNAME = fLib.readDataFromPropertyFile("username1");
		 String PASSWORD = fLib.readDataFromPropertyFile("password1");
		 String LOGINTYPE = fLib.readDataFromPropertyFile("loginType1");
		 driver.get(URL);
		 wLib.waitforPageLoad(driver);
		 
		 AdminloginPage alp=new AdminloginPage(driver);
		 alp.ClickOnAdminLogin(USERNAME, PASSWORD, LOGINTYPE);
			 System.out.println("----login to Appln");
			 
		admin_addR_addM_addD_Page ARMD=new admin_addR_addM_addD_Page(driver);
		ARMD.ManufacturerDetails(driver,eLib.getMultipleDataFromExcelWithoutRandom("addmanufact", 0, 1));
		Reporter.log("manuf",true);
		// ARMD.ConfirmationMSG(driver);
		
		
	}
	
	
	
}
