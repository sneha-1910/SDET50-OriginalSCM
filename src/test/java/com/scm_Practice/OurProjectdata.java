package com.scm_Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OurProjectdata {

	private static final TimeUnit TimeUnit = null;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\OurProjectData.properties");
        Properties pobj = new Properties();
        pobj.load(fis);
        
         String URL = pobj.getProperty("url");
         String BROWSER = pobj.getProperty("browser");
         String USERNAME = pobj.getProperty("username");
         String PASSWORD = pobj.getProperty("password");
         
         WebDriver driver=null;
         
        
         if(BROWSER.equalsIgnoreCase("chrome"))
         {
        	 WebDriverManager.chromedriver().setup();
        	 driver=new ChromeDriver();
         }
       else if(BROWSER.equalsIgnoreCase("firefox")) {
        		 WebDriverManager.firefoxdriver().setup();
        		 driver=new FirefoxDriver();
        	 }
       else {
    	   WebDriverManager.chromedriver().setup();
    	    driver=new ChromeDriver();
       }
        
         driver.manage().window().maximize();
         driver.get(URL);
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.id("login:username")).sendKeys(USERNAME);
         driver.findElement(By.id("login:password")).sendKeys(PASSWORD);
         WebElement dropdown=driver.findElement(By.id("login:type"));
         Select sel=new Select(dropdown);
         sel.selectByVisibleText("Admin");
         driver.findElement(By.xpath("//input[@type='submit']")).click();     
	}
	

}
