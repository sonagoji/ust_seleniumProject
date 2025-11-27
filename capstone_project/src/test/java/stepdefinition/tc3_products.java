package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import pageObjects.productsPage;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc3_products extends reportGenerator{
	
	productsPage productpage = new productsPage(Hooks.getDriver());
	screenshots ss = new screenshots();
	
	@Then("the product page title is verified")
	public void the_product_page_title_is_verified() throws IOException {
//		if(productpage.verifyTitle()) {
//			System.out.println("Title verified");
//		}
//		else {
//			System.out.println("Title not verified");
//		}
		logger = extent.startTest("Product page title");
		try {
			assertTrue(productpage.verifyTitle(),"Title incorrect");
			logger.log(LogStatus.PASS,"Product page title test is passed" );
			Allure.step("Product page title test is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("title");
			logger.log(LogStatus.FAIL, "Product page title test is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
	    
	}
	
	@Then("the product list is verified")
	public void the_product_list_is_verified() throws IOException {
//		if(productpage.isProductListDisplayed()) {
//			System.out.println("product list verified");
//		}
//		else {
//			System.out.println("product list not verified");
//		}
		logger = extent.startTest("Products listing");
	    try {
	    	assertTrue(productpage.isProductListDisplayed(),"Products not listed");
	    	logger.log(LogStatus.PASS,"Products listing test is passed" );
	    	Allure.step("Products listing test is passed");
	    }
	    catch(AssertionError e) {
	    	ss.takeScreenshot("product_list");
	    	logger.log(LogStatus.FAIL,"Products listing test is failed" );
	    	Allure.addAttachment("screenshot taken successfully", e.getMessage());
	    }
	    extent.endTest(logger);
	}
	
	@Then("the product details is verified")
	public void the_product_details_is_verified() throws IOException {
		
//		if(productpage.productDetails()) {
//			System.out.println("product details verified");
//		}
//		else {
//			System.out.println("product details not verified");
//		}
		logger = extent.startTest("Product details");
		try {
	    	assertTrue(productpage.productDetails(),"Product details not displayed");
	    	logger.log(LogStatus.PASS,"Product details test is passed" );
	    	Allure.step("Product details test is passed");
	    }
	    catch(AssertionError e) {
	    	ss.takeScreenshot("product_details");
	    	logger.log(LogStatus.FAIL,"Product details test is failed" );
	    	Allure.addAttachment("screenshot taken successfully", e.getMessage());
	    }
		extent.endTest(logger);
	}

}
