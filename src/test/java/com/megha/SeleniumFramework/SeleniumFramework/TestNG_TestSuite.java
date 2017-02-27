package com.megha.SeleniumFramework.SeleniumFramework;

import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePageFactory;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class TestNG_TestSuite {
  
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(TestNG_TestSuite.class);
	HomePageFactory homePage;
	
	@BeforeClass
	public void beforeClass() {
		
		PropertyConfigurator.configure("src/test/java/log4j.properties");
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		homePage = new HomePageFactory(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);	

	  }
	
	@Test
	public void fillBasicInfo() throws Exception{
		
		homePage.clickFlightTab();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("02/25/2017");
		homePage.setReturnDate("02/28/2017");
		Thread.sleep(3000);
	}
  
	@Test
	public void fillAdvancedInfo() throws Exception{
		homePage.clickAdvancedOptions();
		Thread.sleep(3000);
		homePage.clickNonStopLabel();
		homePage.selectPreferredClass("first");
	}

	
	
	@AfterClass
	public void afterClass() {
	}
	
}
