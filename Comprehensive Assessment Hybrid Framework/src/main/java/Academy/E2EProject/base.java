package Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.service.DriverService;

public class base {
	static WebDriver driver;
	static Properties prop;
	public static WebDriver InitializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\data.properties");
		prop.load(fis);
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver= new FirefoxDriver();
	}
		else if(prop.getProperty("browser").equals("edge")) {
			System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
			driver= new EdgeDriver();
	}
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 
  return driver;
}
	public void getScreenshot(String res) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(".\\Screenshots\\"+res+"screenshot.png"));
		
	}
	
}
