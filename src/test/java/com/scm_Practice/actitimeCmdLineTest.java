package com.scm_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class actitimeCmdLineTest {
 
	@Test
	public void actitime() {
		// TODO Auto-generated method stub
		String url = System.getProperty("url");
		String username = System.getProperty("username");
		String password = System.getProperty("password");
		WebDriver cd = new ChromeDriver();
		cd.manage().window().maximize();
		cd.get(url);
		cd.findElement(By.id("username")).sendKeys(username);
		cd.findElement(By.name("pwd")).sendKeys(password);
		cd.findElement(By.id("loginButton")).click();
		
		
		
		
	}

}
