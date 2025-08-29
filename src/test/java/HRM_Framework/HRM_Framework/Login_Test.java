package HRM_Framework.HRM_Framework;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Action.actions;
import Base.base;
import Pages.Dashboard;
import Pages.LoginPage;
import Pages.PIM;
@Listeners(utils.TestListener.class)
public class Login_Test extends base  {
	 LoginPage lp;
	    Dashboard dash;
	    actions ac;
	    PIM pim;
	@BeforeMethod
    public void setUpTest() {
        base.setup();
        lp = new LoginPage(getDriver());
        dash = new Dashboard(getDriver());
        pim = new PIM(getDriver());
        ac = new actions(getDriver());
    }
	
	@Test(priority = 1)
	public void validLogin() throws InterruptedException {
		lp.login("Admin", "admin123");
		Thread.sleep(3000);
		
		String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(driver.getCurrentUrl(),ExpectedURL );
		
		ac.takeScreenshot(driver, "pass");
	}
	@Test(priority = 2)
	public void invalidLogin() throws InterruptedException {
		lp.login("Amar", "admin123");
		Thread.sleep(3000);
		String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(driver.getCurrentUrl(),ExpectedURL );
		
		
	}
	
	

}
