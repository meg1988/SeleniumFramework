package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.megha.SeleniumFramework.page.classes.HomePage;

public class UsingLog4j {
	
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(UsingLog4j.class);
	
	@Before
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		PropertyConfigurator.configure("src/test/java/log4j.properties");
	}
	
	@Test
	public void test()
	{
		driver.get(baseUrl);	
		//log.info("Navigate to flights tab");
		HomePage.navigateToFlights(driver);
		//log.info("Enter origin city");
		HomePage.fillOriginTextBox(driver, "NewYork");
		//log.info("Enter destination city");
		HomePage.fillDestinationTextBox(driver,"Chicago");
		//log.info("Enter departure date");
		HomePage.fillDepartureDateTextBox(driver,"02/25/2017");
		//log.info("Enter return date");
		HomePage.fillReturnDateTextBox(driver,"02/28/2017");
		//log.info("Click search button");
		HomePage.clickSearchButton(driver);
	}

	@After
	public void tearDown()
	{
		driver.quit();
	}

}
