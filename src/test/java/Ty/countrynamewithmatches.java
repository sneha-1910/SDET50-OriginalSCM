package Ty;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class countrynamewithmatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		
		List<WebElement> name = driver.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		//System.out.println(name.size());
		
	  List<WebElement> match = driver.findElements(By.xpath("//span[@class='u-hide-phablet']/../following-sibling::td[1][text()>30]"));
	 // System.out.println(match.size());
	  
		for(int i=0;i<match.size();i++)
		{
			System.out.println(name.get(i).getText()+"="+match.get(i).getText());
		}
		
	}

}
