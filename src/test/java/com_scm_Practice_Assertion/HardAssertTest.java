package com_scm_Practice_Assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertTest {
	
	

	@Test
	public void hardAssert()
	{
//          System.out.println("----step1----");
//          System.out.println("----step2----");
//          Assert.assertEquals("a", "a", "Values match");
//          System.out.println("----step3----");
            // Assert.fail();
           //  System.out.println("---step7----");
         String exp="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in" ;   
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual=driver.getTitle();
		System.out.println(actual);
		Assert.assertEquals(actual, exp);
		System.out.println("both are same");
		driver.close();
		
	}
	
	
	@Test
	public void Assertnull() 
	{ 
		    System.out.println("----step4----");
		     // String a=null;
		    int a=0;
	          Assert.assertNotNull(a);
	          System.out.println("----step5----");
	          System.out.println("----step6----");	
	}

}
