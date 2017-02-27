package com.megha.SeleniumFramework.SeleniumFramework;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpConnection;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.megha.SeleniumFramework.page.classes.HomePage;

public class FindLinks {
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver","/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
		baseUrl = "https://www.expedia.com";
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void testFindLinks()
	{
		driver.get(baseUrl);
		HomePage.navigateToFlights(driver);
		
		List<WebElement> linkslist = clickableLinks(driver);
		
		for(WebElement e : linkslist)
		{
			String href = e.getAttribute("href");
			try
			{
				System.out.println("URL : " + href + ":: Link Status : " + linkStatus(new URL(href)));
			}
			catch(Exception exp)
			{
				System.out.println(exp.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver)
	{
		List<WebElement> linkstoClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement e : elements)
		{
			if(e.getAttribute("href") != null)
			{
				linkstoClick.add(e);
			}
		}
		
		return linkstoClick;
	}
	
	public static String linkStatus(URL url)
	{
		try
		{
			HttpURLConnection http = (HttpURLConnection)url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;

			
		}catch(Exception e)
		{
			return e.getMessage();
		}
		

	}

	@After
	public void TearDown()
	{
		driver.quit();
	}
}
