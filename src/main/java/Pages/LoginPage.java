package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.base;

public class LoginPage extends base {
WebDriver driver;

@FindBy (name="username")
WebElement Username;
@FindBy (name="password")
WebElement Password;
@FindBy (xpath="//button[@type='submit']")
WebElement Loginbtn;


public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void login(String user,String pass) {
	getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Username.sendKeys(user);
	Password.sendKeys(pass);
	Loginbtn.click();
	
	
}





	
}
