package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demoqa.base.BasePage;

public class LoginPage extends BasePage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	By username = By.id("user_email");
	By password = By.id("user_password");
	By commit  = By.name("commit");
	By image = By.xpath("//img[@alt='Rahul Shetty Academy']");
	By login = By.xpath("//a[@class='theme-btn register-btn']");
	
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean checkImage() {
		return driver.findElement(image).isDisplayed();
	}
	
	public LandingPage clickLoginBTN() {
		driver.findElement(login).click();
		return new LandingPage(driver);
	}
	
	public LandingPage doLogin(String usr, String passwd) {
		driver.findElement(username).sendKeys(usr);
		driver.findElement(password).sendKeys(passwd);
		driver.findElement(commit).click();
		
		return new LandingPage(driver);
		
	}

}
