package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginMethodsPF {
 
	@FindBy(name = "username")
	@CacheLookup //since I'm sure these references won't change in future, I want selenium to cache it locally instead of having to go to the page and read it again
	WebElement txtUsername;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	WebElement btnSignIn; 
	
	WebDriver driver;
	
	//constructor
	public loginMethodsPF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //this is a reference of this instance and need to put it always in each constructor
	}
	
	public void enterUsernamePassword(String username, String password) throws InterruptedException {
		txtUsername.sendKeys("dahiana.rodriguez@vantageelevation.com");
		txtPassword.sendKeys("Welcome2022$$");
		Thread.sleep(2000);
		btnSignIn.click();
		Thread.sleep(3000);
	}
	
	
}
