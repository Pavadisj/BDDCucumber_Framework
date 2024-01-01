package hooks;

import io.cucumber.java.*;

public class MyHooks {

	
	@BeforeStep(order=2)
	public void takesScrenShot() {
		System.out.println("Browser closed");
		
	}
	
	@BeforeStep(order=1)
	public void takesSrenShot() {
		System.out.println("Browser closed");
		
	}
	
	@Before("@Smoke") // Taggled hooks 
	public void openBrowser() {
		
		System.out.println("Browser opened");
		
	}
	

	@Before // global hooks 
	public void openBrowser2() {
		
		System.out.println("Browser opened");
		
	}
	
	
	
	@After //global hooks
	public void closeBrowser() {
		System.out.println("Browser closed");
		
	}
	
	
	@AfterStep
	public void takesScreenShot() {
		System.out.println("Browser closed");
		
	}
	
	
	
}
