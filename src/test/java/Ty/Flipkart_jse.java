package Ty;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_jse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		  WebElement ele = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
		     
	      Actions act=new Actions(driver);
			act.moveToElement(ele);
			  ele.sendKeys("Samsung phones",Keys.ENTER);
			  
			 WebElement ele1 = driver.findElement(By.xpath("//span[text()='Next']"));
			 Actions ac=new Actions(driver);
			 
		 
		
		
		
		
		
		
		
		
	}

}
