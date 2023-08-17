package com.ObjectRepository_POM;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericUtility.WebDriverUtility;


public class admin_addR_addM_addD_Page extends WebDriverUtility {
	
	//declaration

	  @FindBy(linkText="Home")
	  private WebElement Home_page;
	
	  @FindBy(linkText="Add Retailers")
      private WebElement Addretailer;
	  
	  @FindBy(xpath = "//select[@name='cmbAreaCode']")
      private WebElement AreaCodeDD;
	  
	  @FindBy(xpath="//input[@value='Add Retailer']")
	  private WebElement AddRetailerSubmitBtn;
      
	  @FindBy(linkText="Distributors")
	  private WebElement Distributor_Tab;
	  
	  @FindBy(xpath="//h1[text()='View Distributor']")
	  private WebElement View_Distributor;
	  
      @FindBy(linkText="Add Distributor")
      private WebElement Adddistributors;
      
      @FindBy(linkText="Add Manufacturer")
      private WebElement Addmanufacturer;
      
      @FindBy(xpath="//input[@value='Add Manufacturer']")
      private WebElement AddManufacturer_Submitbtn;
      
      @FindBy(xpath="//input[@value='Log out']")
      private WebElement logout_button;
      
      @FindBy(xpath="//h2[text()='Recently Added Manufacturers']/following-sibling::table//tbody//tr[3]/td[2]")
       private WebElement Validate_ManufacturerName;
       
      //initialization
      public admin_addR_addM_addD_Page(WebDriver driver)
      {
    	  PageFactory.initElements(driver, this);
      }

     //utilization
      public WebElement getHome_page() {
  		return Home_page;
  	} 
	
       public WebElement getAddManufacturer_Submitbtn() {
		return AddManufacturer_Submitbtn;
	}

	public WebElement getValidate_ManufacturerName() {
		return Validate_ManufacturerName;
	}

	public WebElement getRetailer() {
		return Addretailer;
	}

	public WebElement getDistributors() {
		return Adddistributors;
	}

    public WebElement getDistributor_Tab() {
		return Distributor_Tab;
	}

	public WebElement getView_Distributor() {
		return View_Distributor;
	}

	public WebElement getAddretailer() {
		return Addretailer;
	}

	public WebElement getAddmanufacturer() {
		return Addmanufacturer;
	}

	public WebElement getAddRetailerSubmitBtn() {
		return AddRetailerSubmitBtn;
	}

	public WebElement getLogout_button() {
		return logout_button;
	}
     
	public WebElement getAreaCodeDD() {
		return AreaCodeDD;
	}

	
	//business libraries
	public void ClickonHomePage()
	{
		Home_page.click();
	}
    public void ClickonAddretailer(WebDriver driver) 
    {
    	mousehover(driver, Addretailer);
    	Addretailer.click();
    }
	public void ClickAndEnterAddretailerDetails(HashMap<String, String> map, WebDriver driver, String areacode)
	{   
		
		 Addretailer.click();
		 for(Entry<String, String> set:map.entrySet())
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
		 select(areacode, AreaCodeDD);
		 AddRetailerSubmitBtn.click();
		 acceptAlert(driver);
    }
	public void ManufacturerDetails(WebDriver driver,HashMap<String, String> map)
	{
	     //mousehover(driver,Addmanufacturer );
	     Addmanufacturer.click();
	     for(Entry<String, String> set:map.entrySet())
			{
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}
	    AddManufacturer_Submitbtn.click();
	    acceptAlert(driver);
	   System.out.println("manufacturer added");           
	}
	
	public void validateManufacturer(String Text)
	{
		  
          String actual = Validate_ManufacturerName.getText();
          assertEquals(actual, Text);
          System.out.println("newly added manufacturer displayed in HOMEPAGE");
//          if(actual.contains(Text))
//          {
//        	  System.out.println("newly added manufacturer displayed in HOMEPAGE");
//          }
//          else
//          {
//        	  System.out.println("newly added manufacturer is not displayed in HOMEPAGE");
//          }
	}
	public void Distributor(WebDriver driver)
	{
	   mousehover(driver,Distributor_Tab ); 
	   Distributor_Tab.click();
	}
	
	public void ValidateDistributorTab(String Text)
	{
	     String actual = View_Distributor.getText();
	     assertEquals(actual, Text);
	     System.out.println("distributor page is displayed");
//	     if(actual.contains(Text))
//         {
//       	  System.out.println("distributor page is displayed");
//         }
//         else
//         {
//       	  System.out.println("distributor page is not displayed");
//         }
	}
	

	
	public void ConfirmationMSG(WebDriver driver)
	{
		Alert a1=driver.switchTo().alert();
	 	 String cfm = a1.getText();
	 	 System.out.println(cfm);
	 	 a1.accept();
		 
	}
    public void LogOut()
    {
    	logout_button.click();
    }
      
}
