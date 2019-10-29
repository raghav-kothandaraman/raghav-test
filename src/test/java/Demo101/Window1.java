package Demo101;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Window1 {
  @Test
  public void f() throws InterruptedException {
	  WebDriver driver;
	  System.setProperty("webdriver.chrome.driver", "C:\\MyDrivers\\chromedriver_win32\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  driver.get("https://retail.onlinesbi.com/retail/login.htm");
	  String P_win=driver.getWindowHandle();
	  System.out.println("Parent Window String ID is: " +P_win);
	  Thread.sleep(2000);
	  driver.findElement(By.linkText("Forms")).click();
	  Set<String> T_win=driver.getWindowHandles();
	  for(String S:T_win)
	  {
		  driver.switchTo().window(S);
		  System.out.println(driver.getWindowHandle());
	  }
	  driver.findElement(By.id("login_inner")).click();
	  Thread.sleep(5000);
	  driver.close();
	  driver.quit(); 
  }
}
