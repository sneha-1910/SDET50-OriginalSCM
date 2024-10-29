package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class manufacturer_invoice_date {

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
	String generate = book.getSheet("invoices").getRow(1).getCell(0).getStringCellValue();
	System.out.println(generate);
	WebDriverManager.firefoxdriver().setup();
	
	 FirefoxDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	
	driver.get(URL);
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	 Select sal=new Select(dropdown);
	 sal.selectByVisibleText("Manufacturer");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 
	 WebElement ele1 = driver.findElement(By.linkText("Invoice"));
	 Actions a=new Actions(driver);
	 a.moveToElement(ele1).click().perform();
	 
	 //search invoice details through date
	
	WebElement ele = driver.findElement(By.xpath("//select[@name='cmbFilter']"));
	Select sall=new Select(ele);
	sall.selectByVisibleText("Date");
	driver.findElement(By.xpath("//input[@name='txtDate']")).click();
	
	WebElement ele3 = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
	Select sal3=new Select(ele3);
	sal3.selectByVisibleText("Jun");
	
	WebElement ele4 = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
	Select sal4=new Select(ele4);
	sal4.selectByVisibleText("1997");
	
	driver.findElement(By.xpath("//a[text()='19']/..")).click();
	

	driver.findElement(By.xpath("//input[@value='Search']")).click();
	
	
	String actual = driver.findElement(By.xpath("//h1[text()='Invoices']")).getText();
	
//	String actual1 = driver.findElement(By.xpath("//table[@class='table_displayData']/tbody/tr[2]/td[3]")).getText();
	if(actual.contains(generate))
	{
		System.out.println("inovice details are displayed");
	} 
  /* else if(actual1.contains("1997-06-19")) {
		
		System.out.println("invoice details is displayed");
	}*/
   else {
	   System.out.println(" inovice details are not displayed");
   }
	//logout
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value='Log out']")).click();

	
	driver.close();
		
		
		
	}

}
