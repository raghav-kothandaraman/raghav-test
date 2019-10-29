package Casestudypack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {

	public static WebDriver getDriver(String DrNm) 
	{
		if(DrNm.equals("CRM"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\\\MyDrivers\\\\chromedriver_win32\\\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(DrNm.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\MyDrivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else if(DrNm.equals("MF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\MyDrivers\\geckodriver-v0.26.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else
		return null;
	}

}

