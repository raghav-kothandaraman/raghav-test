package Casestudypack;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Demo101.MyDrivers;
import junit.framework.Assert;

public class OnlineShoppingTest {
	WebDriver driver;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void startReportBeforeTest()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport123.html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
	}
	
	
	@Test(priority=1)
	  public void testRegistration() throws InterruptedException {
			
			test = extent.createTest("TC_01", "Application Accessibility");
		  
		  driver=Drivers.getDriver("CRM");
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[2]/a")).click();
		  WebElement  wb1= driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		  Actions act1=new Actions(driver);
		act1.keyDown(wb1,Keys.ALT).sendKeys("kakak134671").keyUp(Keys.ALT).sendKeys(Keys.ENTER).build().perform();
		
		System.out.println("ffff");
		WebElement wb2=driver.findElement(By.xpath("//*[@id='err']"));
		String s1=wb2.getText();
		System.out.println(s1);
		if (s1.equals("Available"))
		{
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("Ganesha");
			driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("Gaitonde");
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Gaitonde123");
			driver.findElement(By.xpath("//*[@id=\"pass_confirmation\"]")).sendKeys("Gaitonde123");
			driver.findElement(By.xpath("//input[@value='Male']")).click();
			driver.findElement(By.xpath("//*[@id=\"emailAddress\"]")).sendKeys("ganesh@gmail.com");
			driver.findElement(By.xpath("//*[@id=\"mobileNumber\"]")).sendKeys("7894561236");
			driver.findElement(By.xpath("//img[@title='Ch']")).click();
			WebElement month=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]"));
			Select sell=new Select(month);
			sell.selectByIndex(6);
			WebElement year=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]"));
			Select sell1=new Select(year);
			sell1.selectByIndex(15);
			driver.findElement(By.xpath("//a[text()='23']")).click();
			driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("hgdsssdcvdsc");
			WebElement ele=driver.findElement(By.xpath("//*[@id=\"securityQuestion\"]"));
			ele.click();

			act1.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();
			
			driver.findElement(By.xpath("//*[@id=\"answer\"]")).sendKeys("KITTU");
			driver.findElement(By.xpath("//input[@name='Submit']")).click();
		
		}
		else
		{
			System.out.println("Already Exist");
		}
		
		System.out.println(s1);
		
	 
		
		}
		
  
  @Test(priority=2)
  public void testLogin() throws InterruptedException
  {
//	  driver=Drivers.getDriver("CRM");
//	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
//	  driver.manage().window().maximize();
//	  driver.findElement(By.xpath("//a[@href='login.htm']")).click();
	  test=extent.createTest("Test Case 2", "Login");
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("kakak134671");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Gaitonde123");
	  driver.findElement(By.xpath("//input[@name='Login']")).click();
	  Assert.assertEquals("Home", driver.getTitle());
	  
  }
  @Test(priority=3)
  public void testCart() throws InterruptedException
  {
//	  driver=Drivers.getDriver("CRM");
//	  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
//	  driver.manage().window().maximize();
	  test=extent.createTest("Test Case 3", "Cart");
	  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/a/span")).click();;
	  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[2]/ul/li[1]/a/span")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//span[text()='Travel Kit']")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("/html/body/section/div/div/div[2]/div/div/div/div[2]/center/a")).click();
	  driver.findElement(By.xpath("//a[@href='displayCart.htm']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[@href='checkout.htm']")).click();
	  Thread.sleep(2000);
	  
  }
  @Test(priority=4)
  public void testPayment() throws InterruptedException
  {
	  test=extent.createTest("Test Case 4", "Payment");
	  driver.findElement(By.xpath("//input[@value='Proceed to Pay']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@id=\"swit\"]/div[1]/div/label/i")).click();
	  driver.findElement(By.xpath("//a[text()='Continue']")).click();
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Pass@456");
	  driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
	  driver.findElement(By.xpath("//input[@name='transpwd']")).sendKeys("Trans@456");
	  driver.findElement(By.xpath("//input[@value='PayNow']")).click();
	  Assert.assertEquals("Order Details", driver.getTitle());
	  driver.findElement(By.xpath("//a[@href='logout.htm']")).click();
	  Thread.sleep(5000);
	  Assert.assertEquals("Home", driver.getTitle());
  }
  @AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
	  if(result.getStatus() == ITestResult.FAILURE) {
          test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
         
          TakesScreenshot snapshot =   (TakesScreenshot)driver;
          File src = snapshot.getScreenshotAs(OutputType.FILE);
          String Path = System.getProperty("user.dir") +"/test-output/screens/"+result.getName()+".png";
          FileUtils.copyFile(src, new File(Path));
          test.addScreenCaptureFromPath(Path, result.getName());
          test.fail(result.getThrowable());
      }
      else if(result.getStatus() == ITestResult.SUCCESS) {
          test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
      }
      else {
          test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
          test.skip(result.getThrowable());
	}
		
	}
  @AfterTest
	public void endReportAfterTest()
	{
	  extent.flush();
	}
}
