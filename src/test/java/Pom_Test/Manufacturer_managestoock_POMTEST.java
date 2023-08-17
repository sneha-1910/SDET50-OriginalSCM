package Pom_Test;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ObjectRepository_POM.Manuf_HomePage;
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

public class Manufacturer_managestoock_POMTEST {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\manufacturercredentials.properties");
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
         String USERNAME  =fLib.readDataFromPropertyFile("username2");
         String PASSWORD =fLib.readDataFromPropertyFile("password2");
         String LOGINTYPE= fLib.readDataFromPropertyFile("loginType2");
	
         	WebDriverManager.firefoxdriver().setup();
         	WebDriver driver=new FirefoxDriver();
         
     	

	
	//driver.manage().window().maximize();
	wLib.maximizeWindow(driver);
	driver.get(URL);
	
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	wLib.waitforPageLoad(driver);
	
/*	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	// Select sal=new Select(dropdown);
	 //sal.selectByVisibleText("Manufacturer");
	  
            wLib.select("Manufacturer", dropdown);
	 driver.findElement(By.xpath("//input[@type='submit']")).click();*/
	
	Manufacturer_LoginPage mlp=new Manufacturer_LoginPage(driver);
	mlp.ManufacturerLoginPage(USERNAME, PASSWORD,LOGINTYPE );
	
		
	// WebElement ele = driver.findElement(By.linkText("Manage Stock"));
		//Actions a=new Actions(driver);
		//a.moveToElement(ele).click().perform();
	// wLib.mousehover(driver, ele);
		
	/*WebElement ele1=driver.findElement(By.xpath("//input[@name='txtQuantity[11]']"));
	ele1.clear();
	ele1.sendKeys("34");
	
	driver.findElement(By.xpath("//input[@value='Update Stock']")).click();
	
	Alert a1=driver.switchTo().alert();
     String cfrm = a1.getText();
	 System.out.println(cfrm);
	  a1.accept(); */

	Manufa_ManageStock_Invoice_Order_PAGE mio=new Manufa_ManageStock_Invoice_Order_PAGE(driver);
	mio.Manuf_Manage_Stock(driver, 46, "Pizza Sauce");
	
	mio.ConfirmationMSG(driver);
	  
		
	//logout
		 Thread.sleep(2000);
		 //driver.findElement(By.xpath("//input[@value='Log out']")).click();
		Manuf_HomePage mh=new Manuf_HomePage(driver);
		mh.Manuf_Logout();
 
	 // login as retailer
	/*	 FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\retailercredentials.properties");
		 Properties pobj1=new Properties();
		 pobj1.load(fis1);
		 
          
		String URL1 = pobj1.getProperty("url");
		String BROWSER1 = pobj1.getProperty("browser");
		String USERNAME1 = pobj1.getProperty("username");
		String PASSWORD1 = pobj1.getProperty("password");*/
		 FileUtility fLib1=new FileUtility();
         excelUtility eLib1 = new excelUtility();
         JavaUtility jLib1=new JavaUtility();
         WebDriverUtility wLib1=new WebDriverUtility();
         
         String URL1  =fLib1.readDataFromPropertyFile("url1");
         String BROWSER1  =fLib1.readDataFromPropertyFile("browser1");
         String USERNAME1  =fLib1.readDataFromPropertyFile("username3");
         String PASSWORD1 =fLib1.readDataFromPropertyFile("password3");
         String LOGINTYPE1 =fLib1.readDataFromPropertyFile("loginType3");
		driver.get(URL1);
		
	/*	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME1);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD1);
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='login_type']"));
		 //Select sal1=new Select(dropdown1);
		 //sal1.selectByVisibleText("Retailer");
		
		wLib1.select("Retailer", dropdown1);
		 driver.findElement(By.xpath("//input[@type='submit']")).click();*/
		
		Retailer_LoginPage rlp=new Retailer_LoginPage(driver);
		rlp.Retailer_Login(USERNAME1, PASSWORD1, LOGINTYPE1);
		 
		// WebElement ele2 = driver.findElement(By.linkText("New Order"));
		// Actions a11=new Actions(driver);
		// a11.moveToElement(ele2).click().perform();
		 
		// wLib1.mousehover(driver, ele2);
		
		int quantity=45;
		Validate_AddRetailer_Page vadp=new Validate_AddRetailer_Page(driver);
		vadp.NEW_ORDER_TAB(quantity);
		 
		 //validation
		/* String data = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[12]/td[4]")).getText();
		 if(data.contains("34"))
		 {
			 System.out.println("Updated stock present in the availability");
		 }
		 else {
			 System.out.println("Updated stock is not present in the availability");
		 }*/
		 
		 //logout
		 Thread.sleep(2000);
		// driver.findElement(By.xpath("//input[@value='Log out']")).click();
		 Retailer_HomePage rh=new Retailer_HomePage(driver);
		 rh.Retailer_Logout();
		 driver.close();
	}

}
