package Ty;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//span[@role='button']")).click();
		
      WebElement ele = driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']"));
     
      Actions act=new Actions(driver);
		act.moveToElement(ele);
		  ele.sendKeys("Samsung phones");
		  Robot r=new Robot();
		  r.keyPress(KeyEvent.VK_ENTER);
		  r.keyRelease(KeyEvent.VK_ENTER);
		  
				  
		  
		 
     //  driver.findElement(By.xpath("//div[@class='_2SmNnR']")).click();
        
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_4rR01T']"));
        System.out.println(names.size());
        
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='col col-5-12 nlI3QM']//div[@class='_30jeq3 _1_WHN1']"));
        System.out.println(prices.size());
       
        for(int i=0;i<names.size();i++)
        {
              
              System.out.println(names.get(i).getText()+"="+prices.get(i).getText());
        }
       
      
        
	}

}
