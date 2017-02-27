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
import com.megha.SeleniumFramework.page.classes.TestSuiteBase;

public class SeleniumGrid_ParallelTestFramework extends TestSuiteBase{

	static Logger log = Logger.getLogger(SeleniumGrid_ParallelTestFramework.class);
	
	@BeforeClass
	public void beforeClass() throws MalformedURLException {
		
		PropertyConfigurator.configure("src/test/java/log4j.properties");			
	  }
	
	@Test
	public void fillBasicInfo() throws Exception{
		
		homePage.clickFlightTab();
		homePage.setOriginCity("New York");
		homePage.setDestinationCity("Chicago");
		homePage.setDepartureDate("03/25/2017");
		homePage.setReturnDate("03/28/2017");
		homePage.clickSearchButton();
	}
  
	@AfterClass
	public void afterClass() {
		
		driver.quit();
	}
	
}
