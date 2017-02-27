package com.megha.SeleniumFramework.page.classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.megha.SeleniumFramework.SeleniumFramework.TestNG_DependentTests;

public class HomePageFactory {
	
	WebDriver driver;
	Logger log = Logger.getLogger(HomePageFactory.class);

	
	@FindBy(id="header-history")
	WebElement headerHistory;
	
	@FindBy(id="tab-flight-tab-hp")
	WebElement flightTab;
	
	@FindBy(id="flight-origin-hp-flight")
	WebElement originCity;
	
	@FindBy(id="flight-destination-hp-flight")
	WebElement destinationCity;
	
	@FindBy(id="flight-departing-hp-flight")
	WebElement departureDate;
	
	@FindBy(id="flight-returning-hp-flight")
	WebElement returnDate;
	
	@FindBy(xpath=".//button[@type='submit']")
	WebElement searchButton;
	
	@FindBy(id="flight-type-roundtrip-label-hp-flight")
	WebElement roundTrip;
	
	@FindBy(id="flight-type-one-way-label-hp-flight")
	WebElement oneWay;
	
	@FindBy(id="flight-type-multi-dest-label-hp-flight")
	WebElement mutlipleDestination;
	
	@FindBy(id="flight-advanced-options-hp-flight")
	WebElement advancedOptions;
	
	@FindBy(id="advanced-flight-nonstop-hp-flight")
	WebElement nonStopLabel;

	@FindBy(id="flight-advanced-preferred-class-hp-flight")
	WebElement preferredClass;
	
	public HomePageFactory(WebDriver driver)
	{
		this.driver=driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void clickFlightTab()
	{
		flightTab.click();
		log.info("Clicked on the flight tab");

	}
	
	public void clickHeaderHistory()
	{
		headerHistory.click();
		log.info("Clicked on the header history");

	}
	
	public void setOriginCity(String origin)
	{
		originCity.sendKeys(origin);
		log.info("Entered the origin city as : " + origin);

	}
	
	public void setDestinationCity(String destination)
	{
		destinationCity.sendKeys(destination);
		log.info("Entered the destination city as : " + destination);

	}
	
	public void setDepartureDate(String date)
	{
		departureDate.sendKeys(date);
		log.info("Entered the departure date as : " + date);

	}
	
	public void setReturnDate(String date)
	{
		returnDate.clear();
		returnDate.sendKeys(date);
		log.info("Entered the return date as : " + date);

	}
	
	public void clickSearchButton()
	{
		searchButton.click();
		log.info("Clicked on the search button");

	}
	
	public void clickRoundTrip()
	{
		roundTrip.click();
		log.info("Clicked on the Round trip tab ");

	}
	public void clickMutlipleDestination()
	{
		mutlipleDestination.click();
		log.info("Clicked on the Mutliple Destination option");

	}
	public void clickOneWay()
	{
		oneWay.click();
		log.info("Clicked on the one-way radio button");

	}
	
	public void clickAdvancedOptions()
	{
		advancedOptions.click();
		log.info("Clicked on the advanced options");

	}
	
	public void clickNonStopLabel()
	{
		nonStopLabel.click();
		log.info("Clicked on Non stop label");
	}
	
	public void selectPreferredClass(String value)
	{
		Select sel = new Select(preferredClass);
		sel.selectByValue(value);
		log.info("Selected the dropdown with value : " + value);

	}
	
	public void clearAllFields()
	{
		originCity.clear();
		destinationCity.clear();
		departureDate.clear();
		returnDate.clear();
	}
}
