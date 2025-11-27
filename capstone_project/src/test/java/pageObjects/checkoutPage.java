package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutPage {

	WebDriver driver;
	
	public checkoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterAddress(String fname,String lname,String postal) {
		driver.findElement(By.id("first-name")).sendKeys(fname);
		driver.findElement(By.id("last-name")).sendKeys(lname);
		driver.findElement(By.id("postal-code")).sendKeys(postal);
		driver.findElement(By.id("continue")).click();
		
	}
	
	public boolean isSuccessfull() {
		driver.findElement(By.id("finish")).click();
		return driver.findElement(By.className("complete-header")).getText().equals("Thank you for your order!");
	}

	public boolean validatePostalCode() {
		String postal = driver.findElement(By.id("postal-code")).getAttribute("value");
		return postal.matches("\\d{6}");
		
	}

	public boolean getErrorMessage() {
		try {
			return driver.findElement(By.cssSelector("h3[data-test='error']")).getText().contains("Error");
		}
		catch(Exception e) {
			return false;
		}
		
	}
}
