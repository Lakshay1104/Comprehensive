package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import Academy.E2EProject.base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BedPage;
import pageObjects.LandingPage;
import pageObjects.MattressPage;
import pageObjects.SofaPage;
import pageObjects.TrackOrderPage;


public class stepDefinition extends base{
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	String name = "";
	String price1="";
	String price2 ="";
	@Given("^Initialize webdriver$")                               
    public void initialize_webdriver() throws Throwable {
		driver = InitializeDriver();                                                     //Driver initialization
		driver.manage().window().maximize();
    }
	
	  @And("^open the Urban Ladder website$")
	    public void open_the_urban_ladder_website() throws Throwable {
	    	driver.get(prop.getProperty("url"));                                         //Open Urban Ladder website
	    }


 
    
    
    //Validate Title ----TEST 1
	  
	  
	@When("^You reach site get the title of the site$")
	    public void you_reach_site_get_the_title_of_the_site() throws Throwable {
	    	
		Assert.assertTrue(driver.getTitle().contains("Urban Ladder"));                //Validate Title
	    }
	    

    @Then("^Verify if the title contains site name$")
    public void verify_if_the_title_contains_site_name() throws Throwable {
    	log.info("Title is correct!");
    	driver.quit();	
		driver=null;
    }

    
    
    
    
    
    
    
    
  //Validate Nav ----TEST 2

