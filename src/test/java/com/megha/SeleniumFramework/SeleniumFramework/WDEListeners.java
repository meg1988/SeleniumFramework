package com.megha.SeleniumFramework.SeleniumFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WDEListeners {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		String baseUrl = "https://www.expedia.com";
		WebDriver driver = new FirefoxDriver();
		
		EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
		HandleEvent he = new HandleEvent();
		
		eDriver.register(he);
		
		eDriver.get(baseUrl);
		
		Thread.sleep(3000);
		eDriver.findElement(By.id("tab-flight-tab-hp")).click();
	
	}

}
