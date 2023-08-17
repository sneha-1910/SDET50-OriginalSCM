package smoke_ourproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class adminlogin {

	public static void main(String[] args) throws IOException, InterruptedException {
	//Random ran=new Random();
	//int random=ran.nextInt(400);
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\admincredentials.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
	String URL = pobj.getProperty("url");
	String BROWSER = pobj.getProperty("browser");
	String USERNAME = pobj.getProperty("username");
	String PASSWORD = pobj.getProperty("password");
	
	/*System.out.println(URL);
	System.out.println(BROWSER);
	System.out.println(USERNAME);
	System.out.println(PASSWORD);*/
	
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
	Workbook book = WorkbookFactory.create(fi);
	String loginpage = book.getSheet("login").getRow(1).getCell(0).getStringCellValue();
	
	
	 
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
	driver.manage().window().maximize();
	
	driver.get(URL);
	
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
	WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
	 Select sal=new Select(dropdown);
	 sal.selectByVisibleText("Admin");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 
	//validation
	 String actual = driver.findElement(By.xpath("//h1[text()='Welcome Admin']")).getText();
	 
	 if(actual.contains(loginpage))
	 {
		 System.out.println("Application home page is displayed");
	 }
	 else {
		 System.out.println("Application home page is not displayed.");
	 }
	
	//logout
	 Thread.sleep(2000);
	 driver.findElement(By.xpath("//input[@value='Log out']")).click();
	 
	
	
	
	

	}

}
