package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.MattressPage;

public class ValidateDeliveryDate extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
		@Test
		public void ValidateDeliveryDate() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(l.getBed()).build().perform();
			Thread.sleep(2000);
			l.getMattress().click();
			
			MattressPage m = new MattressPage(driver);
			m.getMat().click();
			Thread.sleep(1000);
			Assert.assertTrue(m.getDelivery().getText().contains("Delivery")); 
			log.info("Delivery date is shown successfully");
			
			
		
			
		}
		@AfterTest
		public void at() {
			driver.quit();	
			driver=null;
			}

}
