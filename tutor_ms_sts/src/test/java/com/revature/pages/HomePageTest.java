package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {

	public static void main(String[] args) {

		// YOU NEED TO PUT YOUR OWN CHROME OR FIREFOX DRIVER LOCATION FOR DRIVERPATH
		String driverPath = "C:/Users/Presentfob/Documents/chromedriver_win32/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		HomePage homePage = new HomePage(driver);

		String url = "http://localhost:4200/home";

		driver.get(url);
		homePage.clickHome();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.get(url);
		homePage.clickDashboard();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.get(url);
		homePage.clickCalendar();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.get(url);
		homePage.clickScheduling();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.get(url);
		homePage.clickSummary();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.get(url);
		homePage.clickLogin();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
	}
}
