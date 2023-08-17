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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class distributor {

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
		String distributor = book.getSheet("distributorpage").getRow(1).getCell(0).getStringCellValue();
		System.out.println(distributor);
		
		 
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
		
		
		WebElement distr = driver.findElement(By.linkText("Distributors"));
		Actions a=new Actions(driver);
		a.moveToElement(distr).click().perform();
		
		
		String actual = driver.findElement(By.xpath("//h1[text()='View Distributor']")).getText();
		
		if(actual.contains(distributor))
		{
			System.out.println("distributor page is displayed");
		}
		
		else {
			System.out.println("distributor page is not displayed");
		}
		
		//logout
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@value='Log out']")).click();

		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
