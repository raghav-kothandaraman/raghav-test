package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo104 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
	  driver=MyDrivers.getDriver("CRM");
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
//	  WebElement SRC=driver.findElement(By.xpath());
//	  WebElement DST=driver.findElement(By.xpath());
	  Actions act1=new Actions(driver);
//	  act1.dragAndDrop(SRC, DST);
	  
	  
  }
}
