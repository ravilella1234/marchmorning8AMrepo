package suiteB;

import org.testng.annotations.Test;

public class TestB3 {
  @Test
  public void f() throws InterruptedException 
  {
	  System.out.println("starting TestB3");
	  
	  Thread.sleep(2000);
	  
	  System.out.println("Ending TestB3");
  }
}
