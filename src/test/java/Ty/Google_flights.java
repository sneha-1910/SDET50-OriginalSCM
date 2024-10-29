package Ty;

import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Google_flights {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriverManager.firefoxdriver().setup();
	     WebDriver driver=new FirefoxDriver();
	     driver.manage().window().maximize();
		driver.get("https://www.google.com/travel/flights");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String to="New Delhi";
	driver.findElement(By.xpath("//input[@placeholder='Where to?']")).sendKeys(to);
	  WebElement ele = driver.findElement(By.xpath("//div[text()='New Delhi']"));
	   Actions act=new Actions(driver);
	   act.moveToElement(ele).click().perform();
	     Thread.sleep(2000);
	      driver.findElement(By.xpath("(//input[@aria-label='Departure'])[1]")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.xpath("//div[text()='October']/../descendant::div[text()='1']")).click();
	     driver.findElement(By.xpath("(//input[@placeholder='Return'])[2]")).click();
	     Thread.sleep(3000);
	     driver.findElement(By.xpath("//div[text()='November']/../descendant::div[text()='1']")).click();
	     driver.findElement(By.xpath("(//span[text()='Done'])[2]")).click();
	     driver.findElement(By.xpath("(//span[text()='Search'])[1]")).click();     
	
	     TreeSet<Integer> max=new TreeSet<>();
	List<WebElement> prices = driver.findElements(By.xpath("//div[@jsname='IWWDBc']//div[@class='JMc5Xc']/ancestor::li[@class='pIav2d']/descendant::div[@class='BVAVmf I11szd POX3ye']"));
        for (WebElement SinglePrice : prices)
        {
			String flightPrice = SinglePrice.getText();
			flightPrice=flightPrice.replace("₹", "").replace(",", "");
			int priveValue = Integer.parseInt(flightPrice);
			max.add(priveValue);
			
		}
         System.out.println("first: "+max.last());  
         for (Integer second : max)
         {
			//System.out.println("second");
		}
         System.out.println("second:  "+max.lower(max.last())); 

          
     //  driver.quit(); 
	}
	
	
	
}
