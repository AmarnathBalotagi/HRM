package HRM_Framework.HRM_Framework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

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
	    @Parameters("browser")
	@BeforeMethod
    public void setUpTest(String browser) {
        base.setup(browser);
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
		Assert.assertEquals(getDriver().getCurrentUrl(),ExpectedURL );
		
		
	}
	@Test(priority = 2)
	public void invalidLogin() throws InterruptedException {
		lp.login("Amar", "admin123");
		Thread.sleep(3000);
		String ExpectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/auth/logi";
		Assert.assertEquals(getDriver().getCurrentUrl(),ExpectedURL );
		
		
	}
	
	

}
