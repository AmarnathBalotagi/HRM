package HRM_Framework.HRM_Framework;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
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
    static String FN = "Stone" ;
    static String MN = "" ;
    static String LN = "Bold" ;
    
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
   public void addEmployeeTest() throws InterruptedException {
	  ac.Click(pim.AddEmpBtn);
	  pim.FillEmpDetails(FN,MN,LN);
	  ac.Click(pim.SaveBtn);
	  Thread.sleep(3000);
	  System.out.println(pim.Sucess_Toast.getText());
	  Assert.assertEquals(pim.PersonalDetails.getText(), "Personal Details");
	  
	    
   }
   
   @Test(priority = 3)
   public void fetchEmp() {
	   pim.Search_Emp(FN);
	   Assert.assertEquals(pim.Rec_FN_MM.getText(),FN);
	    
   }
   
   @Test(priority = 4)
   public void editEmp() throws Exception {
	   pim.Edit_Emp(FN);
	  Assert.assertEquals(pim.Sucess_Toast.getText(),"Successfully Saved");
	    
   }
   
   @Test(priority = 5)
   public void delEmp() throws Exception {
	   pim.Delete_Emp(FN);
	   System.out.println(pim.Sucess_Toast.getText());
	Assert.assertEquals(pim.Sucess_Toast.getText(),"Successfully Deleted");
	    
   }
   
   
}
