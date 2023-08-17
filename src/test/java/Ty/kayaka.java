package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class kayaka {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.kayak.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("Bengaluru, Karnataka, India (BLR)");
	    driver.findElement(By.xpath("//input[@aria-label='Flight destination input']")).sendKeys("New Delhi, National Capital Territory of India, India (DEL)");
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
	 driver.findElement(By.xpath("//div[@class='onx_ onx_-pres-mcfly onx_-double']//div[@aria-label='Tuesday 29 August, 2023']")).click();
	 driver.findElement(By.xpath("//span[@aria-label='End date calendar input']")).click();
     driver.findElement(By.xpath("//div[@class='onx_ onx_-pres-mcfly onx_-double']//div[@aria-label='Tuesday 19 September, 2023']")).click();
    
    // driver.findElement(By.xpath("//*[name()='svg' and @class='c8LPF-icon']")).click();
	// driver.findElement(By.xpath("//*[name()='svg' and @class='dDYU-closeIcon dDYU-mod-theme-default']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		 driver.findElement(By.xpath("//div[@aria-label='Close']")).click();
		 driver.findElement(By.xpath("//button[@aria-label='Search']")).click(); 
		
		
		
	}

}
