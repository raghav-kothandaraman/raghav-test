package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fblogin {

	public static void main(String[] args) 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\MyDrivers\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		WebElement f_name=driver.findElement(By.name("firstname"));
		f_name.sendKeys("Ganesh");
		
		WebElement l_name=driver.findElement(By.name("lastname"));
		l_name.sendKeys("Gaitonde");
		
		WebElement m_e=driver.findElement(By.name("reg_email__"));
		m_e.sendKeys("73********");
		
		WebElement pwd=driver.findElement(By.name("reg_passwd__"));
		pwd.sendKeys("ganeshgaitonde@gmail.com");
		
		WebElement bdate=driver.findElement(By.name("birthday_day"));
		Select Elt1=new Select(bdate);
		Elt1.selectByIndex(6);
		
		WebElement bmonth=driver.findElement(By.name("birthday_month"));
		Select Elt2=new Select(bmonth);
		Elt2.selectByIndex(6);
		
		WebElement byear=driver.findElement(By.name("birthday_year"));
		Select Elt3=new Select(byear);
		Elt3.selectByVisibleText("1997");
		
		WebElement gender=driver.findElement(By.xpath("//input[@value='2']"));
		gender.click();
		
		WebElement sbmbt=driver.findElement(By.name("websubmit"));
		sbmbt.click();
		
	}

}
