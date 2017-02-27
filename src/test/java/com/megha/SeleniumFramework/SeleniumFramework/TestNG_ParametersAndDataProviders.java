package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePageFactory;
import com.megha.SeleniumFramework.page.classes.SelectFlightPageFactory;

public class TestNG_ParametersAndDataProviders {
	
	private WebDriver driver;
	private String baseUrl;
	private HomePageFactory homePage;
	private SelectFlightPageFactory selectFlight;
	Logger log = Logger.getLogger(TestNG_ParametersAndDataProviders.class);
	
	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure("/Users/megharastogi/SeleniumFramework/src/test/java/log4j.properties");
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
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
