package ProjectMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Setup {

	// crates a driver object. (RemoteDriver so that it can be called from multiple
	// classes)
	protected RemoteWebDriver driver;

	public RemoteWebDriver callDriver() {

		String browser = PropertyReaderUtils.getProperty("browser");
		System.out.println("Browser returned : " + browser);

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\aah17\\My folder\\chromedriver_win32\\chromedriver.exe");

			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\aah17\\My folder\\geckodriver-v0.27.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\aah17\\My folder\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equals("Edge")) {
			// Assignment - Setup the Driver for Edge & Launch
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\aah17\\My folder\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		return driver;

	}

	// This method runs at the end of running each method
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) {
		if (itestResult.getStatus() == 1) {
			System.out.println(itestResult.getStatus());
			System.out.println("Testcase is passed");
		} else if (itestResult.getStatus() == 2) {
			System.out.println(itestResult.getStatus());
			System.out.println("Testcase is Failed");
		} else {
			System.out.println("Testcase is Skipped");
		}
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
