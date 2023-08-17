package com.scm_Practice;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class listallniksCanaraBank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
	// launch the application
		driver.get("https://canarabank.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 List<WebElement> listlink = driver.findElements(By.xpath("//a"));
		System.out.println(listlink.size());
		
		ArrayList<String> links=new ArrayList<String>();//create empty array
		
		
		
		for(int i=0;i<25;i++)
		{
			String eachlink = listlink.get(i).getAttribute("href");
			
			URL url=null;
			int statuscode=0;

			
			try {
				//check the status code
				url=new URL(eachlink);
				
				HttpsURLConnection httpurl=(HttpsURLConnection)url.openConnection();
				statuscode=httpurl.getResponseCode(); 
				
			if(statuscode>=400)
			{
		       links.add(eachlink+"---"+statuscode);
		       
			}

		}
		catch(Exception e)	
			{
			links.add(eachlink+"---"+statuscode);
			}
			
		}
		System.out.println(links);
		driver.close();
		
}

			
		

	
	}


