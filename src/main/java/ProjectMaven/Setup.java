package ProjectMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Setup {

	// crates a driver object. (RemoteDriver so that it can be called from multiple classes)
	protected RemoteWebDriver driver;
	
	public RemoteWebDriver callDriver() {
		
		// Set up the property. gives the address of the browser to be accessed.
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\aah17\\My folder\\chromedriver_win32\\chromedriver.exe");
		// Assigns a chrome driver to the driver object.
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//It waits upto 30 sec for the drover to load up.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	//This method runs at the end of running each method
	@AfterMethod (alwaysRun=true)
	public void afterMethod(ITestResult itestResult) {
		if(itestResult.getStatus() == 1) {
			System.out.println("Testcase is passed");
		} else if(itestResult.getStatus() == 2) {
			System.out.println("Testcase is Failed");
		} else {
			System.out.println("Testcase is Skipped");
		}
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
}
