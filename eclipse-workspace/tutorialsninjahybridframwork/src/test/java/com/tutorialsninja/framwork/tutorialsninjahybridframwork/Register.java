package com.tutorialsninja.framwork.tutorialsninjahybridframwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qautils.Utilities;
public class Register extends Base {
	

		WebDriver driver;
	
		@BeforeMethod
		public void setup()  {
			loadpropertiesFile();
		driver=initializebrowserandopenapplicationURL (prop.getProperty("browserName")) ;
			
				driver.findElement(By.linkText("My Account")).click();
		        driver.findElement(By.linkText("Register")).click();
		}
		        @Test(priority=1)
		       
		    	public void verifyRegisteringAnAccountwithmandatoryfields() {
		    	   
		       
		        driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
		        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
		        
		   
				driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailwithtimestamp());
		        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
		        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpassword"));
		        driver.findElement(By.name("agree")).click();
		        driver.findElement(By.xpath("//input[@value='Continue']")).click();
		        
		        String actualSuccessHeading =driver.findElement(By.id("//div[@id='content'/h1]")).getText();
		        Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountsuccesfullycreatedheading"),"Account success page is not displayed")	;
		        
		       
		        
		
		}
	@Test (priority=2)
	public void verifyRegisteringAccountbyprovidingallfields() {
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
   
		driver.findElement(By.id("input-email")).sendKeys(Utilities.generateEmailwithtimestamp());
        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpassword"));
       driver.findElement(By.xpath("//input [@name = 'newsletter'][@value ='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        String actualSuccessHeading =driver.findElement(By.id("//div[@id='content'/h1]")).getText();
        Assert.assertEquals(actualSuccessHeading,dataProp.getProperty("accountsuccesfullycreatedheading"),"Account success page is not displayed")	;
        
      
	}
	
	@Test (priority=3)
	
		
	public void verifyRegistringaccountwithexistingemailadress	() {
	
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));
   
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validemail"));
        driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validpassword"));
        driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validpassword"));
       driver.findElement(By.xpath("//input [@name = 'newsletter'][@value ='1']")).click();
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        
        String actualWarningMessage = driver.findElement(By.xpath("//div [contains (@ class , 'alert-dismissible')]")).getText();
		Assert.assertTrue(actualWarningMessage.contains(dataProp.getProperty("duplicateemailwarning")),"warning message is not displayed");
   
		
       
        
	}
	@Test (priority=4)
	public void verifyRegisteringAccountwithoutfillinganydetails () {
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	    String actualPrivacyPolicyWarning =driver.findElement(By.xpath("//div [contains (@ class , 'alert-dismissible')]")).getText();
	    Assert.assertTrue(actualPrivacyPolicyWarning.contains(dataProp.getProperty("privicypolicywarning")),"warning message is not displayed");
	   
	     String actualFirstNameWarning = driver.findElement(By.xpath("//input(@id='input-firstname']/following-sibling::div")).getText();
	     Assert.assertEquals(actualFirstNameWarning, (dataProp.getProperty("firstnamewarning")),"First Name Warning message is not displayed");
	
	
	     String actualLastNameWarning = driver.findElement(By.xpath("//input(@id='input-lasttname']/following-sibling::div")).getText();
	     Assert.assertEquals(actualLastNameWarning, (dataProp.getProperty("lastnamewarning")),"Last Name Warning message is not displayed");
	
	     String actualEmailWarning = driver.findElement(By.xpath("//input(@id='input-email']/following-sibling::div")).getText();
	     Assert.assertEquals(actualEmailWarning,(dataProp.getProperty("emailwarning")),"Email Warning message is not displayed");
	
	     String actualTelephoneWarning = driver.findElement(By.xpath("//input(@id='input-telephone']/following-sibling::div")).getText();
	     Assert.assertEquals(actualTelephoneWarning, (dataProp.getProperty("phonenumberwarning")),"Telephone Warning message is not displayed");
	
	     String actualPasswordWarning = driver.findElement(By.xpath("//input(@id='input-password']/following-sibling::div")).getText();
	     Assert.assertEquals(actualPasswordWarning, (dataProp.get("passwordwarning")),"Password Warning message is not displayed");
	
	     
	}

   @AfterMethod
   public void teardown() {
	   
	   driver.quit();
   }

}


	

			
		
		

		
		
		
		



