package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Manuf_Validate_InvoicePage {

	//declaration
	@FindBy(xpath="//h1[text()='Invoices']")
	private WebElement Invoice_Page;
	
	//initialization
	public Manuf_Validate_InvoicePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getInvoice_Page() {
		return Invoice_Page;
	}
	
	
	
	
	
	
	
}
