package integration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
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

public class reatiler_manufacturerGeneric {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\retailercredentials.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		
			String URL = pobj.getProperty("url");
			String BROWSER = pobj.getProperty("browser");
			String USERNAME = pobj.getProperty("username");
			String PASSWORD = pobj.getProperty("password");*/
		 FileUtility fLib=new FileUtility();
         excelUtility eLib = new excelUtility();
         JavaUtility jLib=new JavaUtility();
         WebDriverUtility wLib=new WebDriverUtility();
         
         String URL  =fLib.readDataFromPropertyFile("url1");
         String BROWSER  =fLib.readDataFromPropertyFile("browser1");
         String USERNAME  =fLib.readDataFromPropertyFile("username3");
         String PASSWORD =fLib.readDataFromPropertyFile("password3");

			
		/*	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
			Workbook book = WorkbookFactory.create(fi);
			String page = book.getSheet("retailer").getRow(1).getCell(0).getStringCellValue();
			System.out.println(page);*/
         String page= eLib.readDataFromExcel("retailer", 1, 0);
			
			 
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
			//driver.manage().window().maximize();
			wLib.maximizeWindow(driver);
			driver.get(URL);
			
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wLib.waitforPageLoad(driver);
			driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
			// Select sal=new Select(dropdown);
			// sal.selectByVisibleText("Retailer");
			
			wLib.select("Retailer", dropdown);
			 driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			
			WebElement ret = driver.findElement(By.linkText("New Order"));
			//Actions a=new Actions(driver);
			//a.moveToElement(ret).click().perform();
			
			wLib.mousehover(driver, ret);
			
			driver.findElement(By.xpath("//input[@name='txtQuantity1']")).sendKeys("6");
			driver.findElement(By.xpath("//input[@name='txtQuantity2']")).sendKeys("8");
			driver.findElement(By.xpath("//input[@value='Post Order']")).click();
			
			String actual = driver.findElement(By.xpath("//h1[text()='My Orders']")).getText();
			
			if(actual.contains(page))
			{
				System.out.println("the details of the order posted by retailer is displayed");
			}
			else {
				System.out.println("the details of the order posted by retailer is not displayed");
			}
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@value='Log out']")).click();
			

			
			// login as manufacturer
			
            FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\manufacturercredentials.properties");
               Properties pobj1=new Properties();
                pobj1.load(fis1);
                
            	String URL1 = pobj1.getProperty("url");
    			String BROWSER1 = pobj1.getProperty("browser");
    			String USERNAME1 = pobj1.getProperty("username");
    			String PASSWORD1 = pobj1.getProperty("password");
    			
               System.out.println(USERNAME1+""+PASSWORD1);
       
    			 driver.get(URL1); 
    			 
                 FileInputStream fis2 = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
		         Workbook book1=WorkbookFactory.create(fis2);
		        String output = book1.getSheet("manufacturer").getRow(1).getCell(0).getStringCellValue();
		         System.out.println(output);
		         
		         
                 driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME1);
             	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD1);
             	WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='login_type']"));
             	 Select sal1=new Select(dropdown1);
             	 sal1.selectByVisibleText("Manufacturer");
             	 driver.findElement(By.xpath("//input[@type='submit']")).click(); 
             	 
             	  WebElement ord = driver.findElement(By.linkText("Orders"));
                 Actions ac=new Actions(driver);
                 ac.moveToElement(ord).click().perform();
                 
                String actual1 = driver.findElement(By.xpath("//h1[text()='Orders']")).getText();
                 
                if(actual1.contains(output))
                {
                	System.out.println("order created by retailer is displayed");
                }
                else
                {
                	System.out.println("order created by retailer is not displayed");	
                }
              
                 //logout
                Thread.sleep(2000);
       		 driver.findElement(By.xpath("//input[@value='Log out']")).click();

       		
       		driver.close();
	}

}
