package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.configReader;

public class base {
	protected static WebDriver driver;
	
	public static WebDriver setup() {
		configReader.initProp();
		String browser = configReader.getProperty("browser");
		String url = configReader.getProperty("baseUrl");
		long timeout = Long.parseLong (configReader.getProperty("implicitWait"));
		 
		switch (browser.toLowerCase()) {
		
		case "chrome": 
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox": 
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge": 
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "safari": 
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			break;
			
		default:
            throw new IllegalArgumentException("Browser not supported: " + browser);
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		driver.get(url);
		return driver;
	
	}
	public static WebDriver getDriver() {
		return driver; 
    }
	public static WebDriver tearDown() {
		
		driver.quit();
		return driver; 
	}
	
	
	
	
	

}
