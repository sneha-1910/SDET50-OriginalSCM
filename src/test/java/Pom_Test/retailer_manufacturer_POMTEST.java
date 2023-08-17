package Pom_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ObjectRepository_POM.Manufa_ManageStock_Invoice_Order_PAGE;
import com.ObjectRepository_POM.Manufacturer_LoginPage;
import com.ObjectRepository_POM.Retailer_HomePage;
import com.ObjectRepository_POM.Retailer_LoginPage;
import com.ObjectRepository_POM.Validate_AddRetailer_Page;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;
import com.crm.GenericUtility.excelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class retailer_manufacturer_POMTEST {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 FileUtility fLib=new FileUtility();
         excelUtility eLib = new excelUtility();
         JavaUtility jLib=new JavaUtility();
         WebDriverUtility wLib=new WebDriverUtility();
         
         String URL  =fLib.readDataFromPropertyFile("url1");
         String BROWSER  =fLib.readDataFromPropertyFile("browser1");
         String USERNAME  =fLib.readDataFromPropertyFile("username3");
         String PASSWORD =fLib.readDataFromPropertyFile("password3");
         String LOGINTYPE =fLib.readDataFromPropertyFile("logintype3");  
         

         String page= eLib.readDataFromExcel("retailer", 1, 0);
 		System.out.println(page);	
 			 
 			WebDriver driver;
 			if(BROWSER.equalsIgnoreCase("chrome"))
 			{
 				WebDriverManager.chromedriver().setup();
 				driver=new ChromeDriver();
 			}
 			else 
 			{
 				WebDriverManager.firefoxdriver().setup();
 				driver=new FirefoxDriver();
 			}
 			
 			wLib.maximizeWindow(driver);
 		     driver.get(URL);
 		
 			wLib.waitforPageLoad(driver);
 		
 			
 			Retailer_LoginPage rlp=new Retailer_LoginPage(driver);
 			rlp.Retailer_Login(USERNAME, PASSWORD, LOGINTYPE);
 			
 			Validate_AddRetailer_Page vap=new Validate_AddRetailer_Page(driver);
 			vap.POST_ORDER_TAB(2, 4, page);
 			Thread.sleep(2000);
 			
 			
 			Retailer_HomePage rh=new Retailer_HomePage(driver);
 			rh.Retailer_Logout();
         
         //login as manufacturer
 			FileUtility fLib1=new FileUtility();
 	        excelUtility eLib1 = new excelUtility();
 	        JavaUtility jLib1=new JavaUtility();
 	        WebDriverUtility wLib1=new WebDriverUtility();
 	        
 	        String URL1= fLib1.readDataFromPropertyFile("url1");
 	        String BROWSER1= fLib1.readDataFromPropertyFile("browser1");
 	        String USERNAME1= fLib1.readDataFromPropertyFile("username2");
 	        String PASSWORD1= fLib1.readDataFromPropertyFile("password2");
 	        String LOGINTYPE1= fLib1.readDataFromPropertyFile("loginType2");
 	        
 	       WebDriverManager.firefoxdriver().setup();
 	    	
 	    	FirefoxDriver driver1=new FirefoxDriver();
         
 	    	//driver.manage().window().maximize();
 	    	wLib.maximizeWindow(driver1);
 	    	
 	    	driver1.get(URL1);
 	    	
 	    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	    	wLib.waitforPageLoad(driver1);
 	    	
 	    	Manufacturer_LoginPage mlp=new Manufacturer_LoginPage(driver1);
 	    	mlp.ManufacturerLoginPage(USERNAME, PASSWORD, LOGINTYPE);
 	 
 	    	Manufa_ManageStock_Invoice_Order_PAGE mnv=new Manufa_ManageStock_Invoice_Order_PAGE(driver);
 	    	mnv.manuf_Orders();
 	    	String text = eLib.readDataFromExcel("manufacturer", 1, 0);
 	    	mnv.manu_val_order(text);
 	    	
 	         
	}

}
