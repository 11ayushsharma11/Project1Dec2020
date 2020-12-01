package scripts;

import org.testng.annotations.Test;

import features.LoginFeature;
import features.TaskFeature;
import generic.BaseLib;
import generic.ExcelUtilities;

public class TaskTest extends BaseLib{
	
	@Test
	public void createCustomer() throws InterruptedException
	{
		String filePath = "./testData/testdata.xlsx";
		ExcelUtilities excelUtilities = new ExcelUtilities(filePath);
		LoginFeature loginFeature = new LoginFeature(driver);
		String userName = excelUtilities.readData("Sheet1", 1, 1);
		String password = excelUtilities.readData("Sheet1", 1, 2);
		loginFeature.login(userName, password);
		loginFeature.verifyLogin();
		
		Thread.sleep(3000);
		
		TaskFeature taskFeature = new TaskFeature(driver);
		String customerName = excelUtilities.readData("sheet1", 3, 3);
		taskFeature.createCustomer(customerName);
		taskFeature.verifyCreatedCustomer(customerName);
	}

}
