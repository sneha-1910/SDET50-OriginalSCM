package com_scm_Practice_TESTNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.Test;

import com.ObjectRepository_POM.AdminloginPage;
import com.ObjectRepository_POM.admin_addR_addM_addD_Page;
import com.crm.GenericUtility.BaseClass_TESTNG;
import com.crm.GenericUtility.FileUtility;


public class Project_Smoke_Adminadd_distributor_Test extends BaseClass_TESTNG {
	
	
	@Test(groups = "smoke")
	public void loginDistributor() throws IOException
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

admin_addR_addM_addD_Page armd=new admin_addR_addM_addD_Page(driver);
armd.Distributor(driver);
String distributor="";
armd.ValidateDistributorTab(distributor);

	}
}
