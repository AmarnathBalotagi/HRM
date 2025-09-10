package utils;

	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

	public class TestListener implements ITestListener {

	    // To get WebDriver instance from your Base class
	    private static WebDriver driver;

	    public static void setDriver(WebDriver driverInstance) {
	        driver = driverInstance;
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("❌ Test Failed: " + result.getName());

	        if (driver != null) {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);

	            // Timestamp to avoid overwrite
	            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	            // Permanent folder for screenshots
	            String destPath = System.getProperty("user.dir") 
	                    + "/Screenshort/" 
	                    + result.getName() + "_" + timeStamp + ".png";

	            try {
	                FileUtils.copyFile(src, new File(destPath));
	                System.out.println("📸 Screenshot saved at: " + destPath);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    // Optional: you can also capture on success or skip
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test Passed: " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }

	    @Override public void onStart(ITestContext context) {}
	    @Override public void onFinish(ITestContext context) {}
	    @Override public void onTestStart(ITestResult result) {}
	}


