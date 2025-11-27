package stepdefinition;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import pageObjects.productsPage;
import utilities.reportGenerator;
import utilities.screenshots;

public class tc6_filter extends reportGenerator {

	productsPage productpage = new productsPage(Hooks.getDriver());
	screenshots ss = new screenshots();
	
	@When("user selects filter {string}")
	public void user_selects_filter(String filter) {
	    productpage.selectFilter(filter);
	}
	
	@Then("products displayed in alphabetical order")
	public void products_displayed_in_alphabetical_order() throws IOException {
//	    if(productpage.isAscending()) {
//	    	System.out.println("Ascending trueeee");
//	    }
//	    else {
//	    	System.out.println("Ascending falsee");
//	    }
		
		logger = extent.startTest("Filter A to Z");
		try {
			assertTrue(productpage.isAscending(),"Filter A to Z fails");
			logger.log(LogStatus.PASS, "Filter test A to Z is passed");
			Allure.step("Filter test A to Z is passed");
		}
		catch(AssertionError e) {
			logger.log(LogStatus.FAIL, "Filter test A to Z is failed");
			ss.takeScreenshot("Filter_AtoZ");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
		
	}
	
	@Then("products displayed in reverse alphabetical order")
	public void products_displayed_in_reverse_alphabetical_order() throws IOException {
//		if(productpage.isDescending()) {
//	    	System.out.println("Descending trueeee");
//	    }
//	    else {
//	    	System.out.println("Descending falsee");
//	    }
		logger = extent.startTest("Filter Z to A");
		try {
			assertTrue(productpage.isDescending(),"Filter Z to A fails");
			logger.log(LogStatus.PASS, "Filter test Z to A is passed");
			Allure.step("Filter test Z to A is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("Filter_ZtoA");
			logger.log(LogStatus.FAIL, "Filter test Z to A is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
	}
	
	@Then("products displayed in ascending price order")
	public void products_displayed_in_ascending_price_order() throws IOException {
//		if(productpage.isAscendingPrice()) {
//	    	System.out.println("Ascending trueeee");
//	    }
//	    else {
//	    	System.out.println("Ascending falsee");
//	    }
		logger = extent.startTest("Filter price low to high");
		try {
			assertTrue(productpage.isAscendingPrice(),"Filter price low to high fails");
			logger.log(LogStatus.PASS, "Filter test price low to high is passed");
			Allure.step("Filter test price low to high is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("Filter_price_lowToHigh");
			logger.log(LogStatus.FAIL, "Filter test price low to high is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
	    
	}
	
	@Then("products displayed in descending price order")
	public void products_displayed_in_descending_price_order() throws IOException {
//		if(productpage.isDescendingPrice()) {
//	    	System.out.println("Descending trueeee");
//	    }
//	    else {
//	    	System.out.println("Descending falsee");
//	    }
		logger = extent.startTest("Filter price high to low");
		try {
			assertTrue(productpage.isDescendingPrice(),"Filter price high to low fails");
			logger.log(LogStatus.PASS, "Filter test price high to low is passed");
			Allure.step("Filter test price high to low is passed");
		}
		catch(AssertionError e) {
			ss.takeScreenshot("Filter_price_highToLow");
			logger.log(LogStatus.FAIL, "Filter test price high to low is failed");
			Allure.addAttachment("screenshot taken successfully", e.getMessage());
		}
		extent.endTest(logger);
	    
	}



}
