package com.anvsystems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * <p>This class consists of Re-usable helper / utility methods</p>
 * @Author - Siddharth Mishra
 * @Version 1.0
 * @See External References
 */
public class CommonUtilities {
	
	public Properties configData;
	public WebDriver driver;
	
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
	
	/**
	 * <p>closes current browser instance</p>
	 */
	public void closeBrowser() {
		driver.quit();
	}
	
	public static void main(String[] args) {
		CommonUtilities comm = new CommonUtilities();
		comm.readConfig();
		comm.launchBrowser();
		comm.closeBrowser();
	}
}
