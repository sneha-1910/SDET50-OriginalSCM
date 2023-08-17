package com.ObjectRepository_POM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate_HomePage {
   
	//declaration
	@FindBy(xpath="//h1[text()='Welcome Admin']")
	private WebElement HomePage_Title;
	
	//initialization
	public Validate_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	
	public WebElement getHomePage_Title()
	{
		return HomePage_Title;
	}
	
	//business libraries
	public void Validate(String text) 
	{
		String actual = HomePage_Title.getText();
		assertEquals(actual,text );
		System.out.println("Home page is displayed");
//		if(actual.contains(text))
//		{
//			System.out.println("Home page is displayed");
//		}
//		else
//		{
//			System.out.println("Home page is not displayed");
//		}
	}

}
