package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class productsPage {
	
	WebDriver driver;
	
	public productsPage(WebDriver driver){
		this.driver=driver;
	}
	
	public boolean verifyTitle() {
		return driver.findElement(By.className("title")).getText().equals("Products");
	}
	
	public boolean isProductListDisplayed() {
		return !driver.findElements(By.id("inventory_container")).isEmpty() && driver.findElement(By.id("inventory_container")).isDisplayed();
	}
	
	public boolean productDetails() {
		List<WebElement> products = driver.findElements(By.className("inventory_list"));
		for(WebElement p : products) {
			boolean hasName = !p.findElement(By.className("inventory_item_name")).getText().isEmpty();
			boolean hasPrice = !p.findElement(By.className("inventory_item_price")).getText().isEmpty();
			boolean hasDesc = !p.findElement(By.className("inventory_item_desc")).getText().isEmpty();
			boolean hasImage = p.findElement(By.className("inventory_item_img")).isDisplayed();
			boolean hasCartButton = p.findElement(By.tagName("button")).isDisplayed();
			
			if(!hasName || !hasPrice || !hasDesc || !hasImage || !hasCartButton ) {
				return false;
			}
		}
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	//Filter
	
	public void selectFilter(String filter) {
		Select select = new Select(driver.findElement(By.className("product_sort_container")));
		select.selectByVisibleText(filter);
	}
	
	public List<String> getNames() {
		List<WebElement> names1 = driver.findElements(By.className("inventory_item_name"));
		List<String> names = new ArrayList<>();
		for(WebElement name:names1) {
			names.add(name.getText());
		}
		return names;
	}
	
	public boolean isAscending() {
		List<String> names = getNames();
		List<String> sortednames = new ArrayList<>(names);
		Collections.sort(sortednames);
		return names.equals(sortednames);
	}
	
	public boolean isDescending() {
		List<String> names = getNames();
		List<String> sortednames = new ArrayList<>(names);
		Collections.sort(sortednames,Collections.reverseOrder());
		return names.equals(sortednames);
	}
	
	public List<Double> getPrices(){
		List<WebElement> prices1 = driver.findElements(By.className("inventory_item_price"));
		List<Double> prices = new ArrayList<>();
		for(WebElement price:prices1) {
			prices.add(Double.parseDouble(price.getText().replace("$", "")));
		}
		return prices;
	}
	
	public boolean isAscendingPrice() {
		List<Double> prices = getPrices();
		List<Double> sortedPrices = new ArrayList<>(prices);
		Collections.sort(sortedPrices);
		return prices.equals(sortedPrices);
	}
	
	public boolean isDescendingPrice() {
		List<Double> prices = getPrices();
		List<Double> sortedPrices = new ArrayList<>(prices);
		Collections.sort(sortedPrices,Collections.reverseOrder());
		return prices.equals(sortedPrices);
	}
}
