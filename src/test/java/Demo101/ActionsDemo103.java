package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo103 {
	WebDriver driver;
  @Test
  public void f() 
  {
	  driver=MyDrivers.getDriver("CRM");
	  driver.get("https://www.google.com/");
	  
	  WebElement Gmail_lnk=driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a"));
	  Actions act1=new Actions(driver);
	  act1.contextClick(Gmail_lnk).build().perform();
	  
  }
}
