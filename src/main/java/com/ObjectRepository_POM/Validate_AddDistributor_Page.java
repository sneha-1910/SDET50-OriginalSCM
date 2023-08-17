package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate_AddDistributor_Page {

	//declaration
	@FindBy(xpath="//h1[text()='Add Distributor']")
	private WebElement AddDistributor_Title;
	
	//initialization
	public Validate_AddDistributor_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getAddDistributor_Title() {
		return AddDistributor_Title;
	}
		
	
}
