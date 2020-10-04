package ProjectMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons extends Setup {

	protected RemoteWebDriver driver;
	
	public Commons(RemoteWebDriver driver) {
		// After creating a RemoteWebDriver, it assigns the driver we pass to this driver
		this.driver=driver;
	}	
	
	//Find the element using the locator and then after making sure the text field is clear, type the string that was passed in the text field
	public void typeValue(By locator, String value) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(value);
	}
	
	//Find the button. it makes sure it is clickable and then clicks it
	public void clickElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		driver.findElement(locator).click();
	}
	
	//Checks it an element is displayed or not.
	public boolean isDisplayed(By locator) {
		boolean availability;
		return availability = driver.findElement(locator).isDisplayed();		
	}
	
	//Gets the text from the element(textField). 
	public String getText(By locator) {
		String text = driver.findElement(locator).getText();
		return text;
	}
}
