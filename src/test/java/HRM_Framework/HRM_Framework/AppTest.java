package HRM_Framework.HRM_Framework;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Action.actions;
import Base.base;
import Pages.Dashboard;
import Pages.LoginPage;
import Pages.PIM;


public class AppTest 
    extends base{
    
    LoginPage lp;
    Dashboard dash;
    actions ac;
    PIM pim;
	@BeforeClass
    public void setUpTest() {
        base.setup();
        lp = new LoginPage(getDriver());
        dash = new Dashboard(getDriver());
        pim = new PIM(getDriver());
        ac = new actions(getDriver());
    }
 
   @Test(priority = 1)
   public void loginTest(){
	   lp.login("Admin", "admin123");
	   ac.Click(dash.Admin);
	   ac.Click(dash.PIM); 
	  
   }
   @Test(priority = 2)
   public void test2() {
	   ac.Click(pim.AddEmpBtn);
	  pim.FillEmpDetails("Amar", "S", "Balotagi");
	  ac.Click(pim.SaveBtn);
	    
   }
   
   
}
