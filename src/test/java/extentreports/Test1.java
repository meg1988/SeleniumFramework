package extentreports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 {
	private WebDriver driver;
	private String baseUrl;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		report = ExtentFactory.getInstance();
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
		emailField.sendKeys("test@email.com");
		
		test.log(LogStatus.INFO, "Entered the email");
		
		WebElement passwordField = driver.findElement(By.xpath("//div[@id='memberLoginDialogpassword']//input"));
		passwordField.sendKeys("abcabc");
		
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
	
	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
