package Ty;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class kabaddi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String played = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-play']/p[@class='count']")).getText();
		String won = driver.findElement(By.xpath("//p[text()='Jaipur Pink Panthers']/ancestor::div[@class='table-data team']/following-sibling::div[@class='table-data matches-won']/p[@class='count']")).getText();
		
		System.out.println(played+ " played " +won+ " won ");
		
		
	}

}
