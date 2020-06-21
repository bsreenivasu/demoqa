package com.demoqa.testpages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.demoqa.base.BasePage;
import com.demoqa.pages.HomePage;
import com.demoqa.utils.Constants;

public class HomePageTest {
	BasePage basepage;
	HomePage homepage;
	Properties prop;
	WebDriver driver;

	@BeforeTest
	public void setup() {
		basepage = new BasePage();
		prop = basepage.initProperties();
		driver = basepage.initDriver(prop);
		homepage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifyHomePageTitle() {

		String homepageTitle = homepage.getPageTitle();
		System.out.println("homepage Title is ::" + homepageTitle);
		Assert.assertEquals(homepageTitle, Constants.HOME_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void checkJoinNowBTN() {
		Assert.assertTrue(homepage.checkJoinNowButton());

	}

	@Test(priority = 3)
	public void clickLoginBtn() {
		homepage.clickLoginBTN();
		}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}
