package features;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import pageobjects.LoginPage;
import pageobjects.TimeTrackPage;

public class LoginFeature {
	
	LoginPage loginPage;
	TimeTrackPage timeTrackPage;
	
	public LoginFeature(WebDriver driver)
	{
		loginPage = new LoginPage(driver);
		timeTrackPage = new TimeTrackPage(driver);
	}
	
	public void login(String userName, String password)
	{
		loginPage.getUserName().sendKeys(userName);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
	}
	
	public void verifyLogin()
	{
		Assert.assertEquals(timeTrackPage.getPageTitle().getText(), "Enter Time-Track");
		Reporter.log("Login successfully verified", true);
	}
	
	public void verifyInvalidLogin()
	{
		Assert.assertEquals(loginPage.getErrorMessage().getText(), "Username or Password is invalid. Please try again.");
		Reporter.log("Invalid Login successfully verified", true);
	}

}
