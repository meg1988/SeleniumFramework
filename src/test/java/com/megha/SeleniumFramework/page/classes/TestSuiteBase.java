package com.megha.SeleniumFramework.page.classes;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestSuiteBase {
	
	protected WebDriver driver;
	protected HomePageFactory homePage;
	
	@Parameters({"platform","browser","version","url"})
	@BeforeClass(alwaysRun=true)
	public void setUp(String platform, String browser, String version, String url) throws MalformedURLException
	{
		driver = getWebDriverInstance(platform, browser, version, url);
		homePage = PageFactory.initElements(driver, HomePageFactory.class);
	}
	
	public static WebDriver getWebDriverInstance(String platform, String browser, String version, String url) throws MalformedURLException
	{
		String nodeUrl = "http://localhost:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		
		if(platform.equalsIgnoreCase("MAC"))
		{
			caps.setPlatform(Platform.MAC);
		}
		if(platform.equalsIgnoreCase("WINDOWS"))
		{
			caps.setPlatform(Platform.WINDOWS);
		}
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			caps = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),caps);
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			caps = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),caps);
		}
		
		if(browser.equalsIgnoreCase("safari"))
		{
			caps = DesiredCapabilities.safari();
		}
		
		caps.setVersion(version);
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);
		
		return driver;
	}
}
