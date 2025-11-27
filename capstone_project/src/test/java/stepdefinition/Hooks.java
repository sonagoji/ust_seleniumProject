package stepdefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void launchBrowser() {
		driver = new EdgeDriver();
		driver.get("https://saucedemo.com");
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
