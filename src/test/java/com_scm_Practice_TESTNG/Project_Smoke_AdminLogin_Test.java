package com_scm_Practice_TESTNG;


import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepository_POM.AdminloginPage;
import com.ObjectRepository_POM.Validate_HomePage;
import com.crm.GenericUtility.BaseClass_TESTNG;

//@Listeners(com.crm.GenericUtility.itListenerImplemenClass.class)

public class Project_Smoke_AdminLogin_Test extends BaseClass_TESTNG{



 
//validation
	
	@Test(groups = "smoke")
	public void validation() throws InterruptedException, Throwable
	{ String URL = fLib.readDataFromPropertyFile("url1");
	 String USERNAME = fLib.readDataFromPropertyFile("username1");
	 String PASSWORD = fLib.readDataFromPropertyFile("password1");
	 String LOGINTYPE = fLib.readDataFromPropertyFile("loginType1");
	 driver.get(URL);
	 wLib.waitforPageLoad(driver);
	 
	 AdminloginPage alp=new AdminloginPage(driver);
	 alp.ClickOnAdminLogin(USERNAME, PASSWORD, LOGINTYPE);
		 System.out.println("----login to Appln");
		 
		String Welcome="Welcome Admin";
		Validate_HomePage vh=new Validate_HomePage(driver);
		vh.Validate(Welcome);
		Thread.sleep(2000);
		
	}

}
