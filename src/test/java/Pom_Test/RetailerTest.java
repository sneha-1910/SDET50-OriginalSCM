package Pom_Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ObjectRepository_POM.Retailer_HomePage;
import com.ObjectRepository_POM.Retailer_LoginPage;
import com.ObjectRepository_POM.Validate_AddRetailer_Page;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;
import com.crm.GenericUtility.excelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetailerTest {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib=new FileUtility();
        excelUtility eLib = new excelUtility();
        JavaUtility jLib=new JavaUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        
        String URL  =fLib.readDataFromPropertyFile("url1");
        String BROWSER  =fLib.readDataFromPropertyFile("browser1");
        String USERNAME  =fLib.readDataFromPropertyFile("username3");
        String PASSWORD =fLib.readDataFromPropertyFile("password3");
        String LOGINTYPE =fLib.readDataFromPropertyFile("loginType3");    
			
	
        
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
			

			driver.close();
	}


}
