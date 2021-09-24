package Academy.E2EProject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BedPage;
import pageObjects.LandingPage;
import pageObjects.MattressPage;

public class ValidateChangeInPrice extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
		@Test
		public void ValidateChangeInPrice() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(l.getBed()).build().perform();                 //Hover over Bedroom tab
			Thread.sleep(2000);
			l.getMattress().click();                                       //Click on "All Mattresses"
			
			MattressPage m = new MattressPage(driver);
			m.getMat().click();                                            //Click on a bed product
			Thread.sleep(1000);
			String price1 = m.getPrice1().getText();                       //Store price for default size
			m.getSize().click();                                           //Change size
			String price2 = m.getPrice2().getText();                       //Store price for changed size
			Assert.assertFalse(price1.equals(price2));                     //Validate if both prices are different
			log.info("Prices are changing according to the size successfully!");
			
		
			
		}
		@AfterTest
		public void at() {
			driver.quit();	
			driver=null;
			}
}
