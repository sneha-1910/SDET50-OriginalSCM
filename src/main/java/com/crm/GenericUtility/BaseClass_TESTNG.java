package com.crm.GenericUtility;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass_TESTNG {

	public DataBaseUtility dLib =new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public excelUtility eLib=new excelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	public static  WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void Config_BS() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("----Conect to DB----");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
//	public void config_BC(String BROWSER) throws IOException 
	public void config_BC() throws IOException 
	{
		String BROWSER = fLib.readDataFromPropertyFile("browser1");
	
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{     
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
           sdriver=driver;
		System.out.println("----Launch the Broswer----");
		wLib.maximizeWindow(driver);
		}
	
 @BeforeMethod(alwaysRun = true)
	 public void cofig_BM()
	 {
		
	 System.out.println("login to application");
		 }
	 @AfterMethod(alwaysRun = true)
	 public void Config_AM()
	 {    
		System.out.println("logout from application");
	 }
	 
	
	 @AfterClass(alwaysRun = true)
	 public void Config_AC()
	 {
		 driver.quit();
		 System.out.println("----Close the Browser----");
	 }
	 
	 @AfterSuite(alwaysRun = true)
	 public void Config_AS() throws Throwable 
	 {
		 dLib.closeDB();
		 System.out.println("---- Close DB----0");
		 
	 }
	 
	 
}
