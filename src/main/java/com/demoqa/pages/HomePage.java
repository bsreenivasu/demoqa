package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoqa.base.BasePage;

public class HomePage extends BasePage {
	WebDriver driver;
				
				By home = By.xpath("//a[text()='Home']");
				By learnEarnBanner = By.xpath("//strong[contains(text(),'Learn')]");
				By joinNow = By.xpath("//a[text()='JOIN NOW']");
				By login = By.xpath("//a[@class='theme-btn register-btn']");
				
				public HomePage(WebDriver driver){
					this.driver = driver;
				}
				
				
				public String getPageTitle() {
					return driver.getTitle();
				}
				
				public boolean checkHomelink() {
				 return	driver.findElement(home).isDisplayed();
				}
				
				public boolean checklearnEarnBanner() {
					return driver.findElement(learnEarnBanner).isDisplayed();
				}
				
				public boolean checkJoinNowButton() {
					return driver.findElement(joinNow).isDisplayed();
				}
				
	//			public LoginPage clickLoginBTN() {
				public LoginPage clickLoginBTN() {
					driver.findElement(login).click();
					return new LoginPage(driver);
				}
}
