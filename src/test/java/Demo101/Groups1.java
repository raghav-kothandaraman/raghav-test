package Demo101;

import org.testng.annotations.Test;

public class Groups1 {
  @Test(groups= {"Regression","Smoke"})
  public void Lights() {
	  System.out.println("Code for Lights");
  }
  @Test(groups= {"Regression"})
  public void Camera() {
	  System.out.println("Code for Camera");
  }
  @Test(groups= {"Smoke"})
  public void Action() {
	  System.out.println("Code for Action");
  }
  @Test(groups= {"Smoke"})
  public void Actors() {
	  System.out.println("Code for Actors");
  }
  @Test(groups= {"Regression"})
  public void Crew() {
	  System.out.println("Code for Crew");
  }
}
