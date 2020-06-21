package com.demoqa.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoqa.base.BasePage;

public class LandingPage extends BasePage {
	
		WebDriver driver;
			
		public LandingPage(WebDriver driver){
			this.driver = driver;
		}
		
		By currentUser = By.xpath("//span[@class='navbar-current-user' and text()='Sreenivas B']");
		By mycourses = By.xpath("//a[contains(text(),'My Courses')]");
		By searchCourses = 	By.id("search-courses");
		
		
		public String landingPageTitle() {
			return driver.getTitle();
		}
		
		public String currentUser() {
			return driver.findElement(currentUser).getText();
		}
		
		public boolean verifyMyCourses() {
			return driver.findElement(mycourses).isDisplayed();
		}
		
		public boolean searchCousesBox() {
			return driver.findElement(searchCourses).isEnabled();
		}

}
