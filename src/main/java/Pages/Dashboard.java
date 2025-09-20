package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.base;

public class Dashboard extends base{
	
	WebDriver driver;
	
	@FindBy (xpath = "//span[text()='Admin']")
	public WebElement Admin;
	
	
	@FindBy (xpath = "//span[text()='PIM']")
	public WebElement PIM;
	
	
	@FindBy (xpath = "//span[text()='Leave']")
	public WebElement Leave;
	
	
	@FindBy (xpath = "//span[text()='Time']")
	public WebElement Time;
	
	
	@FindBy (xpath = "//span[text()='Recruitment']")
	public WebElement Recruitment;
	
	
	@FindBy (xpath = "//span[text()='My Info']")
	public WebElement My_Info;
	
	@FindBy (xpath = "//span[text()='Performance']")
	public WebElement Performance;
	
	@FindBy (xpath = "//span[text()='Dashboard']")
	public WebElement Dashboard;
	
	@FindBy (xpath = "//span[text()='Maintenance']")
	public WebElement Maintenance;
	
	@FindBy (xpath = "//span[text()='Claim']")
	public WebElement Claim;
	
	@FindBy (xpath = "//span[text()='Buzz']")
	public WebElement Buzz;
	
	public Dashboard (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	

}
