package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver=new ChromeDriver();
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.get("https://www.makemytrip.com/");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
      Actions a=new Actions(driver);
      a.moveByOffset(40, 40).click().perform();
      driver.findElement(By.xpath("//span[text()='Departure']")).click();
      
		 
   //driver.findElement(By.xpath("//div[text()='August 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='19'] ")).click();
   
      System.out.println("done");
		driver.close();
	}

}
