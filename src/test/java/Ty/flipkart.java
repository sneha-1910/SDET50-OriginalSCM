package Ty;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.protobuf.LazyStringArrayList;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
        driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Samsung phones");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
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
