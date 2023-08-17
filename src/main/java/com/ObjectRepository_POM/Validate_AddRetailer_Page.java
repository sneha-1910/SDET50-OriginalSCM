package com.ObjectRepository_POM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Validate_AddRetailer_Page {
     
  //declaration
	@FindBy(xpath="//h1[text()='Add Retailer']")
	private WebElement AddRetailer_Title;
	
	@FindBy(linkText="New Order")
	private WebElement New_Order_TAB;
	
	@FindBy(xpath="//table[@class='table_displayData']/tbody/tr[13]/td[4]")
	private WebElement Availability;
	
	@FindBy(xpath="//input[@name='txtQuantity1']")
	private WebElement Qunatity1;
	
	@FindBy(xpath="//input[@name='txtQuantity2']")
	private WebElement Quantity2;
	
	@FindBy(xpath="//input[@value='Post Order']")
	private WebElement Postorder;
	
	@FindBy(linkText="My Orders")
	private WebElement Myorder;
	
	@FindBy(xpath="//h1[text()='My Orders']")
	private WebElement validate_myorder;
	

	//initialization
	public Validate_AddRetailer_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	//Utilization
	
	public WebElement getAddRetailer_Title() {
		return AddRetailer_Title;
	}
	public WebElement getNew_Order_TAB() {
		return New_Order_TAB;
	}
	

	public WebElement getValidate_myorder() {
		return validate_myorder;
	}

	public WebElement getQunatity1() {
		return Qunatity1;
	}

	public WebElement getQuantity2() {
		return Quantity2;
	}

	public WebElement getPostorder() {
		return Postorder;
	}

	public WebElement getMyorder() {
		return Myorder;
	}

	public WebElement getAvailability() {
		return Availability;
	}

	//business libraries
	public void NEW_ORDER_TAB(int quantity)
	{
		New_Order_TAB.click();	
		String actual = Availability.getText();
		if(actual.contains(""+quantity+""))
		{
			System.out.println("Updated stock present in the availability");
		}
		else
		{
			System.out.println("Updated stock is not present in the availability");
		}
	}
	
	public void POST_ORDER_TAB(int quantity1,int quantity2,String Text)
   {
		New_Order_TAB.click();
		Qunatity1.sendKeys("quantity1");
		Quantity2.sendKeys("quantity2");
		Postorder.click();
		String actual = Myorder.getText();
		assertEquals(actual, Text);
		System.out.println("the details of the order posted by retailer is displayed");
//		if(actual.contains(Text))
//		{
//			System.out.println("the details of the order posted by retailer is displayed");
//		}
//		else
//		{
//			System.out.println("the details of the order posted by retailer is not displayed");
//		}
	}
	
	public void My_Orders_Tab()
	{
		Myorder.click();
	}
	
	public void validate_MY_ORDER(String Text)
	{
		String actual = validate_myorder.getText();
		if(actual.contains(Text))
		{
			
			System.out.println("My Orders page is displayed");
		}
		
		else {
			System.out.println("My Orders page is not displayed");
		}
		
	}
	
}
