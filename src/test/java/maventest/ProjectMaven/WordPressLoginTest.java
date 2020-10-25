package maventest.ProjectMaven;

import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.pageObjects.WordPressHomePageObjects;
import com.pageObjects.WordPressLoginPageObjects;

import ProjectMaven.Commons;
import ProjectMaven.PropertyReaderUtils;
import ProjectMaven.Setup;

public class WordPressLoginTest extends Setup {
	
	Commons commons;	
	
	public void initTest() {
		RemoteWebDriver driver = callDriver();
		super.driver=driver;
		commons = new Commons(driver);
	}
	
	WordPressLoginPageObjects wpPO = new WordPressLoginPageObjects();
	WordPressHomePageObjects wpHPPO = new WordPressHomePageObjects();
	
	@Test
	public void loginTest() {		
		
		//Initialize the driver
		initTest();
		
		//driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
		
		driver.get(PropertyReaderUtils.getProperty("url"));
		
		commons.typeValue(wpPO.loginField(), "opensourcecms");
		
		commons.typeValue(wpPO.pwdField(), "opensourcecms");
		
		commons.clickElement(wpPO.clickLogin());
		
		//Validate the display name is present
		//TestNG Assertions
		boolean value = commons.isDisplayed(wpHPPO.displayName());
		Assert.assertTrue(value);
		
		String text = commons.getText(wpHPPO.displayName());
		
		Assert.assertEquals("Checking the text of the display name", "opensourcecms", text);
		
		System.out.println("Commit through Eclipse");
		
		commons.clickElement(wpHPPO.siteCustomize());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} System.out.println(System.getProperty("user.dir"));
	}

}