package oops_java_programming31jan2023;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterTest;


public class Annotation {

	
		   @BeforeSuite
			 public void BeforeSuit() {
			System.out.println("this is befotre suite annotation");
				}
			@BeforeTest
			public void beforetest() {
			System.out.println("this is before test annotation");
			  }
			@BeforeClass
			public void Beforeclass() {
				System.out.println("this is before class annotation");
			}
			@BeforeMethod
			public void Beforemethod() {
				System.out.println("this is before method annotation");
			}
			@BeforeGroups
			private void beforegroup() {
				System.out.println("this is before group annotation");
			}
			
			@AfterSuite
			public void AfterSuite() {
				System.out.println("this is after suite annotation");
			}
		   @AfterTest
		   public void AftereTest() {
		  System.out.println("this is after test annotation");
		  }
		  @AfterClass
		  public void AfterClass() {
			System.out.println("this is after class annotation");
		  }
		  @AfterMethod
		  public void AfterMethod() {
			System.out.println("this is after method annotation");
		  }
		  @AfterGroups
		  private void AfterGroups() {
			System.out.println("this is after group annotation");
		}
			}
				
			
			
