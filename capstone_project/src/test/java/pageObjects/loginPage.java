package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterUsername(String username) {
		driver.findElement(By.id("user-name")).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(By.id("login-button")).click();
	}
	
	public boolean isProductPageDisplayed() {
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")) {
			return true;
		}
		return false;
	}
	
	public boolean getErrorMessage(String expError) {
		return driver.findElement(By.cssSelector("h3[data-test='error']")).getText().equals(expError);
	}

}
