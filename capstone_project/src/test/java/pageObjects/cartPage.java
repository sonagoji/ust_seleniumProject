package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class cartPage {

	
	WebDriver driver;
	
	public cartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void addToCart(String pname) {
		driver.findElement(By.linkText(pname)).click();
		driver.findElement(By.id("add-to-cart")).click();
		
	}
	
	public boolean isProductInCart(String pname,String no) {
		boolean added = driver.findElement(By.id("remove")).isDisplayed();
		boolean cart = driver.findElement(By.className("shopping_cart_badge")).getText().equals(no);
		return added&&cart;
	}
	
	public void removeFromCart(String pname)   {
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("remove-"+pname.toLowerCase().replace(" ", "-"))).click();
	}
	

	public boolean isProductNotInCart(String pname,String no) {
		boolean cart = driver.findElement(By.className("shopping_cart_link")).getText().equals(no);
		boolean removed = driver.findElements(By.className("cart_item")).isEmpty();
		return cart&&removed;
	}
}
