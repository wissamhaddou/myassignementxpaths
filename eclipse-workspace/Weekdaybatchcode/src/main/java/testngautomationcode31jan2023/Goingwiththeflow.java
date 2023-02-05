package testngautomationcode31jan2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Goingwiththeflow {

public WebDriver driver;

@BeforeMethod
public void openRediff() {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://facebook.com");
}
	
@Test

public void clickOnSignInLink() {
	driver.findElement(By.linkText("Create new account")).click();
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}



