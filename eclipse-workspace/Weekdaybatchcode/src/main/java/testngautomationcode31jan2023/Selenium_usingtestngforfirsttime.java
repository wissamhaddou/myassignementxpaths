package testngautomationcode31jan2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium_usingtestngforfirsttime {
	public WebDriver driver;

	@BeforeMethod
	public void openbrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rediff.com");
	}

	@Test(priority = 1)
	public void clickOnSignInLink() {
		driver.findElement(By.className("signin")).click();
	}

	@Test(priority = 2)
	public void ClickOnMoneyLink() {
		driver.findElement(By.linkText("Money")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}