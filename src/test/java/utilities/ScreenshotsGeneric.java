package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotsGeneric {
	
	public static String getRandomString(int length)
	{
		StringBuilder sb = new StringBuilder();
		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		for (int i=0; i<length ; i++)
		{
			int index = (int)(Math.random() * characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	public void takesScreenshot(WebDriver driver) throws IOException {
		String randomFileName = getRandomString(10) + ".png";
		File destinationDirectory = new File("/Users/megharastogi/Desktop/screenshots/" + randomFileName);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, destinationDirectory);
	}

	

}
