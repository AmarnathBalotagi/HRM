package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.base;

public class PIM extends base {
	
	
	
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
	
	public PIM (WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	
	}
	public void FillEmpDetails(String FN, String MN, String LN) {
		EmpFirstName.sendKeys(FN);
		EmpMiddleName.sendKeys(MN);
		EmpLastName.sendKeys(LN);
	}
	

}
