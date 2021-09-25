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

public class ValidateLogin extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void bt() throws IOException {
		driver = InitializeDriver();                                          //Driver initialization
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
		@Test
		public void ValidateLogin() throws IOException, InterruptedException {
			
			LandingPage l = new LandingPage(driver);
			Thread.sleep(2000);
			Actions a = new Actions(driver);
			a.moveToElement(l.getLoginIcon()).build().perform();                 //Hover over Login icon
			Thread.sleep(1000);
			l.getLogin().click();                                                //Click on Login
			Assert.assertTrue(l.getLoginId().isDisplayed());
			log.info("Login functionality is working!");                        //Validate Login feature
		}
		@AfterTest
		public void at() {
			driver.quit();	
			driver=null;
			}
}
