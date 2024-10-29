package Ty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cosmocode {

	
	public static void main(String[] args) throws Throwable, IOException  {
		// TODO Auto-generated method stub
		

		
		WebDriverManager.firefoxdriver().setup();
	     WebDriver driver=new FirefoxDriver();
	     driver.manage().window().maximize();
	  driver.get("https://cosmocode.io/automation-practice-webtable/");
	 
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     
	//     List<WebElement> ele = driver.findElements(By.xpath("//table//tbody//tr[*]//td[text()='English']/preceding-sibling::td[1]/preceding-sibling::td[2]"));//21 countries which is not having dollar
	//    List<WebElement> ele = driver.findElements(By.xpath("//table//tbody//tr[*]//td[text()='English']/preceding-sibling::td[contains(text(),'Dollar')]/preceding-sibling::td[2]"));// 14 countries only english
	     
	     
	     
       List<WebElement> ele = driver.findElements(By.xpath("//table//tbody//tr[*]//td[contains(text(),'English')]/preceding-sibling::td[contains(text(),'Dollar')]/preceding-sibling::td[2]"));
	     System.out.println(ele.size());
	     
	 
          
         for (WebElement countries : ele)
         {
			     String country = countries.getText();
		   System.out.println(country);
         
          
         FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DetailsOfCountry.xlsx");
         Workbook wb=WorkbookFactory.create(fis);
    
		wb.getSheet("Sheet1").createRow(1).createCell(1).setCellValue(country);
		
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\DetailsOfCountry.xlsx");
		wb.write(fos);
		wb.close();
         }
	} 
       }   
          
	


