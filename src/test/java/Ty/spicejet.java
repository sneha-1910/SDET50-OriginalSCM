package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class spicejet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				
				ChromeOptions option= new ChromeOptions();
				
				option.addArguments("--disable-notifications");	
				 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
				WebDriver driver= new ChromeDriver(option);
				
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.manage().window().maximize();
				driver.get("https://www.spicejet.com/");
				WebElement way= driver.findElement(By.xpath("//div[text()='round trip']"));
				String wayR=way.getText();
				way.click();
				String fromLoc="Bengaluru";
				String toLoc="Chennai";
				driver.findElement(By.xpath("//div[text()='From']")).sendKeys(fromLoc);
				System.out.println("from");
				driver.findElement(By.xpath("//input[@value='Select Destination']")).sendKeys(toLoc);
				System.out.println("to");
				int fromDate=4;
				int toDate=5;
				driver.findElement(By.xpath("//div[text()='October ']/../following-sibling::div/div/div/div/div[text()='"+fromDate+"']")).click();
				driver.findElement(By.xpath("//div[text()='October ']/../following-sibling::div/div/div/div/div[text()='"+toDate+"']")).click();
				
				driver.findElement(By.xpath("(//div[.='Search Flight'])[3]")).click();
				String round=driver.findElement(By.xpath("//span[text()='Round Trip :']/../..")).getText();
				System.out.println(round);
				
				boolean fromL=round.contains(fromLoc);
				boolean toL= round.contains(toLoc);
				boolean ways=round.contains(wayR);
				Assert.assertTrue(fromL);
				Assert.assertTrue(toL);
				Assert.assertTrue(ways);
				System.out.println("all things are verified");
				
				
//				if(round.contains(fromLoc)) {
//					System.out.println("from location is verified");
//				}
//				if(round.contains(toLoc)) {
//					System.out.println("to Location is verified");
//					}
//				if(round.contains(wayR)) {
//					System.out.println("way is confirmed");
//					}
//				
				
	
	}

}
