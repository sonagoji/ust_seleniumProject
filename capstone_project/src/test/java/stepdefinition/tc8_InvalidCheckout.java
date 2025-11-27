package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import pageObjects.checkoutPage;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc8_InvalidCheckout extends reportGenerator {

	checkoutPage checkoutpage = new checkoutPage(Hooks.getDriver());
	screenshots ss = new screenshots();
	
	@Then("error message is displayed")
	public void error_message_is_displayed() throws IOException {
//	    if(checkoutpage.getErrorMessage()) {
//	    	System.out.println("Invalid checkout successfull");
//	    }
//	    else {
//	    	System.out.println("unsuccessfull Invalid chckout");
//	    }
		logger=extent.startTest("Invalid Checkout");
		try {
			assertTrue(checkoutpage.getErrorMessage(),"Invalid checkout fails");
			assertTrue(checkoutpage.validatePostalCode(),"Validate postal code fails");
			logger.log(LogStatus.PASS, "Invalid checkout test is passed");
			Allure.step("Invalid checkout test is passed");
		}
		catch(AssertionError e) {
			logger.log(LogStatus.FAIL, "Invalid checkout test is failed");
			ss.takeScreenshot("Invalid_checkout");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
	}
}
