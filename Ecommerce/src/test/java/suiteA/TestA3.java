package suiteA;

import org.testng.annotations.Test;

public class TestA3 
{
	
  @Test
  public void f() throws InterruptedException 
  {
	  System.out.println("starting TestA3");
	  
	  Thread.sleep(2000);
	  
	  System.out.println("Ending TestA3");
  }
}
