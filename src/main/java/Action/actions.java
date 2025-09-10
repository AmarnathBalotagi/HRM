package Action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.base;

public class actions extends base {
	WebDriver driver;
	WebDriverWait wait ;
	JavascriptExecutor js;
	 // Constructor to initialize driver and wait
    public actions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor)driver;
    }

	
	public void Click(WebElement Element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		Element.click();


	}
	public void Input(WebElement Element, String input) {
		wait.until(ExpectedConditions.elementToBeSelected(Element));
		Element.sendKeys(input);
	}
	public void dd(String title,String option )  {
		
		WebElement SelectBtn = driver.findElement(By.xpath("//label[text()='"+title+"']/following::div[contains(@class,'oxd-select-text')][1]"));
		wait.until(ExpectedConditions.elementToBeClickable(SelectBtn));
		SelectBtn.click(); 
		WebElement options = driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div/span[text()='"+option+"']"));
		options.click();
}
	
	public void scrollto(WebElement Element) {
		js.executeScript("arguments[0].scrollIntoView(true);", Element);
		
		
	}
	public void scrollVertical(int y) {
		String px = String.valueOf(y);
		js.executeScript("window.scrollBy("+px+",0)"); 
	
	}
	
	public void takeScreenshot(WebDriver driver, String fileName) {
        try {
            
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
   
            String folder = System.getProperty("user.dir") + "/Screenshort/";

            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            
            File dest = new File(folder + fileName + "_" + timeStamp + ".png");

            FileUtils.copyFile(src, dest);

            System.out.println("Permanent screenshot saved at: " + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	

}
