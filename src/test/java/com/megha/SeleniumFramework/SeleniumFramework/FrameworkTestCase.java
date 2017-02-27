package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.megha.SeleniumFramework.page.classes.HomePage;
import com.megha.SeleniumFramework.page.classes.HomePageFactory;

public class FrameworkTestCase {
	
	private WebDriver driver;
	private String baseUrl;
	private HomePageFactory homePage;
	
	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homePage = new HomePageFactory(driver);
		driver.get(baseUrl);
		
	}
	
	@Test
	public void test()
	{
		homePage.clickFlightTab();
		homePage.clickHeaderHistory();
		homePage.clickRoundTrip();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("02/25/2017");
		homePage.setReturnDate("02/28/2017");
		homePage.clickSearchButton();
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}
}
