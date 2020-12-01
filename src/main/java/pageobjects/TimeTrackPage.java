package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimeTrackPage {
	
	@FindBy(xpath = "//td[@class='pagetitle']//td[@class='pagetitle']")
	private WebElement pageTitle;
	
	public TimeTrackPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getPageTitle() {
		return pageTitle;
	}

}
