package com.demoqa.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class submitform {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.demoqa.com/automation-practice-form");
		driver.findElement(By.id("firstName")).sendKeys("Sreenivas");
		driver.findElement(By.id("lastName")).sendKeys("Boggarapu");
		driver.findElement(By.xpath("//label[@class='custom-control-label']")).click();
		
	//	Select select = new Select(driver.findElement(By.id("react-datepicker__month-select")));
		
		

	}
}
