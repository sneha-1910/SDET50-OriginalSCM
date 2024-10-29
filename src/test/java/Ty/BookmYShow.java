package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookmYShow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
     WebDriver driver=new FirefoxDriver();
     driver.manage().window().maximize();
     driver.get("https://in.bookmyshow.com/explore/home/bengaluru");
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.linkText("/explore/movies-bengaluru")).click();;
     
    // WebElement ele = driver.findElement(By.xpath("(//a[text()='Movies'])[1]"));
   //  WebElement ele = driver.findElement(By.xpath("//a[@class='bwc__sc-1shzs91-0 hlqISj']"));
     
    //     Actions act=new Actions(driver);
	//	act.moveToElement(ele).click().perform();
 
         driver.findElement(By.xpath("(//div[text()='Kannada'])[3]")).click();
         
     
     
	}
	
	
}
