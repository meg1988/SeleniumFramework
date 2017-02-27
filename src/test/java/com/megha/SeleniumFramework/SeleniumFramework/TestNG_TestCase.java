package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePageFactory;

public class TestNG_TestCase {
  
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(TestNG_TestCase.class);
	HomePageFactory homePage;
	
	public WebDriver getDriver()
	{
		return driver;
	}
	
	@BeforeClass
	public void beforeClass() {
		
		PropertyConfigurator.configure("src/test/java/log4j.properties");
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		homePage = new HomePageFactory(driver);
		driver.manage().window().maximize();
	  }
	
	@BeforeMethod
	public void beforeMethod()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() throws Exception{
		
		driver.get(baseUrl);	
		homePage.clickFlightTab();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		
	}
	
	@Test
	public void test2() throws Exception{

		homePage.setDepartureDate("02/25/2017");
		homePage.setReturnDate("02/28/2017");
	}


	
	
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	
}
