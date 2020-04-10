package suiteA;

import org.testng.annotations.Test;

public class TestA1 {
  @Test
  public void f() throws InterruptedException 
  {
	  System.out.println("starting TestA1");
	  
	  Thread.sleep(2000);
	  
	  System.out.println("Ending TestA1");
  }
}
