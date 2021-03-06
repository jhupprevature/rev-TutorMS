package com.revature.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.HomePage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/revature/features/Calendar.feature", glue = { "com.revature.steps",
		"CalendarSteps" })
public class CalendarRunner {

	public static WebDriver driver;
	public static HomePage homePage;

	@BeforeClass
	public static void setUp() {

		// YOU NEED TO PUT YOUR OWN CHROME OR FIREFOX DRIVER FOR PATH
		String path = "C:/Users/jehup/Desktop/Revature Desktop/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		homePage = new HomePage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
