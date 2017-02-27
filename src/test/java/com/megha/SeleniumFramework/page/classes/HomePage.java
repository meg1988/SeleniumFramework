package com.megha.SeleniumFramework.page.classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public static WebElement element = null;
	public static Logger log = Logger.getLogger(HomePage.class);
	
	/**
	 * Returns flight origin text box element
	 * @param driver
	 * @return
	 */
	
	public static WebElement originTextBox(WebDriver driver)
	{
		element = driver.findElement(By.id("flight-origin"));
		log.info("Origin text box element found");
		return element;
	}
	
	public static void fillOriginTextBox(WebDriver driver,String origin)
	{
		originTextBox(driver).sendKeys(origin);
		log.info("Enter origin city as : " + origin);

	}
	/**
	 * Returns flight destination text box element
	 * @param driver
	 * @return
	 */
	
	public static WebElement destinationTextBox(WebDriver driver)
	{
		element = driver.findElement(By.id("flight-destination"));
		return element;
	}
	
	public static void fillDestinationTextBox(WebDriver driver,String destination)
	{
		destinationTextBox(driver).sendKeys(destination);
	}
	
	/**
	 * Returns departure date text box element
	 * @param driver
	 * @return
	 */
	
	public static WebElement departureDateTextBox(WebDriver driver)
	{
		element = driver.findElement(By.id("flight-departing"));
		return element;
	}
	
	public static void fillDepartureDateTextBox(WebDriver driver,String departureDate)
	{
		departureDateTextBox(driver).sendKeys(departureDate);
	}
	
	
	/**
	 * Returns return date text box element
	 * @param driver
	 * @return
	 */
	
	public static WebElement returnDateTextBox(WebDriver driver)
	{
		element = driver.findElement(By.id("flight-returning"));
		return element;
	}
	
	public static void fillReturnDateTextBox(WebDriver driver,String returnDate)
	{
		returnDateTextBox(driver).sendKeys(returnDate);
	}
	
	/**
	 * Returns search button element
	 * @param driver
	 * @return
	 */
	public static WebElement searchButton(WebDriver driver)
	{
		element = driver.findElement(By.id("search-button"));
		return element;
	}
	
	/**
	 * Clicks on search button
	 * @param driver
	 *
	 */
	
	public static void clickSearchButton(WebDriver driver)
	{
		element = searchButton(driver);
		element.click();
	}
	
	/**
	 * Navigate to flights tab
	 * @param driver
	 *
	 */
	public static void navigateToFlights(WebDriver driver)
	{
		driver.findElement(By.id("header-history")).click();
		element = driver.findElement(By.id("tab-flight-tab"));
		element.click();
	}
}
