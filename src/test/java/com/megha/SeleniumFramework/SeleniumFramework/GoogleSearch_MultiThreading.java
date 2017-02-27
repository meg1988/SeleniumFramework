package com.megha.SeleniumFramework.SeleniumFramework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearch_MultiThreading {
  
	private WebDriver driver;
	private String baseUrl;
	
	Logger log = Logger.getLogger(GoogleSearch_MultiThreading.class);
	@BeforeClass
	public void beforeClass() {
		PropertyConfigurator.configure("/Users/megharastogi/SeleniumFramework/src/test/java/log4j.properties");
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseUrl = "http://www.google.com";
	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
  
	//@Test(threadPoolSize = 2 ,invocationCount = 3)
	@Test(invocationCount = 2)
	public void test() {
		
		log.info("[Start] Thread id :: " + Thread.currentThread().getId() + " is started");
		driver.findElement(By.id("lst-ib")).sendKeys("TestNG");
		log.info("Element found and entered the desired text");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
		log.info("[End] Thread id :: " + Thread.currentThread().getId() + " is ended");


		
	}
  
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
