package Ty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class pricegrtthan60000 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Iphone 13");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price-whole'][number(translate(text(),'₹,',' '))<700000]"));
                System.out.println(prices.size());
                
        for(int i=0;i<prices.size();i++)
        {
              System.out.println(prices.get(i).getText());
        }
        List<WebElement> names = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
       System.out.println(names.size());
       
        for(int j=0;j<names.size();j++)
        {
                 System.out.println(names.get(j).getText());
        }
        
        
        
        
	}

}
