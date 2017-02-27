package com.megha.SeleniumFramework.page.classes;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.megha.SeleniumFramework.SeleniumFramework.TestNG_DependentTests;

import utilities.WaitTypes;

public class SelectFlightPageFactory {
	
	WebDriver driver;
	Logger log = Logger.getLogger(SelectFlightPageFactory.class);

	
	@FindBy(id="leg0-morning-departure")
	WebElement morningFlight;
	
	public SelectFlightPageFactory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMorningFlight()
	{
		WaitTypes wait = new WaitTypes(driver);
		wait.clickWhenReady(morningFlight, 50);
		/*
		WebElement e1 = wait.waitForElement(By.xpath(".//*[@id='leg0-afternoon-departure']"), 50);
		e1.click();*/
		log.info("Clicked on Morning Time to filter the results");

	}

}
