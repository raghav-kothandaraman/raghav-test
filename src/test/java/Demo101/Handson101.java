package Demo101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Casestudypack.Drivers;

public class Handson101 {
  WebDriver driver;
  @Test
  public void f() throws IOException 
  {
	  File fin=new File("C:\\Users\\training_h2a.06.17\\Desktop\\LoginTest.xlsx");
	  FileInputStream FIS=new FileInputStream(fin);
	  XSSFWorkbook wb=new XSSFWorkbook(FIS);
	  XSSFSheet sh=wb.getSheetAt(0);
	  int T_rws=sh.getLastRowNum();
	  System.out.println(T_rws);
	  
	  driver=Drivers.getDriver("CRM");
	  driver.get("http://demowebshop.tricentis.com/");
	  for(int i=0;i<=T_rws;i++)
	  {
		  String Uname=sh.getRow(i).getCell(0).getStringCellValue();
		  String lname=sh.getRow(i).getCell(1).getStringCellValue();
		  String e_mail=sh.getRow(i).getCell(2).getStringCellValue();
		  String pwd=sh.getRow(i).getCell(3).getStringCellValue();
		  String cpwd=sh.getRow(i).getCell(4).getStringCellValue();
		  String gen=sh.getRow(i).getCell(5).getStringCellValue();
		  driver.findElement(By.xpath("//a[@href='/register']")).click();
		  if(gen.equals("M"))
		  {
			  driver.findElement(By.xpath("//input[@value='M']")).click();
		  }
		  else
		  {
			  driver.findElement(By.xpath("//input[@value='F']")).click();
		  }
		  driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(Uname);
		  driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(lname);
	      driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(e_mail);
	      driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
	      driver.findElement(By.xpath("//input[@name='ConfirmPassword']")).sendKeys(cpwd);
	  	  driver.findElement(By.xpath("//input[@name='register-button']")).click();
	  	  driver.findElement(By.xpath("//a[@href='/logout']")).click();
	  	  driver.findElement(By.xpath("//a[@href='/login']")).click();
	  	  driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(e_mail);
	  	  driver.findElement(By.xpath("//input[@name='Password']")).sendKeys(pwd);
	  	  driver.findElement(By.xpath("//input[@value='Log in']")).click();
	  	  driver.findElement(By.xpath("//a[@href='/logout']")).click();
	  	  Assert.assertEquals("Demo Web Shop", driver.getTitle());
	  	  sh.getRow(i).createCell(6).setCellValue("Valid");
	  	  FileOutputStream fout=new FileOutputStream(new File("C:\\\\Users\\\\training_h2a.06.17\\\\Desktop\\\\LoginTest.xlsx"));
		  wb.write(fout);
  }
	  wb.close();
}
}
