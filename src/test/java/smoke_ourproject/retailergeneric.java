package smoke_ourproject;

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

public class retailergeneric {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		 FileUtility fLib=new FileUtility();
         excelUtility eLib = new excelUtility();
         JavaUtility jLib=new JavaUtility();
         WebDriverUtility wLib=new WebDriverUtility();
	/*	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\retailercredentials.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
	String URL = pobj.getProperty("url");
	String BROWSER = pobj.getProperty("browser");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");*/
		
         String BROWSER=fLib.readDataFromPropertyFile("browser1");
     	String URL = fLib.readDataFromPropertyFile("url1");
     	String USERNAME =fLib.readDataFromPropertyFile("username3");
     	String PASSWORD=fLib.readDataFromPropertyFile("password3");
     	

	
/*	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
	Workbook book = WorkbookFactory.create(fi);
	String page = book.getSheet("retailer").getRow(1).getCell(0).getStringCellValue();
*/
     	
     	
    	String page=eLib.readDataFromExcel("retailer", 1, 0);
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
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wLib.waitforPageLoad(driver);
	
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	// Select sal=new Select(dropdown);
	// sal.selectByVisibleText("Retailer");
	
	wLib.select("Retailer", dropdown);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	
	
	WebElement ret = driver.findElement(By.linkText("My Orders"));
	//Actions a=new Actions(driver);
	//a.moveToElement(ret).click().perform();
	
	wLib.mousehover(driver, ret);
	
	
	String actual = driver.findElement(By.xpath("//h1[text()='My Orders']")).getText();
	
	if(actual.contains(page))
	{
		System.out.println("My Orders page is displayed");
	}
	
	else {
		System.out.println("My Orders page is not displayed");
	}
	
	//logout
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value='Log out']")).click();

	
	driver.close();
	}

}
