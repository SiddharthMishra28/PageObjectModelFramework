package com.anvsystems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks {
	
	public static Properties configData;
	public WebDriver driver;
	
	@BeforeSuite
	public void beforeSuite() {
		readConfig();
	}
	
	@BeforeMethod
	public void beforeMethod() {
		launchBrowser();
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuite() {
		
	}
	
	/**
	 * <p>This method reads the config and parses the same into key value pairs</p>
	 */
	public void readConfig() {
		try {
			FileInputStream fis = new FileInputStream(new File("./src/test/resources/config.properties"));
			configData = new Properties();
			configData.load(fis);
			System.out.println(configData.getProperty("browser.name"));
		} catch (IOException e) {
			System.out.println("Unable to Read config "+e.getMessage());
		}
	}
	
	/**
	 * <p>Launches a Fresh Instance of Browser depending on configuration</p>
	 */
	public void launchBrowser() {
		if(configData.getProperty("browser.name").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", configData.getProperty("browser.executable"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			// IMPLEMENT FOR OTHER BROWSERS!
		}
	}
}
