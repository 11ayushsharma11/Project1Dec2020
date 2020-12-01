package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestListener implements ITestListener {
	
	public static int executionCount, passCount, failCount, skipCount;

	@Override
	public void onTestStart(ITestResult result) {
		executionCount++;
		Reporter.log(result.getName() + " script execution started " + new Date(), true);
		
		System.out.println(Thread.currentThread().getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		Reporter.log(result.getName() + " script passed " + new Date(), true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		failCount++;
		TakesScreenshot ts = (TakesScreenshot)BaseLib.driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("./screenShots/newImage.png");
		try
		{
			Files.copy(sourceFile, destinationFile);
			System.out.println("Screenshot taken successfully");
		}
		catch(IOException exception)
		{
			System.out.println("Screenshot failed");
			exception.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skipCount++;
		Reporter.log(result.getName() + " script skipped " + new Date(), true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		//no implementation
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		//no implementation
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName() + " suite execution started " + new Date(), true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log(context.getName() + " suite execution finished " + new Date(), true);
		Reporter.log("Number of scripts executed " + executionCount,true);
		Reporter.log("Number of scripts passed " + passCount,true);
		Reporter.log("Number of scripts skipped " + skipCount,true);
		Reporter.log("Number of scripts failed " + failCount,true);
	}
	
}
