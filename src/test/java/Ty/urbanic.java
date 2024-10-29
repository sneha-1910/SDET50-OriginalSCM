package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class urbanic {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.urbanic.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	     WebElement ele = driver.findElement(By.xpath("//span[text()='DENIM']"));
	      Actions act=new Actions(driver);
	      act.moveToElement(ele).perform();
	      
	     WebElement ele1 = driver.findElement(By.xpath("//a[text()='Jeans']"));
		     Actions a=new Actions(driver);
		     a.moveToElement(ele1).click().perform();
		     System.out.println("done");
		      
		     driver.findElement(By.xpath("//span[text()='SHOW FILTERS']")).click();
		     WebElement ele2 = driver.findElement(By.xpath("//span[@role='slider' and @aria-label='MaxVolume']"));
		     Actions a1=new Actions(driver);
		     a1.dragAndDropBy(ele2, -130, 0).perform();
					Thread.sleep(1000);
				}
		     
		    
		
	}


