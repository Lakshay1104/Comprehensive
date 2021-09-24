package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SofaPage {
	 WebDriver driver;
		
		
		By item = By.cssSelector("li.product:nth-child(1) > div:nth-child(1) > a:nth-child(10) > div:nth-child(1) > span:nth-child(1)");
		public SofaPage(WebDriver driver) {
			this.driver=driver;
		}
		
		
		public WebElement getItem() {
			return driver.findElement(item);
			
		
		}

}
