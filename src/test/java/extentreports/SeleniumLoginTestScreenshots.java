package extentreports;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Screenshots;

public class SeleniumLoginTestScreenshots {
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		report = new ExtentReports("/Users/megharastogi/Desktop/reports/logintest.html");
		test = report.startTest("Verify Welcome text");
		baseUrl = "http://www.letskodeit.com/";
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		driver = new FirefoxDriver();
		
		test.log(LogStatus.INFO, "Browser started...");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximize...");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Web Application open...");

	}
	
	@Test
	public void test1_validLoginTest() throws Exception {
		WebElement signupLink = driver.findElement(By.id("comp-iiqg1vggactionTitle"));
		signupLink.click();
		
		test.log(LogStatus.INFO, "Clicked on signup link");

		WebElement loginLink = driver.findElement(By.id("signUpDialogswitchDialogLink"));
		loginLink.click();
		
		test.log(LogStatus.INFO, "Clicked on log-in link");

		WebElement emailField = driver.findElement(By.xpath("//div[@id='memberLoginDialogemail']//input"));
		emailField.sendKeys("test3@email.com");
		
		test.log(LogStatus.INFO, "Entered the email");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc1");
		
		test.log(LogStatus.INFO, "Entered the password");

		WebElement goButton = driver.findElement(By.id("memberLoginDialogoklabel"));
		goButton.click();
		
		test.log(LogStatus.INFO, "Clicked Go Button");

		Thread.sleep(3000);
		
		WebElement welcomeText = null;
		
		try {
			welcomeText = driver.findElement(By.xpath("//div[text()='Hello test@email.com']"));
		}
		catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.ERROR, "No such element found");

		}
		Assert.assertTrue(welcomeText != null);
		test.log(LogStatus.PASS, "Login Successful");

	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus() == ITestResult.FAILURE)
		{
			String path = Screenshots.takeScreenshot(driver, result.getName());
			String imagePath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Verify Welcome test is unsuccessful" , imagePath);
			}
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
