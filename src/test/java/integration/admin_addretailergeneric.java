 package integration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;
import com.crm.GenericUtility.excelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class admin_addretailergeneric {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 FileUtility fLib=new FileUtility();
         excelUtility eLib = new excelUtility();
         JavaUtility jLib=new JavaUtility();
         WebDriverUtility wLib=new WebDriverUtility();
 		
 		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\admincredentials.properties");
 		Properties pobj = new Properties();
 		pobj.load(fis);
 		
 	String URL = pobj.getProperty("url");
 	String BROWSER = pobj.getProperty("browser");
 	String USERNAME = pobj.getProperty("username");
 	String PASSWORD = pobj.getProperty("password");*/
         
         String URL  =fLib.readDataFromPropertyFile("url1");
         String BROWSER  =fLib.readDataFromPropertyFile("browser1");
         String USERNAME  =fLib.readDataFromPropertyFile("username1");
         String PASSWORD =fLib.readDataFromPropertyFile("password1");
 	
 	
 /*	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
 	Workbook book = WorkbookFactory.create(fi);
      Sheet sh = book.getSheet("addretailer");
      int count=sh.getLastRowNum();
      System.out.println(count);*/
         
         int count =eLib.getLastRowNo("addretailer");
         System.out.println(count);
      
      
      WebDriver driver;
     if(BROWSER.equalsIgnoreCase("chrome")) {
     	WebDriverManager.chromedriver().setup();
     	driver=new ChromeDriver();
     }
     else
     {
     	WebDriverManager.firefoxdriver().setup();
     	driver=new FirefoxDriver();
     }
 	
 	
 	//driver.manage().window().maximize();
 	 wLib.maximizeWindow(driver);
     
 	driver.get(URL);
 	
 	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	wLib.waitforPageLoad(driver);
 	
 	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
 	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
 	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
 	// Select sal=new Select(dropdown);
 	 //sal.selectByVisibleText("Admin");
 	
 	wLib.select("Admin", dropdown);
 	 driver.findElement(By.xpath("//input[@type='submit']")).click();
 	

 	 WebElement ele = driver.findElement(By.linkText("Add Retailers"));
 	// Actions a=new Actions(driver);
 	 //a.moveToElement(ele).click().perform();
 	 
 	 wLib.mousehover(driver, ele);
 	 
 	 //by using map
 	/* HashedMap<String, String> map = new HashedMap<String, String>();
 	 
 	 // get the data from excel and store it in map
 	 for(int i=0;i<=count;i++)
 	 {
 		 String key = sh.getRow(i).getCell(0).toString();
 		 System.out.println(key);
 		 String value = sh.getRow(i).getCell(1).toString();
 		 System.out.println(value);
 		 map.put(key, value);
 	 }
 	 
 	 for(Entry<String, String> set:map.entrySet())
 	 {
 		 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
 	 }*/
 	 
 	 eLib.getMultipleDataFromExcel("addretailer", 0, 1, driver);
 	 
 	 
 	WebElement ele1=driver.findElement(By.xpath("//select[@name='cmbAreaCode']"));
 	// Select sal1=new Select(ele1);
 	// sal1.selectByVisibleText("SRKJ (Sarkhej)");
 	//generic for select
 	wLib.select("SRKJ (Sarkhej)", ele1);
 	 
 	
 	 
 	//driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
 	 
 	
 	 Alert a1=driver.switchTo().alert();
 	 String cfm = a1.getText();
 	 System.out.println(cfm);
 	 a1.accept();
 	
 	 
 	//logout
 		 Thread.sleep(2000);
 		 driver.findElement(By.xpath("//input[@value='Log out']")).click();

 		
 		driver.close();
	}

}
