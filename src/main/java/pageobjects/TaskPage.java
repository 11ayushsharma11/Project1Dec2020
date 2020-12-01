package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskPage extends BasePage{
	
	@FindBy(xpath = "//a[text()='Projects & Customers']")
	private WebElement projectAndCustomerLink;
	
	@FindBy(xpath = "//input[@value='Create New Customer']")
	private WebElement createNewCustomerButton;
	
	@FindBy(xpath = "//input[@name='name']")
	private WebElement customerName;
	
	@FindBy(xpath = "//input[@name='createCustomerSubmit']")
	private WebElement createCustomerSubmitbutton;
	
	@FindBy(xpath="//select[@name='selectedCustomer']")
	private WebElement activeCustomerDropDown;
	
	public WebElement getCreateCustomerSubmitbutton() {
		return createCustomerSubmitbutton;
	}

	public TaskPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjectAndCustomerLink() {
		return projectAndCustomerLink;
	}

	public WebElement getCreateNewCustomerButton() {
		return createNewCustomerButton;
	}

	public WebElement getCustomerName() {
		return customerName;
	}

	public WebElement getActiveCustomerDropDown() {
		return activeCustomerDropDown;
	}
	

}
