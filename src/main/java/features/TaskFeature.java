package features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import generic.SeleniumLib;
import pageobjects.TaskPage;

public class TaskFeature {
	
	TaskPage taskPage;
	SeleniumLib seleniumLib;
	
	public TaskFeature(WebDriver driver)
	{
		taskPage = new TaskPage(driver);
		seleniumLib = new SeleniumLib(driver);
	}
	
	public void createCustomer(String customerName)
	{
		taskPage.getTaskLink().click();
		taskPage.getProjectAndCustomerLink().click();
		taskPage.getCreateNewCustomerButton().click();
		taskPage.getCustomerName().sendKeys(customerName);
		seleniumLib.ScrollTillWebElement(taskPage.getCreateCustomerSubmitbutton());
		taskPage.getCreateCustomerSubmitbutton().click();
	}
	
	public void verifyCreatedCustomer(String customerName)
	{
		WebElement dropDown = taskPage.getActiveCustomerDropDown();
		seleniumLib.checkIfElementIsInTheDropDown(dropDown, customerName);
		WebElement element = seleniumLib.selectWebelement(dropDown, customerName);
		Assert.assertEquals(element.getText(), customerName);
	}

}
