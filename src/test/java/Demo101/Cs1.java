package Demo101;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Cs1 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
	  driver=MyDrivers.getDriver("CRM");
	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm#");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/a/span")).click();;
	  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/a/span")).click();
	  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[3]/ul/li/ul/li[2]/a/span")).click();
	  Set<String> T_win=driver.getWindowHandles();
	  for(String S:T_win)
	  {
		  driver.switchTo().window(S);
		  System.out.println(driver.getWindowHandle());
	  }
	  driver.switchTo().frame(driver.findElement(By.name("main_page")));
	  WebElement Elt1=driver.findElement(By.tagName("address"));
	  String str=Elt1.getText();
	  System.out.println(str);
	  
	  
	  
	  
	  
	  
  }
}
