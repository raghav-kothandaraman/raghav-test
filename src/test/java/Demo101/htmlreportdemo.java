package Demo101;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class htmlreportdemo
{
	WebDriver driver;
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void startReport()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/testReport23.html");
		extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test report");
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        
	}
	@Test
	public void login()
	{
		test=extent.createTest("Test Case 1", "Login Validation");
		driver=MyDrivers.getDriver("CRM");
		driver.get("https://www.google.com/");
		String Elt1=driver.getTitle();
		Assert.assertEquals("GANESH",Elt1);
	}
	@Test
	public void search1()
	{
		test=extent.createTest("Test Case 2", "Search Validation");
		Assert.assertTrue(true);
	}
	@Test
	public void cart1()
	{
		test=extent.createTest("Test Case 3", "Cart Validation");
		Assert.assertTrue(false);
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
    public void tearDown() {
         //to write or update test information to reporter
        extent.flush();
    }
	
}