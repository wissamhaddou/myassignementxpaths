package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class Base {

	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public void loadpropertiesFile(){
	 
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")
		
			+ "\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		dataProp =new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		
		try {
		
			FileInputStream datafis = new FileInputStream(propFile);
		dataProp.load(datafis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	
	
	


	public static ChromeOptions options;

	public WebDriver initializebrowserandopenapplicationURL(String browserName) {

		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}

		options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		options.addArguments("--start maximized");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		
		driver.get(prop.getProperty("url"));

		return driver;
	}
}
