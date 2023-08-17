package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;

public class Manufacturer_LoginPage extends WebDriverUtility{

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
			public Manufacturer_LoginPage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			
              // Utilization
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
			
			//business libraries
			public void ManufacturerLoginPage(String USERNAME,String PASSWORD,String LOGINTYPE)
			{
				Username.sendKeys(USERNAME);
				Password.sendKeys(PASSWORD);
				select(LOGINTYPE, Dropdown);
				Login_button.click();
			}
			
			
}
