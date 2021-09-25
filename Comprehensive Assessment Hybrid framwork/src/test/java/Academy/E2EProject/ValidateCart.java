package Academy.E2EProject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BedPage;
import pageObjects.LandingPage;

public class ValidateCart extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();                                   //Driver initialization
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
		@Test
		public void ValidateCart() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(l.getBed()).build().perform();             //Hover over Bedroom tab
			Thread.sleep(2000);
			l.getSingleBed().click();                                   //Click on Single Bed
			
			BedPage c = new BedPage(driver);
			String name = c.getName().getText();                        //Store name of product to validate if it got added to cart
			c.getImg().click();                                         //Click on product
			Thread.sleep(2000);
			Set<String>ids=driver.getWindowHandles();
			Iterator<String>its=ids.iterator();
			String parent = its.next();
			String child = its.next();
			driver.switchTo().window(child);                  
			c.getCart().click();                                         //Click on Add to cart button
			Thread.sleep(2000);
			String cartName = c.getCartName().getText();
			Assert.assertEquals(name, cartName);                         //Assertion to validate cart
			log.info("Item added to cart successfully!");
			
		
			
		}
		@AfterTest
		public void at() {
			driver.quit();	                                              
			driver=null;
			}
}
