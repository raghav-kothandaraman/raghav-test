package Demo101;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo {
  @Test
  public void f() throws IOException 
  {
	  File fin=new File("C:\\Users\\training_h2a.06.17\\Desktop\\TestExcel.xlsx");
	  FileInputStream FIS=new FileInputStream(fin);
	  XSSFWorkbook wb=new XSSFWorkbook(FIS);
	  XSSFSheet sh=wb.getSheetAt(0);
	  int T_rws=sh.getLastRowNum();
	  System.out.println(T_rws);
	  for(int i=0;i<=T_rws;i++)
	  {
		  String Uname=sh.getRow(i).getCell(0).getStringCellValue();
		  System.out.println(Uname);
		  String pwd=sh.getRow(i).getCell(1).getStringCellValue();
		  System.out.println(pwd);
		  sh.getRow(i).createCell(2).setCellValue("Valid");
		  FileOutputStream fout=new FileOutputStream(new File("C:\\Users\\training_h2a.06.17\\Desktop\\TestExcel.xlsx"));
		  wb.write(fout);
	  }
	  wb.close();
	  
  }
}
