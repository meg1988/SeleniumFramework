package robo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
  
	private WebDriver driver;
	private String baseUrl;
	
  @BeforeClass
  public void beforeClass() {
	  
	  System.setProperty("webdriver.gecko.driver", "/Users/megharastogi/PycharmProjects/SeleniumProject/lib/geckodriver");
	  baseUrl = "https://www.gmail.com";
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get(baseUrl);
	  
  }

  @Test
  public void testFileUpload() throws AWTException, InterruptedException {
	  
	  //driver.findElement(By.xpath(".//a[text() = 'Sign In']"));
	  driver.findElement(By.id("Email")).sendKeys("megharastogi92.8@gmail.com");
	  driver.findElement(By.id("next")).click();
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.id("Passwd")).sendKeys("luckybestie");
	  driver.findElement(By.id("signIn")).click();
	  
	  driver.findElement(By.xpath(".//div[text() = 'COMPOSE']")).click();
	  
	  Thread.sleep(3000);

	  driver.findElement(By.xpath(".//div[@class='wO nr l1']//textarea")).sendKeys("millionairemanas@gmail.com");
	  driver.findElement(By.name("subjectbox")).sendKeys("Resume Copy from selenium");
	  
	  driver.findElement(By.xpath(".//div[@class='a1 aaA aMZ']")).click();
	  
	  String filePath = "/Users/megharastogi/Documents/resumes/Megha.pdf";
	  
	  StringSelection ss = new StringSelection(filePath);
	  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	  
	  Robot robot = new Robot();
	  
	  Thread.sleep(3000);

	  robot.keyPress(KeyEvent.VK_META);
	  robot.keyPress(KeyEvent.VK_TAB);
	  robot.keyRelease(KeyEvent.VK_META);
	  robot.keyRelease(KeyEvent.VK_TAB);
	  
	  Thread.sleep(3000);

	  robot.keyPress(KeyEvent.VK_META);
	  robot.keyPress(KeyEvent.VK_SHIFT);
	  robot.keyPress(KeyEvent.VK_G);
	  robot.keyRelease(KeyEvent.VK_G);
	  robot.keyRelease(KeyEvent.VK_SHIFT);
	  robot.keyRelease(KeyEvent.VK_META);

	  Thread.sleep(3000);

	  robot.keyPress(KeyEvent.VK_META);
	  robot.keyPress(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_V);
	  robot.keyRelease(KeyEvent.VK_META);

	  Thread.sleep(3000);

	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);

	  Thread.sleep(3000);

	  robot.keyPress(KeyEvent.VK_ENTER);
	  robot.keyRelease(KeyEvent.VK_ENTER);

	  Thread.sleep(3000);

	  driver.findElement(By.xpath(".//div[text()='Send']")).click();
  }
  
  @AfterClass
  public void afterClass() {
  }

}
