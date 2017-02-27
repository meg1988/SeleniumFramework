package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Expedia_MultiThreading {
  
	private WebDriver driver;
	private String baseUrl;
	static Logger log = Logger.getLogger(Expedia_MultiThreading.class);
	
	@BeforeClass
	public void beforeClass() {
		
		PropertyConfigurator.configure("src/test/java/log4j.properties");
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(baseUrl);	

	  }
	
	@Test
	public void testExpedia() throws Exception{
		
		String title = "Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares";
		log.info("[START] Thread Id : " + 
                Thread.currentThread().getId() + " is started!");
		System.out.println("Page Title is " + driver.getTitle());
		Assert.assertEquals(title, driver.getTitle());
		log.info("[END] Thread Id : " +
                Thread.currentThread().getId() + " is ended");
	}
  
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}
