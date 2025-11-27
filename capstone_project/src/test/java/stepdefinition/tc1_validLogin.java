package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.loginPage;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc1_validLogin extends reportGenerator {

	screenshots ss = new screenshots();
	loginPage loginpage;
	
	@Given("the user in the login window")
	public void the_user_in_the_login_window() {
	    loginpage = new loginPage(Hooks.getDriver());
	}
	
	
	@When("user enters valid {string} and valid {string}")
	public void user_enters_valid_and_valid(String name, String password) {
		loginpage.enterUsername(name);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
	}
	
	
	@Then("user is navigated to products page")
	public void user_is_navigated_to_products_page() throws IOException {
		boolean s=loginpage.isProductPageDisplayed();
		logger = extent.startTest("Valid Login");
		try {
			assertTrue(s,"Login fails");
			logger.log(LogStatus.PASS, "Valid login test is passed");
			Allure.step("Valid login test is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("login");
			logger.log(LogStatus.FAIL, "Valid login test is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
	}

}
