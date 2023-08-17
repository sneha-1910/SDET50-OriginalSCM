package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retailer_HomePage {

		//declaration
		@FindBy(xpath="//input[@value='Log out']")
		private WebElement logout;

		//initialization
		public Retailer_HomePage(WebDriver driver)
		{
		PageFactory.initElements(driver,this);	
		}

		
		
		//utilization
		public WebElement getLogout() 
		{
			return logout;
		}
		
		//business libraries
		public void Retailer_Logout()
		{
			logout.click();
		}
		
		
	}


