package utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTypes {
	
	WebDriver driver;
	Logger log = Logger.getLogger(WaitTypes.class);
	
	public WaitTypes(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement waitForElement(By locator, int timeout)
	{
		WebElement element = null;
		
		try
		{
			log.info("Waiting for maximum of '" + timeout + "' seconds for element to be available");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			log.info("Element appeared on the Webpage");

		}
		catch(Exception e)
		{
			log.error("Element did not appear on the Webpage");
		}
	
		return element;
	}
	
	public void clickWhenReady(WebElement element, int timeout)
	{
		
		try
		{
			WebElement e1 = null;
			log.info("Waiting for maximum of '" + timeout + "' seconds for element to be clickable");
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			e1= wait.until(ExpectedConditions.elementToBeClickable(element));
			e1.click();
			log.info("Element clicked on the Webpage");

		}
		catch(Exception e)
		{
			log.error("Element not clickable");
		}
	}
		public void clickWhenVisible(WebElement element, int timeout)
		{
			
			try
			{
				WebElement e1 = null;
				log.info("Waiting for maximum of '" + timeout + "' seconds for element to be clickable");
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				e1= wait.until(ExpectedConditions.visibilityOf(element));
				e1.click();
				log.info("Element clicked on the Webpage");

			}
			catch(Exception e)
			{
				log.error("Element not clickable");
			}
	
	}
}
