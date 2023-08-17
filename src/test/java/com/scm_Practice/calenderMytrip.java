package com.scm_Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calenderMytrip {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        
		//String monthandyear="August 2023 ";
		//		int date=29;
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.navigate().refresh();or mam said
		
		Actions act=new Actions(driver);
		act.moveByOffset(40,40).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
	 String actualdate = "//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='29']";
	 
		String nextArrow="//span[@aria-label='Next Month']";
		
	for(;;)
	{
		try {
			   driver.findElement(By.xpath(actualdate)).click();
			   break;
			   

			   }
		   catch (Exception e) {
			 driver.findElement(By.xpath(nextArrow)).click();
			   
		   }
	   }
    Thread.sleep(2000);
	driver.close();

	}	
	  
	}


