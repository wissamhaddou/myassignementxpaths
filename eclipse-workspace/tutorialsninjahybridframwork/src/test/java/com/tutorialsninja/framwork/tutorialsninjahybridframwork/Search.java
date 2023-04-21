package com.tutorialsninja.framwork.tutorialsninjahybridframwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class Search extends Base {

	
	WebDriver driver;



	@BeforeMethod
	public void setup() {
		loadpropertiesFile();
		driver = initializebrowserandopenapplicationURL(prop.getProperty("browserName"));
	}

	@Test(priority = 1)

	public void verifysearchwithvalidproduct() {

		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validproduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),
				"valid product hp is not displayed in search results");

	}

	@Test(priority = 2)

	public void verifysearchwithinvalidproduct() {

		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validproduct"));
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//div[@class='container']//h2/following-sibling::p"))
				.getText();

		Assert.assertEquals(actualSearchMessage, (dataProp.getProperty("noproducttextinsearchresults")),
				"no product Message in search result is not displayed");

	}

	@Test(priority = 3)

	public void verifysearchwithoutanyproduct() {

	
		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		String actualSearchMessage = driver.findElement(By.xpath("//div[@class='container']//h2/following-sibling::p"))
				.getText();

		Assert.assertEquals(actualSearchMessage,(dataProp.getProperty("noproducttextinsearchresults")),
				"no product Message in search result is not displayed");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
