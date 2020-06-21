package com.demoqa.testpages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoqa.base.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LoginPage;
import com.demoqa.utils.Constants;

public class LoginPageTest {
	
		WebDriver driver;
		Properties prop;
		BasePage basepage;
		HomePage homepage;
		LoginPage loginpage;
		
		
		@BeforeTest
		public void setup() {
			basepage = new BasePage();
			prop = basepage.initProperties();
			driver = basepage.initDriver(prop);
			homepage = new HomePage(driver);
	//		loginpage = new LoginPage(driver);
			loginpage=homepage.clickLoginBTN();
		}
		
		@Test(priority=1)
		public void checkImage() {
			Assert.assertTrue(loginpage.checkImage());
		}
		
		@Test(priority=2)
		public void getLoginPageTitle() {
			String title = loginpage.getLoginPageTitle();
			System.out.println(title);
			Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		}
		
		@Test(priority=3)
		public void verifyLogin() {
			loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		}

		
		@AfterTest
		public void tearDown(){
			driver.quit();
		}
}
