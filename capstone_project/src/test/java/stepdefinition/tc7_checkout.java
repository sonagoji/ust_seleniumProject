package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.cartPage;
import pageObjects.checkoutPage;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc7_checkout extends reportGenerator  {
	
	WebDriver driver;
	cartPage cartpage = new cartPage(Hooks.getDriver());
	checkoutPage checkoutpage = new checkoutPage(Hooks.getDriver());
	screenshots ss = new screenshots();
	
	@Given("the user adds {string} to cart")
	public void the_user_adds_to_cart(String pname) throws InterruptedException {
	    cartpage.addToCart(pname);
	    Hooks.driver.findElement(By.id("shopping_cart_container")).click();
	    Hooks.driver.findElement(By.id("checkout")).click();
	    Thread.sleep(2000);
	    
	}
	
	@When("he proceeds to checkout with firstname {string} lastname as {string} and postal code as {string}")
	public void he_proceeds_to_checkout_with_firstname_lastname_as_and_postal_code_as(String fname, String lname, String postal) {
	    checkoutpage.enterAddress(fname, lname, postal);
	}
	
	@Then("order confirmation is displayed")
	public void order_confirmation_is_displayed() throws IOException {
//	   if(checkoutpage.isSuccessfull()) {
//		   System.out.println("successfull checkout........");
//	   }
//	   else {
//		   System.out.println("Checkout failed.....");
//	   }
		logger=extent.startTest("Checkout");
		try {
			assertTrue(checkoutpage.isSuccessfull(),"Checkout failed");
			logger.log(LogStatus.PASS, "Checkout test is passed");
			Allure.step("Checkout test is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("Checkout");
			logger.log(LogStatus.FAIL, "Checkout test is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
			throw e;
		}
	}
}
