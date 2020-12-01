package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userName;
	
	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement password;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//table[@id='ErrorsTable']//span[@class='errormsg']")
	private WebElement errorMessage;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

}
