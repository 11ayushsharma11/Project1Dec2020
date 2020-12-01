package scripts;

import org.testng.annotations.Test;

import features.LoginFeature;
import generic.BaseLib;
import generic.ExcelUtilities;

public class LoginTest extends BaseLib{
	
	@Test
	public void loginTest()
	{
		String filePath = "./testData/testdata.xlsx";
		ExcelUtilities excelUtilities = new ExcelUtilities(filePath);
		LoginFeature loginFeature = new LoginFeature(driver);
		String userName = excelUtilities.readData("Sheet1", 1, 1);
		String password = excelUtilities.readData("Sheet1", 1, 2);
		loginFeature.login(userName, password);
		loginFeature.verifyLogin();
	}
	
	@Test
	public void invalidLoginTest()
	{
		String filePath = "./testData/testdata.xlsx";
		ExcelUtilities excelUtilities = new ExcelUtilities(filePath);
		LoginFeature loginFeature = new LoginFeature(driver);
		String userName = excelUtilities.readData("Sheet1", 2, 1);
		String password = excelUtilities.readData("Sheet1", 2, 2);
		loginFeature.login(userName, password);
		loginFeature.verifyInvalidLogin();
	}

}
