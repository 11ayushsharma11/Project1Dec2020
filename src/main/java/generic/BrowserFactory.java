package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
	public static WebDriver launchBrowser(String browserName)
	{
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
//			System.setProperty("webdriver.chrome.driver", "./exeFiles/chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + " has launched Successfully!");
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./exeFiles/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + " has launched Successfully!");
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "./exeFiles/msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			System.out.println(browserName + " has launched Successfully!");
		}
		
		return driver;
	}

}
