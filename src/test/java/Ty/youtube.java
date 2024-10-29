package Ty;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class youtube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		 driver.get("https://www.youtube.com/");
		driver.findElement(By.xpath("//yt-formatted-string[text()='Trending']")).click();
	
		
		
		
		
		
		
		
		
		

	}

}
