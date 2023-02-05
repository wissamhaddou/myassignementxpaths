package testngautomationcode31jan2023;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriCombo {

	@BeforeMethod
	public void start() {
		System.out.println("im opening the browser");
	}

	@Test

	public void testcase1() {
		System.out.println("selenium code");
	}

	@Test

	public void testCase2() {
		System.out.println("my selenium code ");
	}

	@AfterMethod
	public void close() {

	}
}