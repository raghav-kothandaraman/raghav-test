package Demo101;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver PRTY;
		System.setProperty("webdriver.chrome.driver","C:\\MyDrivers\\chromedriver_win32\\chromedriver.exe");
		PRTY=new ChromeDriver();
		PRTY.get("http://10.232.237.143:443/TestMeApp/");
		Thread.sleep(1000);
		WebElement Signinlink=PRTY.findElement(By.linkText("SignIn"));
		Signinlink.click();
		WebElement Uname=PRTY.findElement(By.name("userName"));
		Uname.sendKeys("lalitha");
		WebElement Pass=PRTY.findElement(By.name("password"));
		Pass.sendKeys("Password123");
		WebElement Sbmbtn=PRTY.findElement(By.name("Login"));
		Sbmbtn.click();
		String A_title=PRTY.getTitle();
		String E_title="Home";
		//Assert.assertEquals(A_title,E_title);
		if(A_title.equals(E_title))
			System.out.println("Success");
		else
		System.out.println("SignIn successful");
		PRTY.close();
		
	}

}
