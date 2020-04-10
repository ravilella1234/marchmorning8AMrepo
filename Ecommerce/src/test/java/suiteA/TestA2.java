package suiteA;

import org.testng.annotations.Test;

public class TestA2 
{
	
  @Test
  public void f() throws InterruptedException 
  {
	  System.out.println("starting TestA2");
	  
	  Thread.sleep(2000);
	  
	  System.out.println("Ending TestA2");
  }
}
