package com.demoqa.testpages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.demoqa.base.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.pages.LandingPage;
import com.demoqa.pages.LoginPage;

public class LandingPageTest {
	WebDriver driver;
	Properties prop;
	BasePage basepage;
	HomePage homepage;
	LoginPage loginpage;
	LandingPage landingpage;
	
	
	@BeforeTest
	public void setup() {
			basepage = new BasePage();
			
			prop = basepage.initProperties();
			driver = basepage.initDriver(prop);
			loginpage =  new LoginPage(driver);
			homepage = new HomePage(driver);
	//		loginpage=homepage.clickLoginBTN();
			landingpage=loginpage.clickLoginBTN();
			landingpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
			@Test
			public void LandingPageTitle() {
				String pageTitle =landingpage.landingPageTitle();
				System.out.println(pageTitle);
				Assert.assertEquals(pageTitle, "LandingPage");
			}
			
			
			@Test
			public void verifyCurrentUser() {
				String currentUserName = landingpage.currentUser();
				System.out.println(currentUserName);
				Assert.assertEquals(currentUserName, "Sreenivas B");
			}
			
			@Test
			public void verifySearchBox() {
				Assert.assertTrue(landingpage.searchCousesBox());
				}
			
			@Test
			public void checkMyCourses() {
				landingpage.verifyMyCourses();
			}
			
	@AfterTest
		public void tearDown() {
			driver.quit();
		}
	}


