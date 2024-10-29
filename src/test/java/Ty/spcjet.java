package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class spcjet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
	    ChromeOptions opt=new ChromeOptions();
		//	opt.addArguments("--disable-geolocations");
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		
		
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	 // driver.findElement(By.xpath("//div[text()='round trip']")).click();
	   driver.findElement(By.xpath("//div[text()='one way']")).click();
		Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='From']")).sendKeys("Bengaluru");
         System.out.println("from");
        WebElement ele2 = driver.findElement(By.xpath("//div[text()='To']"));
        ele2.sendKeys("Delhi");
         driver.findElement(By.xpath("//div[text()='Departure Date']")).click();
         
         String month="October ";
         String date="11";
        WebElement ele = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz']/descendant::div[text()='"+month+"']/../following-sibling::div[@class='css-1dbjc4n']/descendant::div[text()='"+date+"']"));
         ele.click();
       // System.out.println(ele.getText());
         Thread.sleep(2000);
//        driver.findElement(By.xpath("//div[text()='Return Date']")).click();
//         Thread.sleep(3000);
//     WebElement ele1 = driver.findElement(By.xpath("//div[text()='November ']/../../div[@class='css-1dbjc4n']//div//div//div[text()='2']"));
//      System.out.println(ele1.getText());
//       Thread.sleep(2000);
//     
        driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
        Thread.sleep(2000);
     
		
		
		
		
		
		
		
	}

}