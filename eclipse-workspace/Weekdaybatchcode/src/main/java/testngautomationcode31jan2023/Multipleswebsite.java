package testngautomationcode31jan2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Multipleswebsite {

 public WebDriver driver;
  @BeforeMethod
  public void openBrowser() {
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
  }
  @Test
  public void openamazon() {
	  driver.get("https://amazon.com");
  }
  @Test
  public void openwalmart() {
	  driver.get("https://walmart.com");
  }
@Test
public void openFlipkart() {
	driver.get("https://flipkart.com");
}
@AfterMethod
public void tearDown() {
	driver.quit();
}
}