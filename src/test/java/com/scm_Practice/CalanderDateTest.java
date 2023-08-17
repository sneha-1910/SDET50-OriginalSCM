package com.scm_Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalanderDateTest {

	public static void main(String[] args) throws InterruptedException {
		
		//String monthandyear="September 2023 ";
		//int date=25;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		   driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		   driver.findElement(By.xpath("//span[text()='Departure']")).click();
		String actualDate="//div[text()='September 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']";
		  // String actualDate="//div[text()='"+monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		    String nextArrow="//span[@aria-label='Next Month']";
		   for(;;) 
		   {
			   try {
				   driver.findElement(By.xpath(actualDate)).click();
				   break;
				   

				   }
			   catch (Exception e) {
				   driver.findElement(By.xpath(nextArrow)).click();
				   
			   }
		   }
		  driver.findElement(By.xpath("//span[text()='Done']")).click();
		  Thread.sleep(2000);
		  driver.close();
		  
		  
		   	
		

	}

}
