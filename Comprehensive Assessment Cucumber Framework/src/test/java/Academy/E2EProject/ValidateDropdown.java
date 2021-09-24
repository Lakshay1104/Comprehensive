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


public class ValidateDropdown extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
		@Test
		public void ValidateDropdown() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(l.getSale()).build().perform();
			Thread.sleep(2000);
			Assert.assertTrue(l.getDropdown().isDisplayed());
			log.info("Dropdown feature working fine!");
		}
		@AfterTest
		public void at() {
			driver.close();	
			driver=null;
			}
}
