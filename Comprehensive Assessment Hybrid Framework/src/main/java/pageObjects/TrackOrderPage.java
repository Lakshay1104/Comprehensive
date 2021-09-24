package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrackOrderPage {
	 WebDriver driver;
		
		By orderNo = By.cssSelector("#ip_379403698");
		By phoneNo = By.cssSelector("#ip_394711104");
		By submit = By.cssSelector("button._3Haew:nth-child(3)");
		By error = By.cssSelector("._33bg3");
		
		public TrackOrderPage(WebDriver driver) {
			this.driver=driver;
		}
		
		public WebElement getOrderNo() {
			return driver.findElement(orderNo);
			
		
		}
		public WebElement getPhoneNo() {
			return driver.findElement(phoneNo);
			
		
		}
		public WebElement getsubmit() {
			return driver.findElement(submit);
			
		
		}
		public WebElement getError() {
			return driver.findElement(error);
			
		
		}
}
