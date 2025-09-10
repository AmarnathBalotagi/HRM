package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Action.actions;
import Base.base;
import utils.Waits;

public class PIM extends base {
	WebDriver driver;
	Waits wait =new Waits (getDriver());
	
	actions ac = new actions(getDriver());
	
	@FindBy (xpath ="//a[text()='Employee List']")
	public WebElement EmpList;
	
	@FindBy (xpath ="//a[text()='Add Employee']")
	public WebElement AddEmp;
	
	@FindBy (xpath ="//a[text()='Reports']")
	public WebElement Reports;
	
	@FindBy (xpath ="//button[text()=' Add ']")
	public WebElement AddEmpBtn;
	
	@FindBy (name ="firstName")
	public WebElement EmpFirstName;
	
	@FindBy (name ="middleName")
	public WebElement EmpMiddleName;
	
	@FindBy (name ="lastName")
	public WebElement EmpLastName;
	
	@FindBy (xpath ="//button[text()=' Cancel ']")
	public WebElement CancelBtn;
	
	@FindBy (xpath ="//button[text()=' Save ']")
	public WebElement SaveBtn;
	
	@FindBy (xpath ="//div[@class='orangehrm-edit-employee-name']/h6")
	public WebElement EmpProname;
	
	@FindBy (xpath ="//input[@placeholder ='Type for hints...'][1]")
	public WebElement Empname;
	
	@FindBy (xpath ="//button[text()=' Search ']")
	public WebElement Search;
	
	@FindBy (xpath ="//h6[text()='Personal Details']")
	public WebElement PersonalDetails;
	
	@FindBy (xpath ="//div[@class='oxd-table-card']")
	public List < WebElement > NoOfRec;
	
	@FindBy (xpath ="(//div[@role='cell'][3])[1]")
	public WebElement Rec_FN_MM;
	
	@FindBy (css  ="i.bi-pencil-fill")
	public WebElement Rec_Edit;
	
	@FindBy (xpath ="(//span[contains(@class,'active')])[1]")
	public WebElement Gender_male;
	
	@FindBy (xpath ="(//button[text()=' Save '])[1]")
	public WebElement PD_save;
	
	@FindBy (xpath ="(//button[text()=' Save '])[2]")
	public WebElement Cust_save;
	
	@FindBy (xpath ="//div[@id='oxd-toaster_1']")
	public WebElement Sucess_Toast;
	
	/*@FindBy (xpath ="(//i[@class='oxd-icon bi-trash'])[1]")
	public WebElement Del_icon2;*/
	 private By Del_icon  = By.cssSelector("i.bi-trash");
	
	@FindBy (xpath ="//button[normalize-space()='Yes, Delete']")
	public WebElement Del_btn;
	
	public PIM (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void FillEmpDetails(String FN, String MN, String LN) {
		EmpFirstName.sendKeys(FN);
		EmpMiddleName.sendKeys(MN);
		EmpLastName.sendKeys(LN);
	}
	
	public void Search_Emp(String EmpName) {
		ac.Click(EmpList);
		ac.Click(Empname);
		Empname.sendKeys(EmpName);
		ac.Click(Search);
		System.out.println("Records Found : "+ NoOfRec.size());
		
		ac.scrollto(Rec_FN_MM);
		
		
	}
	
	public void Edit_Emp(String EmpName) {
		ac.Click(EmpList);
		ac.Click(Empname);
		Empname.sendKeys(EmpName);
		ac.Click(Search);
		ac.Click(Rec_Edit);
		ac.scrollVertical(300);
		ac.dd("Nationality", "Indian");
		ac.dd("Marital Status", "Single");
		Gender_male.click();
		ac.Click(PD_save);
		wait.waitForVisible(Sucess_Toast);
	}
	
	public void Delete_Emp(String EmpName) {
		ac.Click(EmpList);
		ac.Click(Empname);
		Empname.sendKeys(EmpName);
		ac.Click(Search);
		ac.scrollto(Rec_FN_MM);
		driver.navigate().refresh();
		ac.Click(driver.findElement(Del_icon));
		ac.Click(Del_btn);
		wait.waitForVisible(Sucess_Toast);
	
	}
	

}
