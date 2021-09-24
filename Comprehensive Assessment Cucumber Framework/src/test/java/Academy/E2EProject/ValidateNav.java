package Academy.E2EProject;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;

public class ValidateNav extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();
		String url = prop.getProperty("url");
		driver.get(url);
	}
		@Test
		public void ValidateNav() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			l.getApp().click();
			Set<String>ids=driver.getWindowHandles();
			Iterator<String>its=ids.iterator();
			String parent = its.next();
			String child = its.next();
			driver.switchTo().window(child);
			Thread.sleep(2000);
			Assert.assertTrue(driver.getTitle().contains("Urban Ladder"));
			log.info("Navigations working fine!");
		}
		@AfterTest
		public void at() {
			driver.quit();	
			driver=null;
			}
}
