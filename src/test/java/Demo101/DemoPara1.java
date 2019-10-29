package Demo101;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class DemoPara1 {
  @Test
  @Parameters({"city","name"})
  public void ft1(String city,String name) 
  {
	  System.out.println("1st");
	  System.out.println(city);
	  System.out.println(name);
  }
  @Test
  @Parameters({"city","name"})
  public void ft2(String city, String name)
  {
	  System.out.println("2nd");
	  System.out.println(city);
	  System.out.println(name);
  }
}
