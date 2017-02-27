package com.megha.SeleniumFramework.SeleniumFramework;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilesDemoChrome {

	private WebDriver driver;
	private String baseUrl;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/chromedriver");
		 //Users/megharastogi/Library/Application Support/Google/Chrome/Default/Extensions/aohghmighlieiainnegkcijnfilokake/0.9_0.crx
		ChromeOptions options = new ChromeOptions();
		options.addExtensions(new File("/Users/megharastogi/Library/Application Support/Google/Chrome/Default/Extensions/aohghmighlieiainnegkcijnfilokake/0.9_0.crx"));
		
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		baseUrl = "http://www.google.com";
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}
	
	@Test
	public void test() {
		
		driver.findElement(By.id("lst-ib")).sendKeys("TestNG");
	}
	
}
