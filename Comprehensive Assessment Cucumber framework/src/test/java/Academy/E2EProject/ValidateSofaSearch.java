package Academy.E2EProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import pageObjects.LandingPage;
import pageObjects.SofaPage;


public class ValidateSofaSearch extends base{

	public static Logger log = LogManager.getLogger(base.class.getName());
@BeforeTest
public void bt() throws IOException {
	driver = InitializeDriver();
	String url = prop.getProperty("url");
	driver.get(url);
}
	@Test
	public void ValidateSofa() throws IOException {
		
		LandingPage l = new LandingPage(driver);


		l.getSearch().sendKeys(l.getItem()+Keys.ENTER);
		
		SofaPage s = new SofaPage(driver);
//		Assert.assertEquals("Sofa Sets", s.getHeading().getText());
	
		Assert.assertTrue(s.getItem().getText().contains(l.getItem())); 
		log.info("Sofa is being displayed successfully!");
	}
	@AfterTest
	public void at() {
		driver.close();	
		driver=null;
		}
	
}
