package system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

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

public class admin_addmanufactureeGeneric {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\admincredentials.properties");
		Properties pobj = new Properties();
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
         String USERNAME  =fLib.readDataFromPropertyFile("username1");
         String PASSWORD =fLib.readDataFromPropertyFile("password1");
	
	
	/*FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
	Workbook book = WorkbookFactory.create(fi);
	
     //DataFormatter format = new DataFormatter();
	String name = book.getSheet("admin").getRow(1).getCell(0).getStringCellValue();
	String Email_id=book.getSheet("admin").getRow(3).getCell(0).getStringCellValue();
     // double phone = book.getSheet("admin").getRow(5).getCell(0).getNumericCellValue();
	String phone = book.getSheet("admin").getRow(5).getCell(0).toString();
	// String phone = format.formatCellValue(book.getSheet("admin").getRow(5).getCell(0));
	String usern = book.getSheet("admin").getRow(7).getCell(0).getStringCellValue();
	String passw = book.getSheet("admin").getRow(9).getCell(0).getStringCellValue();
	System.out.println(name+" "+Email_id+" "+phone+" "+usern+" "+passw);*/
         
         
	
	
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
	// sal.selectByVisibleText("Admin");
	wLib.select("Admin", dropdown);
    driver.findElement(By.xpath("//input[@type='submit']")).click();

	 WebElement ele = driver.findElement(By.linkText("Add Manufacturer"));
	// Actions a=new Actions(driver);
	// a.moveToElement(ele).click().perform();
	  
	wLib.mousehover(driver, ele);
	 
	 
/*	 driver.findElement(By.xpath("//input[@name='txtManufacturerName']")).sendKeys(name);
	 driver.findElement(By.xpath("//input[@name='txtManufacturerEmail']")).sendKeys(Email_id);
	 driver.findElement(By.xpath("//input[@name='txtManufacturerPhone']")).sendKeys(phone);
	 driver.findElement(By.xpath("//input[@name='txtManufacturerUname']")).sendKeys(usern);
	 driver.findElement(By.xpath("//input[@name='txtManufacturerPassword']")).sendKeys(passw);*/
	 
	eLib.getMultipleDataFromExcel("addmanufact", 0, 1, driver);

    driver.findElement(By.xpath("//input[@value='Add Manufacturer']")).click();
	 
	 
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
