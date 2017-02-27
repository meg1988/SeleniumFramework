package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.megha.SeleniumFramework.SeleniumFramework.TestNG_TestCase;

public class SeleniumListeners implements ITestListener, ISuiteListener,IInvokedMethodListener
{
	ScreenshotsGeneric ss = new ScreenshotsGeneric();
	
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String textMsg = "beforeInvocation - About to begin executing following method : "
				+ returnMethodName(method.getTestMethod());
		Reporter.log(textMsg, true);
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		// TODO Auto-generated method stub
		String textMsg = "afterIncovation - Completed executing following method : "
				+ returnMethodName(method.getTestMethod());
		Reporter.log(textMsg, true);
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("onStart Suite - About to begin executing Suite " + suite.getName(), true);

	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("onFinish Suite - About to end executing Suite " + suite	.getName(), true);

	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
        WebDriver driver = ((TestNG_TestCase) currentClass).getDriver();

		try {
			ss.takesScreenshot(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printTestResults(result);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		Object currentClass = result.getInstance();
        WebDriver driver = ((TestNG_TestCase) currentClass).getDriver();

		try {
			ss.takesScreenshot(driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		printTestResults(result);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("onStart Test - About to begin executing Test set " + context.getName(), true);

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("onFinish Test - Completed executing Test set " + context.getName(), true);

	}
	
	// This will return method names to the calling function
		private String returnMethodName(ITestNGMethod method) {
			return method.getRealClass().getSimpleName() + "."
					+ method.getMethodName();
		}
		
		private void printTestResults(ITestResult result) {
			Reporter.log("Test Method resides in "
					+ result.getTestClass().getName(), true);

			String status = null;
			switch (result.getStatus()) {
			case ITestResult.SUCCESS:
				status = "Pass";
				break;
			case ITestResult.FAILURE:
				status = "Failed";
				break;
			case ITestResult.SKIP:
				status = "Skipped";
			}
			Reporter.log("Test Status: " + status, true);
		}

	
}
