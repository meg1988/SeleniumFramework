package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePage;

public class TestNGExample {
	
	private WebDriver driver;
	private String baseUrl;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);	
	}
	
	@Test
	public void test()
	{
		HomePage.navigateToFlights(driver);
		HomePage.fillOriginTextBox(driver, "NewYork");
		HomePage.fillDestinationTextBox(driver,"Chicago");
		HomePage.fillDepartureDateTextBox(driver,"02/25/2017");
		HomePage.fillReturnDateTextBox(driver,"02/28/2017");
		HomePage.clickSearchButton(driver);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
