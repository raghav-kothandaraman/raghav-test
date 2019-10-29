package Demo101;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class NewTest1 {
  @Test(dataProvider = "dp")
  public void f(String s1, String s2) throws InterruptedException {
	  
		WebDriver driver;
		driver=MyDrivers.getDriver("CRM");
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(1000);
		
		WebElement Uname=driver.findElement(By.name("userName"));
		Uname.sendKeys(s1);
		WebElement Pname=driver.findElement(By.name("password"));
		Pname.sendKeys(s2);
		WebElement sbmbtn=driver.findElement(By.name("login"));
		sbmbtn.click();
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "demo", "demo" },
      new Object[] { "tours", "tours" },
    };
  }
}
