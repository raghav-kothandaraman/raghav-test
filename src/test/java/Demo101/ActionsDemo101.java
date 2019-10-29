package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo101 {
  WebDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
	  driver=MyDrivers.getDriver("CRM");
	  driver.get("http://demowebshop.tricentis.com/");
	  WebElement srch=driver.findElement(By.name("q"));
	  
	  Actions act1=new Actions(driver);
	  act1.keyDown(srch,Keys.SHIFT).sendKeys("computer").keyUp(Keys.SHIFT).build().perform();
	  Thread.sleep(3000);
	  act1.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
	  driver.close();
	  
	  
  }
}
