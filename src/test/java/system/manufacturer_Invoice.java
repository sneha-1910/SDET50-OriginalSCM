package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class manufacturer_Invoice {

	public static void main(String[] args) throws IOException, InterruptedException {
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
	 
	 WebElement ele1 = driver.findElement(By.linkText("Invoice"));
	 Actions a=new Actions(driver);
	 a.moveToElement(ele1).click().perform();
	 
	 
	
	WebElement ele = driver.findElement(By.xpath("//select[@name='cmbFilter']"));
	Select sall=new Select(ele);
	sall.selectByVisibleText("Invoice Id");
	driver.findElement(By.xpath("//input[@name='txtInvoiceId']")).sendKeys("2");
	driver.findElement(By.xpath("//input[@value='Search']")).click();
	
	
	String actual = driver.findElement(By.xpath("//h1[text()='Invoices']")).getText();
	

	if(actual.contains(generate))
	{
		System.out.println("inovice details is displayed");
	}
	
	else {
		System.out.println("invoice details is not displayed");
	}
	
	//logout
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value='Log out']")).click();

	
	driver.close();
	}

}
