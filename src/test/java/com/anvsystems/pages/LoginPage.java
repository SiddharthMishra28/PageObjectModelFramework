package com.anvsystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.anvsystems.utils.CommonUtilities;

public class LoginPage extends CommonUtilities{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public By userIdTextBox = By.name("uid");
	public By passwordTextBox = By.name("password");
	public By loginButton = By.name("btnLogin");
	
	public void loginIntoApp(String url, String userId, String password) {
		navigate(url);
		type(userIdTextBox, userId);
		type(passwordTextBox, password);
		clickElement(loginButton);
	}
}
