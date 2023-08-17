package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate_AddManufacturer_Page {
    
	//declaration
	@FindBy(xpath="//h1[text()='Add Manufacturer']")
	private WebElement AddManufacturer_Title;
	
	//initialization
	public Validate_AddManufacturer_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddManufacturer_Title() {
		return AddManufacturer_Title;
	}
	
	
	
}
