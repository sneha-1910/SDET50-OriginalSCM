package Pom_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class retailer_order_POMTEST {

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
         String LOGINTYPE =fLib.readDataFromPropertyFile("logintype3");    
			
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
			
		/*	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
			driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
			// Select sal=new Select(dropdown);
			 //sal.selectByVisibleText("Retailer");
			
			wLib.select("Retailer", dropdown);
			 driver.findElement(By.xpath("//input[@type='submit']")).click();*/
			
			Retailer_LoginPage rlp=new Retailer_LoginPage(driver);
			rlp.Retailer_Login(USERNAME, PASSWORD, LOGINTYPE);
			
			
			//WebElement ret = driver.findElement(By.linkText("New Order"));
			//Actions a=new Actions(driver);
		//	a.moveToElement(ret).click().perform();
			
		//	wLib.mousehover(driver, ret);
			
			/*driver.findElement(By.xpath("//input[@name='txtQuantity1']")).sendKeys("6");
			driver.findElement(By.xpath("//input[@name='txtQuantity2']")).sendKeys("8");
			driver.findElement(By.xpath("//input[@value='Post Order']")).click();
			
			String actual = driver.findElement(By.xpath("//h1[text()='My Orders']")).getText();
			
			if(actual.contains(page))
			{
				System.out.println("the details of the order posted by retailer is displayed");
			}
			else {
				System.out.println("the details of the order posted by retailer is not displayed");
			}*/
			
			Validate_AddRetailer_Page vap=new Validate_AddRetailer_Page(driver);
			vap.POST_ORDER_TAB(2, 4, page);
			Thread.sleep(2000);
			
			
			Retailer_HomePage rh=new Retailer_HomePage(driver);
			rh.Retailer_Logout();
			
			//driver.findElement(By.xpath("//input[@value='Log out']")).click();
			driver.close();
	}

}
