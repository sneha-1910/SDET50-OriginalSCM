package com.ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;

public class Manuf_HomePage extends WebDriverUtility{
    //declaration
	@FindBy(xpath="//table//tbody//tr[1]//td[@id='td_section']/section[contains(text(),'Welcome')]")
	private WebElement Home_page;
	
	@FindBy(linkText="Invoice")
	private WebElement Invoice_Tab;
	
	@FindBy(xpath="//select[@name='cmbFilter']")
	private WebElement Invoice_DropDown;
	
	@FindBy(xpath="//input[@name='txtInvoiceId']")
	private WebElement InvoiceID_InSeacrhBox;
	
	@FindBy(xpath="//input[@value='Search']")
	private WebElement Search_Button;
	
	@FindBy(xpath="//h1[text()='Invoices']")
	private WebElement Validtate_InvoiceDetails;
			
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement manuf_Logout;
	
	//initialization
	public Manuf_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getHome_page() {
		return Home_page;
	}

	public WebElement getValidtate_InvoiceDetails() {
		return Validtate_InvoiceDetails;
	}

	public WebElement getInvoice_DropDown() {
		return Invoice_DropDown;
	}

	public WebElement getInvoiceID_InSeacrhBox() {
		return InvoiceID_InSeacrhBox;
	}

	public WebElement getSearch_Button() {
		return Search_Button;
	}

	public WebElement getManuf_Logout() {
		return manuf_Logout;
	}

	public WebElement getInvoice_Tab() {
		return Invoice_Tab;
	}
	
	//business libraries
	public void ClickOnInvoiceTab()
	{
		Invoice_Tab.click();
	}
	public void InvoiceSearch(String Text,String ID)
	{
		Invoice_Tab.click();
		select( Text,Invoice_DropDown);
		InvoiceID_InSeacrhBox.sendKeys(ID);
		Search_Button.click();
	}
	
	public void ValidateInVoiceByID(String Text)
	{
	      String actual = Validtate_InvoiceDetails.getText();
	if(actual.contains(Text))
	{
		System.out.println("Invoices deatails are displayed");
	}
	else
	{
		System.out.println("Invoices deatails are not displayed");
	}
	
}
	public void Manuf_Logout()
	{
		manuf_Logout.click();
	}
	
	
}