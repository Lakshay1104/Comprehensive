package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Academy.E2EProject.base;

public class LandingPage {
   WebDriver driver;
	

	By wish = By.cssSelector("#shortlist-badge > span:nth-child(1) > svg:nth-child(1)");
	By sale = By.cssSelector("li.topnav_item:nth-child(1) > span:nth-child(1)");
	By dropdown = By.cssSelector("li.topnav_item:nth-child(1) > div:nth-child(2) > div:nth-child(1)");
	By id = By.id("email_id");
	By subscribe = By.cssSelector("input.button:nth-child(1)");
	By text = By.cssSelector(".success-msg > div:nth-child(1)");
	By app = By.cssSelector(".ios");
	By order = By.cssSelector("li.featuredLinksBar__contact-link:nth-child(2) > a:nth-child(1)");
	By bed = By.cssSelector("li.topnav_item:nth-child(3) > span:nth-child(1)");
	By singlebed = By.cssSelector(".\\33 77 > a:nth-child(1) > span:nth-child(1)");
	By mattress = By.cssSelector(".\\33 002 > a:nth-child(1) > span:nth-child(1)");
	By search = By.id("search");
	By loginIcon = By.cssSelector("span.header-icon-link > svg:nth-child(1)");
	By login = By.cssSelector(".dropdown > li:nth-child(1) > a:nth-child(1)");
	By loginId = By.id("spree_user_email");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	
	public WebElement getWish() {
		return driver.findElement(wish);
		
	
	}

	public WebElement getSale() {
		return driver.findElement(sale);
		
	
	}
	public WebElement getDropdown() {
		return driver.findElement(dropdown);
		
	
	}
	public WebElement getId() {
		return driver.findElement(id);
		
	
	}
	public WebElement getSubscription() {
		return driver.findElement(subscribe);
		
	
	}
	public WebElement getSubText() {
		return driver.findElement(text);
		
	
	}
	public WebElement getApp() {
		return driver.findElement(app);
		
	
	}
	public WebElement getOrder() {
		return driver.findElement(order);
		
	
	}
	public WebElement getBed() {
		return driver.findElement(bed);
		
	
	}
	public WebElement getSingleBed() {
		return driver.findElement(singlebed);
		
	
	}
	public WebElement getMattress() {
		return driver.findElement(mattress);
		
	
	}
	public WebElement getSearch() {
		return driver.findElement(search);
		
	
	}

	public WebElement getLoginIcon() {
		return driver.findElement(loginIcon);
		
	
	}
	public WebElement getLogin() {
		return driver.findElement(login);
		
	
	}
	public WebElement getLoginId() {
		return driver.findElement(loginId);
		
	
	}
	
	public String getItem() throws IOException  {
		ArrayList<String> a=new ArrayList<String>();
		FileInputStream fis = new FileInputStream(".\\items.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int count = workbook.getNumberOfSheets();
		for(int i=0;i<count;i++) {
			if(workbook.getSheetName(i).equals("data")) {
				XSSFSheet sheet =workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> c=firstRow.cellIterator();
				while(c.hasNext()) {
				 Cell cell=c.next();
				 a.add(cell.getStringCellValue());
				}
				
			}
		}
		return a.get(0);
	}
}
