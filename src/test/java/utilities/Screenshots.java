package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {
	
	public static String takeScreenshot(WebDriver driver, String testName) throws IOException
	{
		Long randomFile = new Date().getTime()*1000 ;
		String fileName = testName + "_" + randomFile.toString() + ".png";
		String destination = "/Users/megharastogi/Desktop/" + fileName;
		File destinationDirectory = new File(destination);
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, destinationDirectory);
		
		return destination;
		
	}

}
