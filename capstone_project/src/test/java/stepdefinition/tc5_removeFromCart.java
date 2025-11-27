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

public class tc5_removeFromCart extends reportGenerator {
	
	cartPage cartpage = new cartPage(Hooks.getDriver());
	screenshots ss= new screenshots();
	
	@When("user removes {string} from cart")
	public void user_removes_from_cart(String pname) throws InterruptedException {
		cartpage.addToCart(pname);
	    cartpage.removeFromCart(pname);	}
	
	
	@Then("{string} is removed and cart icon becomes {string}")
	public void is_removed_and_cart_icon_becomes(String pname,String no) throws IOException {
//		if(cartpage.isProductNotInCart(pname,no)) {
//	    	System.out.println("removal success........");
//	    }
//	    else {
//	    	System.out.println("removal not success....... ");
//	    }
		logger=extent.startTest("Remove from cart");
		try {
			assertTrue(cartpage.isProductNotInCart(pname, no),"Removal from cart fails");
			logger.log(LogStatus.PASS, "Remove from cart test is passed");
			Allure.step("Remove from cart test is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("removeFromCart");
			logger.log(LogStatus.FAIL, "remove from cart test is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
	}

}
