package com.scm_Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class listalllinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
	// launch the application
		driver.get("http://rmgtestingserver:8888/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		 List<WebElement> listlink = driver.findElements(By.xpath("//a"));
		System.out.println(listlink.size());
		
		ArrayList<String> links=new ArrayList<String>();//create empty array
		
		
		
		for(int i=0;i<listlink.size();i++)
		{
			String eachlink = listlink.get(i).getAttribute("href");
			
			URL url=null;
			int statuscode=0;

			try {
			// load the url
				url=new URL(eachlink);
				
				//open the connection
				HttpURLConnection httpurl=(HttpURLConnection)url.openConnection();
				statuscode=httpurl.getResponseCode(); 
				
				//check the status code.
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
		
		
}
}