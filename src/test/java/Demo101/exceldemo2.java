package Demo101;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class exceldemo2 {
  @Test
  public void f() throws IOException 
  {
	  XSSFWorkbook wb=new XSSFWorkbook();
	  FileOutputStream fout=new FileOutputStream(new File("Sampledoc.xlsx"));
	  wb.write(fout);
	  wb.close();
  }
}
