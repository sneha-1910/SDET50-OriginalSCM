package com_scm_Practice_TESTNG;


import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ObjectRepository_POM.AdminloginPage;
import com.ObjectRepository_POM.Retailer_HomePage;
import com.ObjectRepository_POM.admin_addR_addM_addD_Page;
import com.crm.GenericUtility.BaseClass_TESTNG;

public class Project_Integration_Admin_Addretiler_Test extends BaseClass_TESTNG {


	@Test(retryAnalyzer = com.crm.GenericUtility.RetryImplemenClass.class)
	public void Add_Retailer() throws Throwable
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
			 
 admin_addR_addM_addD_Page rmd=new admin_addR_addM_addD_Page(driver);
 rmd.ClickAndEnterAddretailerDetails(eLib.getMultipleDataFromExcelWithoutRandom("addretailer", 0, 1), driver, "SRKJ (Sarkhej)");

 Reporter.log("retailer added",true);
 
 Retailer_HomePage rh=new Retailer_HomePage(driver);
 rh.Retailer_Logout();
 
	}
	
	
	
}
