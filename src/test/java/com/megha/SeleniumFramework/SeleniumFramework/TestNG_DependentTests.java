package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePageFactory;
import com.megha.SeleniumFramework.page.classes.SelectFlightPageFactory;

public class TestNG_DependentTests {
	
	private WebDriver driver;
	private String baseUrl;
	private HomePageFactory homePage;
	private SelectFlightPageFactory selectFlight;
	Logger log = Logger.getLogger(TestNG_DependentTests.class);
	
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

	@Test
	public void searchFlights() throws Exception {
		
		homePage.clickFlightTab();
		homePage.clickHeaderHistory();
		homePage.clickRoundTrip();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("02/25/2017");
		homePage.setReturnDate("02/28/2017");
		homePage.clickSearchButton();
	}
	
	@Test(dependsOnMethods={"searchFlights"})
	public void selectMorningFlights() throws Exception {
		Thread.sleep(5000);
		selectFlight.clickMorningFlight();
	}
	
	
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}

}
