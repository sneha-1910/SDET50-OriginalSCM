package Ty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonPhonePrices_me {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("vivo mobiles");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();	
		
		List<WebElement> Name = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']"));
		System.out.println(Name.size());
		
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//ancestor::span[@class='a-price-whole']"));
		System.out.println(price.size());

		for(int i=0;i<Name.size();i++)
		{
			
			System.out.println(Name.get(i).getText()+"="+price.get(i).getText());
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
