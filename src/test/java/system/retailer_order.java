package system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

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

public class retailer_order {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\retailercredentials.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");

		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\SNEHA.xlsx");
		Workbook book = WorkbookFactory.create(fi);
		String page = book.getSheet("retailer").getRow(1).getCell(0).getStringCellValue();
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
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(PASSWORD);
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='login_type']"));
		 Select sal=new Select(dropdown);
		 sal.selectByVisibleText("Retailer");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		
		WebElement ret = driver.findElement(By.linkText("New Order"));
		Actions a=new Actions(driver);
		a.moveToElement(ret).click().perform();
		
		driver.findElement(By.xpath("//input[@name='txtQuantity1']")).sendKeys("6");
		driver.findElement(By.xpath("//input[@name='txtQuantity2']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@value='Post Order']")).click();
		
		String actual = driver.findElement(By.xpath("//h1[text()='My Orders']")).getText();
		
		if(actual.contains(page))
		{
			System.out.println("the details of the order posted by retailer is displayed");
		}
		else {
			System.out.println("the details of the order posted by retailer is not displayed");
		}
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Log out']")).click();
		driver.close();
		
	}
}


