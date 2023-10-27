package com.anvsystems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * <p>This class consists of Re-usable helper / utility methods</p>
 * @Author - Siddharth Mishra
 * @Version 1.0
 * @See External References
 */
public class CommonUtilities {
	
	public WebDriver driver;
	
	public CommonUtilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public void navigate(String url) {
		driver.get(url);
	}
	
	/**
	 * <p>Clicks on provided WebElement</p>
	 */
	public void clickElement(By locatorType) {
		driver.findElement(locatorType).click();
	}
	
	/**
	 * <p>Sends Keystrokes to provided WebElement</p>
	 */
	public void type(By locatorType, String value) {
		driver.findElement(locatorType).sendKeys(value);
	}
	
}
