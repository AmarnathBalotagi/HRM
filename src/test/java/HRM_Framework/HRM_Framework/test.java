package HRM_Framework.HRM_Framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Action.actions;

public class test {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions ac = new Actions(driver);
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		
		WebElement Elec = driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		ac.moveToElement(Elec).perform();
		WebElement Cam = driver.findElement(By.xpath("//a[text()='Cameras & Accessories']"));
		ac.moveToElement(Cam).perform();
		WebElement Dslr = driver.findElement(By.xpath("//a[text()='DSLR & Mirrorless']"));
		ac.moveToElement(Dslr).click().perform();
	
		WebElement row = driver.findElement(By.xpath("//div[@data-id='CAMF3DHJURPEMNRN'][1]"));
	
		List<WebElement> img = row.findElements(By.tagName("img"));
		System.out.println(img.size());
		
		
		
	}

	

}
