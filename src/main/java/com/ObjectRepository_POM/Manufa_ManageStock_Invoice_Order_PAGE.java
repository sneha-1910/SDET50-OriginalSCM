package com.ObjectRepository_POM;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;

public class Manufa_ManageStock_Invoice_Order_PAGE extends WebDriverUtility {

	//declaration
	@FindBy(linkText="Home")
	private WebElement Home_page;
	
	@FindBy(linkText="Manage Stock")
	private WebElement ManageStock_Page;
	
	@FindBy(linkText="Orders")
    private WebElement Orders_Page;
	
	@FindBy(xpath="//h1[text()='Orders']")
    private WebElement Validate_Orders;

	
	@FindBy(linkText="Invoice")
	private WebElement Invoice_Page;

	@FindBy(xpath="//input[@value='Update Stock']")
	private WebElement Update_Stock;
	
	@FindBy(xpath="//h1[text()='Orders']")
	private WebElement validate_order;
	
	//initialization
	public Manufa_ManageStock_Invoice_Order_PAGE(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
    //utilization
	public WebElement getHome_page() {
		return Home_page;
	}

	public WebElement getManageStock_Page() {
		return ManageStock_Page;
	}

	public WebElement getValidate_Orders() {
		return Validate_Orders;
	}


	public WebElement getUpdate_Stock() {
		return Update_Stock;
	}


	public WebElement getValidate_order() {
		return validate_order;
	}


	public WebElement getOrders_Page() {
		return Orders_Page;
	}

	public WebElement getInvoice_Page() {
		return Invoice_Page;
	}
	//business libraries
	public void Manuf_Manage_Stock(WebDriver driver,int quantity,String name)
	{
		ManageStock_Page.click();
   
    WebElement ele = driver.findElement(By.xpath("//table[@class='table_displayData']//tbody//tr[*]/td[text()='"+name+"']/following-sibling::td[2]/input")); 
       ele.clear();
        ele.sendKeys(""+quantity+"");
        Update_Stock.click();
        acceptAlert(driver);
	
	}
	
	//"//table[@class='table_displayData']//tbody//tr[3]/td[text()='Sweet Onion Sauce']/following-sibling::td[2]/input[@name='txtQuantity[12]']"
	public void manuf_Orders()
	{
		Orders_Page.click();
	}
	
	public void manu_val_order(String Text)
	{
	     String actual = validate_order.getText();
	     assertEquals(actual, Text);
	 	System.out.println("order created by retailer is displayed");
//	     if(actual.contains(Text))
//         {
//         	System.out.println("order created by retailer is displayed");
//         }
//         else
//         {
//         	System.out.println("order created by retailer is not displayed");	
//         }
	}
	public void ConfirmationMSG(WebDriver driver)
	{
		Alert a1=driver.switchTo().alert();
	 	 String cfm = a1.getText();
	 	 System.out.println(cfm);
	 	 a1.accept();
		 
	}
}
