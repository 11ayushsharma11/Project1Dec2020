package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
	
	public static WebDriver driver;
	
	@Parameters({"browserName","baseUrl"})
	@BeforeMethod
	public void preCondition(String browserName, String baseUrl)
	{
		driver = BrowserFactory.launchBrowser(browserName);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Parameters({"browserName"})
	@AfterMethod
	public void postCondition(String browserName)
	{
		driver.close();
		Reporter.log(browserName + " closed", true);
	}
	
}
