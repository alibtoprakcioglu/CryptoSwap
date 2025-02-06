package com.bilira.testbase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bilira.utils.ConfigsReader;
import com.bilira.utils.Constants;

public class BaseClass {

	public static WebDriver driver;

	public static void setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String browser = ConfigsReader.getProperty("browser");

		// System.out.println(browser);
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		String url = ConfigsReader.getProperty("url");
		driver.get(url);
		
		
		PageInitializer.initialize();
	}


	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
