package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePageFactory;
import com.megha.SeleniumFramework.page.classes.SelectFlightPageFactory;

public class TestNG_MultipleBrowsers_ParallelTests {
	
	private WebDriver driver;
	private String baseUrl;
	private HomePageFactory homePage;
	private SelectFlightPageFactory selectFlight;
	Logger log = Logger.getLogger(TestNG_MultipleBrowsers_ParallelTests.class);
	
	@BeforeClass
	@Parameters({"browserType"})
	public void beforeClass(String browserType) {
		PropertyConfigurator.configure("/Users/megharastogi/SeleniumFramework/src/test/java/log4j.properties");
		baseUrl = "https://www.expedia.com";
		if(browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/chromedriver");
			driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("safari"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homePage = new HomePageFactory(driver);
		selectFlight = new SelectFlightPageFactory(driver);
		driver.get(baseUrl);
	}

	@Parameters({"origin","destination","departureDate","returnDate"})
	@Test
	public void searchFlights(String origin, String destination, String departureDate, String returnDate) throws Exception {
		
		homePage.clickFlightTab();
		homePage.clickHeaderHistory();
		homePage.clickRoundTrip();
		homePage.setOriginCity(origin);
		homePage.setDestinationCity(destination);
		homePage.setDepartureDate(departureDate);
		homePage.setReturnDate(returnDate);
		homePage.clickSearchButton();
	}
	
	@DataProvider(name = "fieldsInputs")
	public static Object[][] searchData()
	{
		return new Object[][]{
			{"New York" , "Chicago" , "02/25/2017" ,"02/28/2017"},
			{"Boston", "San Francisco", "03/25/2017","03/28/2017" }
		};
	}
	
	@Test(dataProvider="fieldsInputs")
	public void searchFlightsWithMultipleOption(String origin, String destination, String departureDate, String returnDate) throws Exception {
		
		homePage.clickFlightTab();
		homePage.clickRoundTrip();
		homePage.clearAllFields();
		Thread.sleep(3000);
		homePage.setOriginCity(origin);
		homePage.setDestinationCity(destination);
		homePage.setDepartureDate(departureDate);
		homePage.setReturnDate(returnDate);
		Thread.sleep(3000);
	}
	
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
}
