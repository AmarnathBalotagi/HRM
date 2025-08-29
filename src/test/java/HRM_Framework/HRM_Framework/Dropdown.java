package HRM_Framework.HRM_Framework;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Action.actions;
import Base.base;
import Pages.Dashboard;
import Pages.LoginPage;
import Pages.PIM;

public class Dropdown extends base{
	
	
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
	   public void test1() throws InterruptedException{
		   lp.login("Admin", "admin123");
		   ac.Click(dash.PIM);  
		   dd("Employment Status","Part-Time Contract");
		   dd("Include","Current and Past Employees");
		   dd("Job Title","QA Engineer");
		   dd("Sub Unit","Engineering");
	   }
	
	
	public void dd(String title,String option ) throws InterruptedException {
		
		WebElement SelectBtn = driver.findElement(By.xpath("//label[text()='"+title+"']/following::div[contains(@class,'oxd-select-text')][1]"));
		SelectBtn.click(); Thread.sleep(3000);
		WebElement options = driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/div/span[text()='"+option+"']"));
		options.click();
}
}
