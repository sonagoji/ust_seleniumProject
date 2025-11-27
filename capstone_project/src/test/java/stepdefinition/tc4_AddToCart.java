package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.cartPage;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc4_AddToCart extends reportGenerator{

	cartPage cartpage = new cartPage(Hooks.getDriver());
	screenshots ss = new screenshots();
	
	@When("user adds {string} to the cart")
	public void user_adds_to_the_cart(String pname) throws InterruptedException {
	    cartpage.addToCart(pname);
	}
	
	@Then("{string} should be added to cart and the cart icon should show {string}")
	public void should_be_added_to_cart(String pname,String no) throws IOException {
//	    if(cartpage.isProductInCart(pname,no)) {
//	    	System.out.println("adding Success");
//	    }
//	    else {
//	    	System.out.println("Not added");
//	    }
		logger=extent.startTest("Add to cart");
		try {
				assertTrue(cartpage.isProductInCart(pname,no),"Not added to cart");
				logger.log(LogStatus.PASS, "Add to cart test is passed");
				Allure.step("Add to cart test is passed");
		}catch(AssertionError e) {
			ss.takeScreenshot("add_to_cart");
			logger.log(LogStatus.FAIL, "Add to cart test is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
		
		
	}
	
}
