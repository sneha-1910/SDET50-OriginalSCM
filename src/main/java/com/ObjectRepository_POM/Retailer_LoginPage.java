package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;

public class Retailer_LoginPage extends WebDriverUtility{
	//declaration
	@FindBy(xpath="//input[@name='txtUsername']")
	private WebElement Username;
	
	@FindBy(xpath="//input[@name='txtPassword']")
	private WebElement Password;
	
	@FindBy(xpath="//select[@name='login_type']")
	private WebElement Dropdown;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement Login_button;
	
	
	//initialization
	public Retailer_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getDropdown() {
		return Dropdown;
	}

	public WebElement getLogin_button() {
		return Login_button;
	}
	
	public void Retailer_Login(String USERNAME,String PASSWORD,String LOGINTYPE)
	{
		Username.sendKeys(USERNAME);	
		Password.sendKeys(PASSWORD);
		select(LOGINTYPE,Dropdown);
		Login_button.click();
	}
	
	
}
