package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Captha_OrangeHRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
     WebDriver driver=new FirefoxDriver();
     driver.manage().window().maximize();
     driver.get("https://www.orangehrm.com/en/book-a-free-demo/");
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.findElement(By.xpath("//input[@id='Form_getForm_FullName']")).sendKeys("sneha");
     driver.findElement(By.xpath("//input[@id='Form_getForm_Email']")).sendKeys("snehasp@gmail.com");
     driver.findElement(By.xpath("//input[@id='Form_getForm_CompanyName']")).sendKeys("tyss");
     WebElement ele = driver.findElement(By.xpath("//select[@id='Form_getForm_Country']"));
		Select sal=new Select(ele);
		sal.selectByVisibleText("India");
	driver.findElement(By.xpath("//input[@id='Form_getForm_Contact']")).sendKeys("9880709965");
	driver.switchTo().frame("//iframe[@title='reCAPTCHA']");
	driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
	
		
		
		
		
		
		
		
		
	}

}
