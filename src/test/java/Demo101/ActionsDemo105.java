package Demo101;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ActionsDemo105 {
	WebDriver driver;
  @Test
  public void f() throws InterruptedException 
  {
	  driver=MyDrivers.getDriver("CRM");
	  driver.get("https://www.spicejet.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
	  
	  
  }
}
