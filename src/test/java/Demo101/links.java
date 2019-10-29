package Demo101;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class links {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(1000);


		List<WebElement> T_links=driver.findElements(By.tagName("a"));
		int cnt_links=T_links.size();
		System.out.println(cnt_links);
		
		for(int i=0;i<cnt_links;i++)
		{
			String lnk_txt=T_links.get(i).getText();
			System.out.println(lnk_txt);
			
		}
	}

}
