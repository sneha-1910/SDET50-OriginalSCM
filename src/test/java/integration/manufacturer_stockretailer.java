package integration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class manufacturer_stockretailer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\manufacturercredentials.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
	String URL = pobj.getProperty("url");
	String BROWSER = pobj.getProperty("browser");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");

	
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
	Workbook book = WorkbookFactory.create(fi);
	
	
	WebDriverManager.chromedriver().setup();
	
	ChromeDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get(URL);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	 Select sal=new Select(dropdown);
	 sal.selectByVisibleText("Manufacturer");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
		
	 WebElement ele = driver.findElement(By.linkText("Manage Stock"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).click().perform();
		
	WebElement ele1=driver.findElement(By.xpath("//input[@name='txtQuantity[11]']"));
	ele1.clear();
	ele1.sendKeys("34");
	
	driver.findElement(By.xpath("//input[@value='Update Stock']")).click();
	
	Alert a1=driver.switchTo().alert();
     String cfrm = a1.getText();
	 System.out.println(cfrm);
	  a1.accept(); 
		
	//logout
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@value='Log out']")).click();

	 // login as retailer
		 FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\retailercredentials.properties");
		 Properties pobj1=new Properties();
		 pobj1.load(fis1);
		 
          
		String URL1 = pobj1.getProperty("url");
		String BROWSER1 = pobj1.getProperty("browser");
		String USERNAME1 = pobj1.getProperty("username");
		String PASSWORD1 = pobj1.getProperty("password");
		 
		driver.get(URL1);
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME1);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD1);
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='login_type']"));
		 Select sal1=new Select(dropdown1);
		 sal1.selectByVisibleText("Retailer");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 WebElement ele2 = driver.findElement(By.linkText("New Order"));
		 Actions a11=new Actions(driver);
		 a11.moveToElement(ele2).click().perform();
		 
		 //validation
		 String data = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[12]/td[4]")).getText();
		 if(data.contains("34"))
		 {
			 System.out.println("Updated stock present in the availability");
		 }
		 else {
			 System.out.println("Updated stock is not present in the availability");
		 }
		 
		 //logout
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@value='Log out']")).click();
		 
		 driver.close();
	}
}


