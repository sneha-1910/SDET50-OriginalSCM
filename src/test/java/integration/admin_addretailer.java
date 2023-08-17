package integration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class admin_addretailer {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\admincredentials.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
	String URL = pobj.getProperty("url");
	String BROWSER = pobj.getProperty("browser");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	
	
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
	Workbook book = WorkbookFactory.create(fi);
     Sheet sh = book.getSheet("addretailer");
     int count=sh.getLastRowNum();
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
	
	
	driver.manage().window().maximize();
	
	driver.get(URL);
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	 Select sal=new Select(dropdown);
	 sal.selectByVisibleText("Admin");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	

	 WebElement ele = driver.findElement(By.linkText("Add Retailers"));
	 Actions a=new Actions(driver);
	 a.moveToElement(ele).click().perform();
	 
	 //by using map
	 HashedMap<String, String> map = new HashedMap<String, String>();
	 
	 // get the data from excel and store it in map
	 for(int i=0;i<=count;i++)
	 {
		 String key = sh.getRow(i).getCell(0).toString();
		 System.out.println(key);
		 String value = sh.getRow(i).getCell(1).toString();
		 System.out.println(value);
		 map.put(key, value);
	 }
	 //enter the values in textfield
	 //Random ran=new Random();
	// int random=ran.nextInt(400);
	 
	 for(Entry<String, String> set:map.entrySet())
	 {
		 driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	 }
	 
	WebElement ele1=driver.findElement(By.xpath("//select[@name='cmbAreaCode']"));
	 Select sal1=new Select(ele1);
	 sal1.selectByVisibleText("SRKJ (Sarkhej)");
	 
	
	 
	driver.findElement(By.xpath("//input[@value='Add Retailer']")).click();
	 
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
