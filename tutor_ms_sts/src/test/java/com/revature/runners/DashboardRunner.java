package com.revature.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.DashboardPage;
import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/revature/features/Dashboard.feature", glue = { "com.revature.steps", "DashboardSteps" })
public class DashboardRunner {
	public static WebDriver driver;
	public static HomePage homePage;
	public static LoginPage loginPage;
	public static DashboardPage dashboardPage;


	@BeforeClass
	public static void setUp() {

		// YOU NEED TO PUT YOUR OWN CHROME OR FIREFOX DRIVER FOR PATH
//		String path = "C:/Users/Presentfob/Documents/chromedriver_win32/chromedriver.exe";
//		System.setProperty("webdriver.chrome.driver", path);

		driver = new ChromeDriver();
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
}
