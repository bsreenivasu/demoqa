package com.demoqa.base;

	
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class BasePage {
			
			 public WebDriver driver;
			 public Properties prop;
			 
			 /**
			  * This method is used to initialise driver
			  * 
			  * 
			  */
			 public WebDriver initDriver(Properties prop) {
				String browser = prop.getProperty("browser");
				 System.out.println("Web Browser is :: " +browser);
				
				 if(browser.equalsIgnoreCase("Chrome")) {
					 WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver();
				 	}
				 else if(browser.equalsIgnoreCase("FireFox")) {
					 WebDriverManager.chromedriver().setup();
					 driver = new ChromeDriver();
				 	}
				 else {
					 System.out.println("Invalid Browser name :: " + browser);
				 }
				 
				 driver.get(prop.getProperty("url"));
				 driver.manage().window().maximize();
				 driver.manage().deleteAllCookies();
				 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				
				 return driver;
			 }
			 
			 /**
			  * This is used to initilise properties.
			  * @return
			  */
			 public Properties initProperties() {
				 prop = new Properties();
				 try {
					FileInputStream fis = new FileInputStream("C:\\Users\\sreen\\eclipse-workspace\\demoqa\\src\\main\\java\\com\\demoqa\\configuration\\config.properties");
					prop.load(fis);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 return prop;
			 }
			 
			 
	
}
