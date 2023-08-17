package com_scm_Practice_TESTNG;



import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasicScript_TestNG_Test{

	

	@BeforeSuite
	public void Config_BS()
	{
		System.out.println("connect to DB");
	}
	
   @BeforeClass
   public void Cofig_BC()
   {
	   
     WebDriverManager.firefoxdriver().setup();
	WebDriver driver=new FirefoxDriver();
	   System.out.println("Launch the browser");
   }
	
   @BeforeMethod
   public void Config_BM()
   {
	 System.out.println("Login to appl");  
   }
   
   @Test
   public void retailer()
   { 
	   System.out.println("retailer added");
   }
  
   @Test
   public void Add_manu()
   {
	   System.out.println("manufac added");
   }
  
   
   @AfterMethod()
   public void Config_AM()
   {
	   System.out.println("Logout from the Appl");
   }
   
   @AfterClass
   public void config_AC()
   {   
	 
	  System.out.println("Close the broswer");
   }
   
   @AfterSuite
   public void Config_AS()
   {
	   System.out.println("close DB");
   }
   
   

}
