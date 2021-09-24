package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MattressPage {
WebDriver driver;
	
	
	By mat= By.cssSelector("li.product:nth-child(1) > div:nth-child(1) > a:nth-child(9) > img:nth-child(1)");
	By price1 = By.cssSelector("#buy_details_44169 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)");
	By size = By.cssSelector("li.type:nth-child(3) > level:nth-child(1)");
	By price2 = By.cssSelector("div.discounted-price:nth-child(1)");
	By warranty = By.cssSelector(".warranty-details");
	By delivery = By.cssSelector("#delivery_details_44169 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5)");
	public MattressPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getMat() {
		return driver.findElement(mat);
		
	
	}
	public WebElement getPrice1() {
		return driver.findElement(price1);
		
	
	}
	public WebElement getSize() {
		return driver.findElement(size);
		
	
	}
	public WebElement getPrice2() {
		return driver.findElement(price2);
		
	
	}
	public WebElement getWarranty() {
		return driver.findElement(warranty);
		
	
	}
	public WebElement getDelivery() {
		return driver.findElement(delivery);
		
	
	}
}
