package com.tutorialsninja.framwork.tutorialsninjahybridframwork;

import java.sql.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qautils.Utilities;


public class Login extends Base {

	
	WebDriver driver;


	
	
	@BeforeMethod
	public void setup()  {
	loadpropertiesFile();
		driver=initializebrowserandopenapplicationURL(prop.getProperty("browserName"));
	
			driver.findElement(By.linkText("My Account")).click();  
	         driver.findElement(By.linkText("Login")).click();
	}
	 

@Test(priority=1,dataProvider="validCredenialsSupplier")
public void verifyLoginWithValidcredentials() {
	
	
			driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
			driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
			
		
			
	}

@DataProvider(name="validCredenialsSupplier")
public  Object[][] supplyTestData() {
	Object[][] data =Utilities.getTestDataFromExcel("Login");
	
	
  return data;
}

@Test(priority=2)
	public void verifyLoginWithInvalidcredentials () {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailwithtimestamp());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidpassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Alert alert = driver.switchTo().alert();
		String actualWarningMessage = driver.findElement(By.xpath("//div [contains (@ class , 'alert-dismissible')]")).getTagName();
		String expectedWarningMessage =dataProp.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"expected warning message is displayed");
	}
	@Test(priority=3)
	public void verifyLoginwithinvalidemailandvalidpassword() {
		
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailwithtimestamp());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		

		
		String actualWarningMessage = driver.findElement(By.xpath("//div [contains (@ class , 'alert-dismissible')]")).getTagName();
		String expectedWarningMessage ="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"expected warning message is displayed");
		}
		
	
	@Test(priority=4)
	
	public void verifyLoginwithvalidemailandinvalidpassword() {
		
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("ivalidpassword"));
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div [contains (@ class , 'alert-dismissible')]")).getTagName();
		String expectedWarningMessage =dataProp.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"expected warning message is displayed");
		
	}
	@Test(priority=5)
	public void verifyloginwithoutprividingcredentials() {
		
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarningMessage = driver.findElement(By.xpath("//div [contains (@ class , 'alert-dismissible')]")).getTagName();
		String expectedWarningMessage =dataProp.getProperty("emailpasswordnomatchwarning");
		Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage),"expected warning message is displayed");
		
	
	}	
	
	@AfterMethod 
	public void  teadown() {
		driver.quit();
		
	}
		}
	

		

	
	

