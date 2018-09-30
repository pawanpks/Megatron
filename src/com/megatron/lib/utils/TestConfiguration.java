package com.megatron.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import okio.Timeout;

public class TestConfiguration {
	public static WebDriver getDriverInstance() {
		String browser = DataHandlers.getDataFromPropertiesFile("./Config-data/config.properties", "browser");
		System.out.println("Browser : "+browser);
		String url = DataHandlers.getDataFromPropertiesFile("./Config-data/config.properties", "prod_url");
		WebDriver driver = null;
		
		 if(browser.equalsIgnoreCase("firefox")) {
		 System.setProperty("webdriver.gecko.driver",
		 "./Browser-server/geckoDriver.exe");
		 driver= new FirefoxDriver(); 
		 }
		 else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Browser-server/chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.err.println("......Invalid Browser Option" + "Please check config.properties file");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
