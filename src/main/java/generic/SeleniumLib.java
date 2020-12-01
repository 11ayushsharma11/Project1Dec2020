package generic;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SeleniumLib {
	
	private WebDriver driver;
	
	public SeleniumLib(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ScrollTillWebElement(WebElement element)
	{
		JavascriptExecutor je = (JavascriptExecutor)driver;
		String jsCode = "arguments[0].scrollIntoView(true)";
		je.executeScript(jsCode, element);
	}
	
	public WebElement selectWebelement(WebElement dropDown, String elementText)
	{
		Select select = new Select(dropDown);
		select.selectByVisibleText(elementText);
		return select.getFirstSelectedOption();
	}
	
	public boolean checkIfElementIsInTheDropDown(WebElement dropDown, String elementText)
	{
		Select select = new Select(dropDown);
		List<WebElement> allOptions = select.getOptions();
		for(WebElement ele : allOptions)
		{
			if(ele.getText().equals(elementText))
			{
				System.out.println("Element found in the options");
				return true;
			}
		}
		System.out.println("Element not found in the options");
		return false;
	}

}
