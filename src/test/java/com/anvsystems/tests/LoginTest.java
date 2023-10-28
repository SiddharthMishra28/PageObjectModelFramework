package com.anvsystems.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.anvsystems.pages.LoginPage;
import com.anvsystems.utils.CommonUtilities;
import com.anvsystems.utils.Hooks;

public class LoginTest extends Hooks{
	
	@Test(dataProvider = "login_data_provider")
	public void loginTestWithValidCredentials(String url, String username, String password) throws InterruptedException {
		LoginPage page = new LoginPage(driver);
		page.loginIntoApp(url,username,password);
		Thread.sleep(2000);
	}
	
	@DataProvider(name = "login_data_provider")
	public Object[][] getTestData() {
		return CommonUtilities.readExcel();
	}
}
