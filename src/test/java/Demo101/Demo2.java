package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\\\MyDrivers\\\\chromedriver_win32\\\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(1000);
		
		WebElement reg=driver.findElement(By.xpath("//a[text()='REGISTER']"));
		reg.click();
		
		WebElement cntry=driver.findElement(By.name("country"));
		Select Elt1=new Select(cntry);
		Elt1.selectByIndex(6);
		
		WebElement Uname=driver.findElement(By.xpath("//input[@name='email']"));
		Uname.sendKeys("ganesh");
		
		WebElement Pname=driver.findElement(By.xpath("//input[@name='password']"));
		Pname.sendKeys("gaitonde");
		
		WebElement Cpname=driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		Cpname.sendKeys("gaitonde");
		
		WebElement Sbmbtn=driver.findElement(By.xpath("//input[@name='register']"));
		Sbmbtn.click();
		
		driver.close();
		
	}

}