    @When("^You reach site click on the App Store icon$")
    public void you_reach_site_click_on_the_app_store_icon() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		l.getApp().click();                                  //Click on Appstore icon
		Set<String>ids=driver.getWindowHandles();
		Iterator<String>its=ids.iterator();
		String parent = its.next();
		String child = its.next();
		driver.switchTo().window(child);
		Thread.sleep(2000);
    }

    @Then("^Verify if succesfully navigates to the appstore site$")
    public void verify_if_succesfully_navigates_to_the_appstore_site() throws Throwable {
    	Assert.assertTrue(driver.getTitle().contains("Urban Ladder"));            //Validate if it navigates to Urban ladder on appstore's site
		log.info("Navigations working fine!");
		driver.quit();	
		driver=null;
    }

    
    
    
    
    
    
    
    
    
    
    
    
  //Validate Cart ----TEST 3
    
    @When("^You reach site hover over the Bedroom section and click on SingleBeds$")
    public void you_reach_site_hover_over_the_bedroom_section_and_click_on_singlebeds() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(l.getBed()).build().perform();                               //Hover over Bedroom tab
		Thread.sleep(2000);
		l.getSingleBed().click();                                                    //Click on Single Bed
    }
    
    @And("^then click on the product of interest$")
    public void then_click_on_the_product_of_interest() throws Throwable {
    	BedPage c = new BedPage(driver);
		name = c.getName().getText();                                   //Store name of product to validate if it got added to cart
		c.getImg().click();                                                           //Click on product
		Thread.sleep(2000);
		Set<String>ids=driver.getWindowHandles();
		Iterator<String>its=ids.iterator();
		String parent = its.next();
		String child = its.next();
		driver.switchTo().window(child);
    }

    
    @And("^click on Add to cart$")
    public void click_on_add_to_cart() throws Throwable {
    	BedPage c = new BedPage(driver);
    	c.getCart().click();                                                     //Click on Add to cart button
		Thread.sleep(2000);
    }
    
    
    @Then("^Verify if product is successfully added to the cart$")
    public void verify_if_product_is_successfully_added_to_the_cart() throws Throwable {
    	BedPage c = new BedPage(driver);
    	String cartName = c.getCartName().getText();
		Assert.assertEquals(name, cartName);                                      //Assertion to validate cart
		log.info("Item added to cart successfully");
		driver.quit();	
		driver=null;
    }

    
    
    
    
    
    
    
    
    
    
  //Validate Change in price ----TEST 4
    
    
    @When("^You reach site hover over the Bedroom section and click on All mattresses$")
    public void you_reach_site_hover_over_the_bedroom_section_and_click_on_all_mattresses() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(l.getBed()).build().perform();                                        //Hover over Bedroom tab
		Thread.sleep(2000);
		l.getMattress().click();                                                              //Click on "All Mattresses"
    }

    @And("^then click on the product you are interested in$")
    public void then_click_on_the_product_you_are_interested_in() throws Throwable {
    	MattressPage m = new MattressPage(driver);
		m.getMat().click();                                                                   //Click on a bed product
		Thread.sleep(1000);
    }

    @And("^Retrieve price of product$")
    public void retrieve_price_of_product() throws Throwable {
    	MattressPage m = new MattressPage(driver);
    	price1 = m.getPrice1().getText();                                                     //Store price for default size
    }

    @Then("^Change the size of product and retrieve the prize again$")
    public void change_the_size_of_product_and_retrieve_the_prize_again() throws Throwable {
    	MattressPage m = new MattressPage(driver);
    	m.getSize().click();                                                                  //Change size
		price2 = m.getPrice2().getText();                                                     //Store price for changed size
    }

   
    

    @And("^verify if the price changes with size$")
    public void verify_if_the_price_changes_with_size() throws Throwable {
    	Assert.assertFalse(price1.equals(price2));                                        //Validate if both prices are different     
		log.info("Prices are changing according to the size successfully!"); 
		driver.quit();	
		driver=null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //Validate DeliveryDate----TEST 5
    
    
 
    @Then("^Verify if delivery time of product is being shown$")
    public void verify_if_delivery_time_of_product_is_being_shown() throws Throwable {
    	MattressPage m = new MattressPage(driver);
    	Assert.assertTrue(m.getDelivery().getText().contains("Delivery"));                        //Validate whether delivery Date is shown
		log.info("Delivery date is shown successfully");
		driver.quit();	
		driver=null;
    }
 

    
    
    
    
    
    
    
    
    
    
  //Validate Dropdown----TEST 6
    
    
    
    
    @When("^You reach site hover over Sale tab$")
    public void you_reach_site_hover_over_sale_tab() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(l.getSale()).build().perform();                    //Hover over sale tab
		Thread.sleep(2000);
    }

    @Then("^Verify if the dropdown feature is working$")
    public void verify_if_the_dropdown_feature_is_working() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	Assert.assertTrue(l.getDropdown().isDisplayed());                 //Validate whether dropdown is displayed
		log.info("Dropdown feature working fine!");
		driver.close();	
		driver=null;
    }
    

    
    
    
    
    
    
    
    //Validate TrackOrder----TEST 7
    
    
    
    
    
    
    @When("^You reach site click on Track Order$")
    public void you_reach_site_click_on_track_order() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		l.getOrder().click();                          //Click on track order
    }
    
    @And("^enter OrderNo \"([^\"]*)\" and PhoneNo \"([^\"]*)\" and click on Submit$")
    public void enter_orderno_something_and_phoneno_something_and_click_on_submit(String orderNo, String phoneNo) throws Throwable {
    	TrackOrderPage t = new TrackOrderPage(driver);
		t.getOrderNo().sendKeys(orderNo);              //Enter OrderNo
		t.getPhoneNo().sendKeys(phoneNo);              //Enter PhoneNo
		t.getsubmit().click();                         //Click on submit button
    }

    @Then("^Verify if the track order feature is working$")
    public void verify_if_the_track_order_feature_is_working() throws Throwable {
    	TrackOrderPage t = new TrackOrderPage(driver);
    	Assert.assertEquals("Order not found. If you have just placed the order, tracking information will be available after an hour.", t.getError().getText());  //Validate Track order feature
		log.info("Track Order feature working fine");
		driver.quit();	
		driver=null;
    }

   
   
    
    
    
    
    
    
    
    //Validate SofaSearch----TEST 8
    
    @When("^You reach site search for \"([^\"]*)\"$")
    public void you_reach_site_search_for_something(String item) throws Throwable {
    	LandingPage l = new LandingPage(driver);


		l.getSearch().sendKeys(item + Keys.ENTER);                           //Search for Sofa
    }

    @Then("^Verify if the products shown match the search$")
    public void verify_if_the_products_shown_match_the_search() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	SofaPage s = new SofaPage(driver);

	
		Assert.assertTrue(s.getItem().getText().contains(l.getItem()));      //Validate if searched items are Sofas
		log.info("Sofa is being displayed successfully!");
		driver.close();	
		driver=null;
    }
    
    
    
    
    
    
    
    
    
    //Validate Subscription----TEST 9
    
    
    @When("^You reach site enter email for subscription$")
    public void you_reach_site_enter_email_for_subscription() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		l.getId().sendKeys("abcd@gmail.com");         //Enter email
		l.getSubscription().click();                  //Click on Subscribe button
		Thread.sleep(2000);
    }

    @Then("^Verify if subscription has been successfull$")
    public void verify_if_subscription_has_been_successfull() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	Assert.assertEquals("THANKS FOR SUBSCRIBING!", l.getSubText().getText());   //Validate subscription feature
		log.info("Subscription Successfull");
		driver.close();	
		driver=null;
    }
    

    
    
    
    
    
    
    
    
    
    
  //Validate Warranty----TEST 10
    

    @Then("^verify if warranty of product is visible$")
    public void verify_if_warranty_of_product_is_visible() throws Throwable {
    	MattressPage m = new MattressPage(driver);
    	Assert.assertTrue(m.getWarranty().getText().contains("warranty"));   //Validate whether Warranty is being displayed
		log.info("Warranty is shown successfully");
		driver.quit();	
		driver=null;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    //Validate Login  ----TEST11
    @When("^You reach site hover over login icon$")
    public void you_reach_site_hover_over_login_icon() throws Throwable {
    	LandingPage l = new LandingPage(driver);
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(l.getLoginIcon()).build().perform();                 //Hover over Login icon
		Thread.sleep(1000);
    }

    @Then("^click on login$")
    public void click_on_login() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	l.getLogin().click();                                                //Click on Login
    }

    @And("^verify whether login feature is working$")
    public void verify_whether_login_feature_is_working() throws Throwable {
    	LandingPage l = new LandingPage(driver);
    	Assert.assertTrue(l.getLoginId().isDisplayed());                     //Validate Login feature
		log.info("Login functionality is working!");
		driver.quit();	
		driver=null;
    }
	 
    
}
