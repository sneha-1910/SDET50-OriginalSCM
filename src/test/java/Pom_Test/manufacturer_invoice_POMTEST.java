package Pom_Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.ObjectRepository_POM.Manuf_HomePage;
import com.ObjectRepository_POM.Manufacturer_LoginPage;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;
import com.crm.GenericUtility.excelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class manufacturer_invoice_POMTEST {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		/*	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\manufacturercredentials.properties");
		Properties pobj = new Properties();
		pobj.load(fis);*/
		
 //  String URL = pobj.getProperty("url");
	/*String BROWSER = pobj.getProperty("browser");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");*/
		
		
		FileUtility fLib=new FileUtility();
        excelUtility eLib = new excelUtility();
        JavaUtility jLib=new JavaUtility();
        WebDriverUtility wLib=new WebDriverUtility();
        
        String URL= fLib.readDataFromPropertyFile("url1");
        String BROWSER= fLib.readDataFromPropertyFile("browser1");
        String USERNAME= fLib.readDataFromPropertyFile("username2");
        String PASSWORD= fLib.readDataFromPropertyFile("password2");
        String LOGINTYPE= fLib.readDataFromPropertyFile("loginType2");
        
    	
    	/*FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
    	Workbook book = WorkbookFactory.create(fi);
    	String generate = book.getSheet("invoices").getRow(1).getCell(0).getStringCellValue();
    	System.out.println(generate);*/
             
             String generate= eLib.readDataFromExcel("invoices", 1, 0);
    	WebDriverManager.firefoxdriver().setup();
    	
    	FirefoxDriver driver=new FirefoxDriver();
    	
    	//driver.manage().window().maximize();
    	wLib.maximizeWindow(driver);
    	
    	driver.get(URL);
    	
    	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	wLib.waitforPageLoad(driver);
    	
    	/*driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
    	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
    	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
    	 //Select sal=new Select(dropdown);
    	 //sal.selectByVisibleText("Manufacturer");*/
    	
    	
    	//wLib.select("Manufacturer", dropdown);
    	// driver.findElement(By.xpath("//input[@type='submit']")).click();
    	
    	Manufacturer_LoginPage mlp=new Manufacturer_LoginPage(driver);
    	mlp.ManufacturerLoginPage(USERNAME, PASSWORD, LOGINTYPE);
    	
    	 
    	// WebElement ele1 = driver.findElement(By.linkText("Invoice"));
    	// Actions a=new Actions(driver);
    	// a.moveToElement(ele1).click().perform();
    	// wLib.mousehover(driver, ele1);
    	 
    	
    	//WebElement ele = driver.findElement(By.xpath("//select[@name='cmbFilter']"));
    	//Select sall=new Select(ele);
    	//sall.selectByVisibleText("Invoice Id");
    	//wLib.select("Invoice Id", ele);
    	
    //	driver.findElement(By.xpath("//input[@name='txtInvoiceId']")).sendKeys("2");
    //	driver.findElement(By.xpath("//input[@value='Search']")).click();
    	String sear="Invoice Id";
    	String Id="2";
    	Manuf_HomePage mvh=new Manuf_HomePage(driver);
    	mvh.InvoiceSearch(sear, Id);
    	
    	
    	//String actual = driver.findElement(By.xpath("//h1[text()='Invoices']")).getText();
    	mvh.ValidateInVoiceByID(generate);
                
    	/*if(actual.contains(generate))
    	{
    		System.out.println("inovice details is displayed");
    	}
    	
    	else {
    		System.out.println("invoice details is not displayed");
    	}*/
    	
    	//logout
    	 Thread.sleep(2000);
    //	 driver.findElement(By.xpath("//input[@value='Log out']")).click();

    	mvh.Manuf_Logout();
    	
    	driver.close();
		
	}

}
