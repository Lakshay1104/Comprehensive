package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BedPage {
	WebDriver driver;
	
	By name = By.cssSelector("li.product:nth-child(1) > div:nth-child(1) > div:nth-child(9) > a:nth-child(1) > div:nth-child(1) > span:nth-child(1)");
	By img = By.cssSelector("li.product:nth-child(1) > div:nth-child(1) > a:nth-child(6) > img:nth-child(1)");
	By cart = By.id("add-to-cart-button");
	By cartname= By.cssSelector(".product-title > a:nth-child(1)");
	
	public BedPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getName() {
		return driver.findElement(name);
		
	
	}
	public WebElement getImg() {
		return driver.findElement(img);
		
	
	}
	public WebElement getCart() {
		return driver.findElement(cart);
		
	
	}
	public WebElement getCartName() {
		return driver.findElement(cartname);
		
	
	}

}
