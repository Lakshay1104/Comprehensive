package Academy.E2EProject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.TrackOrderPage;

public class ValidateOrder extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
		@Test
		public void ValidateOrderTracking() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			l.getOrder().click();
			
			TrackOrderPage t = new TrackOrderPage(driver);
			t.getOrderNo().sendKeys("32132131");
			t.getPhoneNo().sendKeys("8765487654");
			t.getsubmit().click();
			Assert.assertEquals("Order not found. If you have just placed the order, tracking information will be available after an hour.", t.getError().getText());
			log.info("Track Order feature working fine");
		}
		@AfterTest
		public void at() {
			driver.quit();	
			driver=null;
			}
}
