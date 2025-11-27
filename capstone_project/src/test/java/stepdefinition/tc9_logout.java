package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc9_logout extends reportGenerator {

	WebDriver driver;
	screenshots ss = new screenshots();
	
	@When("user clicks logout")
	public void user_clicks_logout() throws InterruptedException {
	    Hooks.driver.findElement(By.id("react-burger-menu-btn")).click();
	    Thread.sleep(2000);
	    Hooks.driver.findElement(By.id("logout_sidebar_link")).click();
	    logger=extent.startTest("Logout");
	}
	
	@Then("user navigated to login page")
	public void user_navigated_to_login_page() throws IOException {
	    try {
	    	assertTrue(Hooks.getDriver().getCurrentUrl().equals("https://www.saucedemo.com/"),"Logout fails");
	    	logger.log(LogStatus.PASS, "Logout test is passed");
	    	Allure.step("Logout test is passed");
	    	
	    }
	    catch(AssertionError e) {
	    	ss.takeScreenshot("Logout");
	    	logger.log(LogStatus.FAIL, "Logout test is failed");
	    	Allure.addAttachment("screenshot taken successfully", e.getMessage());
	    }
	    extent.endTest(logger);
	}

}
