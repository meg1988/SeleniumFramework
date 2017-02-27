package com.megha.SeleniumFramework.SeleniumFramework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.megha.SeleniumFramework.page.classes.HomePageFactory;

public class SeleniumGrid_ParallelTest {
  
	private WebDriver driver;
	private String baseUrl;
	private String nodeUrl;
	static Logger log = Logger.getLogger(SeleniumGrid_ParallelTest.class);
	HomePageFactory homePage;
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		PropertyConfigurator.configure("src/test/java/log4j.properties");
		//System.setProperty("webdriver.chrome.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/chromedriver");
		baseUrl = "https://www.expedia.com";
		nodeUrl = "http://localhost:5555/wd/hub";
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setBrowserName("firefox");
		caps.setPlatform(Platform.MAC);
		
		driver = new RemoteWebDriver(new URL(nodeUrl), caps);
		
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
		homePage.clickSearchButton();
		Thread.sleep(3000);
	}
  
	@AfterClass
	public void afterClass() {
		
		//driver.quit();
	}
	
}
