package Demo101;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Frame1 {
  WebDriver driver;
	@Test
  public void f() throws InterruptedException 
	{
		driver=MyDrivers.getDriver("CRM");
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.switchTo().frame(driver.findElement(By.name("iframeResult")));
		driver.findElement(By.xpath("//button[text()='try it']")).click();
		Thread.sleep(3000);
		if(ExpectedConditions.alertIsPresent()!=null)
		{
			Alert altr1=driver.switchTo().alert();
			altr1.accept();
		}
		driver.switchTo().defaultContent();
		String A_text=driver.findElement(By.xpath("//span[text()='JavaScript Alert']")).getText();
		System.out.println(A_text);
		driver.close();
  }
}
