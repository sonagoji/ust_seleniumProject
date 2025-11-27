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

public class tc2_invalidLogin extends reportGenerator {
	
	loginPage loginpage;
	screenshots ss = new screenshots();
	
	@Given("the user in the login page")
	public void the_user_in_the_login_window() {
	    loginpage = new loginPage(Hooks.getDriver());
	}
	
	@When("the user enters invalid {string} and invalid {string}")
	public void the_user_enters_invalid_and_invalid(String name, String password) {
		loginpage.enterUsername(name);
		loginpage.enterPassword(password);
		loginpage.clickLogin();
	}
	
	
	@Then("the user gets error message {string}")
	public void the_user_gets_error_message(String expError) throws IOException {
	    boolean s = loginpage.getErrorMessage(expError);
	    logger=extent.startTest("Invalid login");
		try {
			assertTrue(s,"Login fails");
			logger.log(LogStatus.PASS, "Invalid login test is passed");
			Allure.step("Invalid login test is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("invalidLogin");
			logger.log(LogStatus.FAIL, "Invalid login test is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
	}

}
