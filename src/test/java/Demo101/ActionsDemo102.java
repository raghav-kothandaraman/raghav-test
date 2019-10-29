package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsDemo102 {
	WebDriver driver;
  @Test
  public void f() 
  {
	  driver=MyDrivers.getDriver("CRM");
	  driver.get("https://www.spicejet.com");
	  WebElement Elt1=driver.findElement(By.name("ctl00$mainContent$ddl_originStation1"));
	  WebElement Elt2=driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]"));
	  WebElement Elt3=driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_chk_friendsandfamily\"]"));
	  System.out.println(Elt1.isDisplayed());
	  System.out.println(Elt2.isEnabled());
	  System.out.println(Elt3.isSelected());
	  
  }
}
