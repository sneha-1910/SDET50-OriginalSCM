package Pom_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ObjectRepository_POM.AdminloginPage;
import com.ObjectRepository_POM.admin_addR_addM_addD_Page;
import com.crm.GenericUtility.FileUtility;
import com.crm.GenericUtility.JavaUtility;
import com.crm.GenericUtility.WebDriverUtility;
import com.crm.GenericUtility.excelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Distributor_POMTEST {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	       FileUtility fLib=new FileUtility();
	         excelUtility eLib = new excelUtility();
	         JavaUtility jLib=new JavaUtility();
	         WebDriverUtility wLib=new WebDriverUtility();
	         
		/*	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\admincredentials.properties");
			Properties pobj = new Properties();
			pobj.load(fis);
			
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");*/
		
	         
	     	String BROWSER =fLib.readDataFromPropertyFile("browser1");
	     	String URL = fLib.readDataFromPropertyFile("url1");
	     	String USERNAME=fLib.readDataFromPropertyFile("username1");
	     	String PASSWORD=fLib.readDataFromPropertyFile("password1");
	     	String ADMIN = fLib.readDataFromPropertyFile("loginType1");
		
	     	/*FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
	    	Workbook book = WorkbookFactory.create(fi);
	    	String distributor = book.getSheet("distributorpage").getRow(1).getCell(0).getStringCellValue();
	    	System.out.println(distributor);*/
	          	
	        	
	    	
	    	 
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
	    	
	    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    	wLib.waitforPageLoad(driver);
	    	
	    	/*driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	    	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	    	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	    	// Select sal=new Select(dropdown);
	    	 //sal.selectByVisibleText("Admin");
	    	
	    	wLib.select("Admin", dropdown);
	    	 driver.findElement(By.xpath("//input[@type='submit']")).click();*/
	    	
	    	AdminloginPage alp=new AdminloginPage(driver);
	    	alp.ClickOnAdminLogin(USERNAME, PASSWORD, ADMIN);
	    	admin_addR_addM_addD_Page armd=new admin_addR_addM_addD_Page(driver);
	    	armd.Distributor(driver);
	    	
	    	
	    	
	    //	WebElement distr = driver.findElement(By.linkText("Distributors"));
	    	//Actions a=new Actions(driver);
	    	//a.moveToElement(distr).click().perform();
	    	
	    	//wLib.mousehover(driver, distr);
	    	
	    	
	    	String Text=eLib.readDataFromExcel("distributorpage", 1, 0);
	    	armd.ValidateDistributorTab(Text);
	    	/*String actual = driver.findElement(By.xpath("//h1[text()='View Distributor']")).getText();
	    	
	    	if(actual.contains(distributor))
	    	{
	    		System.out.println("distributor page is displayed");
	    	}
	    	
	    	else {
	    		System.out.println("distributor page is not displayed");
	    	}*/
	    	
	    	//logout
	    	 Thread.sleep(2000);
	    	 //driver.findElement(By.xpath("//input[@value='Log out']")).click();
              armd.LogOut();
	    	
	    	driver.close();
		
		
	}

}
