package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.pages.HomePage;
import com.revature.runners.ProfileRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProfileSteps {

	public static HomePage homepage = ProfileRunner.homePage;
	public static WebDriver driver = ProfileRunner.driver;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		driver.get("http://localhost:4200/login");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks search for username")
	public void user_clicks_search_for_username() {
		homepage.searchUsername.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User enters {string} for username")
	public void user_enters_for_username(String string) {
		homepage.searchUsername.sendKeys("amcorkill4");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks search for password")
	public void user_clicks_search_for_password() {
		homepage.searchPassword.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User enters {string} for password")
	public void user_enters_for_password(String string) {
		homepage.searchPassword.sendKeys("Y4nj627QP");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() {
		homepage.loginBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should be on Dashboard page")
	public void user_should_be_on_dashboard_page() {
		assertEquals("Dashboard", homepage.dashboardTitle.getText());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks username in top right corner")
	public void user_clicks_username_in_top_right_corner() {
		homepage.topRightUser.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Profile")
	public void user_clicks_profile() {
		homepage.profile.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should be on Profile page")
	public void user_should_be_on_profile_page() {
		assertEquals("Tutoring Summary", homepage.profileTitle.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
