package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.revature.pages.DashboardPage;
import com.revature.pages.LoginPage;
import com.revature.runners.DashboardRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {
	
	public static WebDriver driver = DashboardRunner.driver;
	public static LoginPage loginPage = DashboardRunner.loginPage;
	public static DashboardPage dashboardPage = DashboardRunner.dashboardPage;

	
	@Given("User is logged in")
	public void user_id_logged_in() {
		String url = "http://localhost:4200/";
		driver.get(url);
		loginPage.usernameInput.sendKeys("clinde");
		loginPage.passwordInput.sendKeys("cJo2yF1hFB");
		loginPage.submitBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@When("User inputs a new username")
	public void user_inputs_a_new_username() {
	    // Write code here that turns the phrase above into concrete actions
		for (int i=0; i < 100; i++) {
			dashboardPage.username.sendKeys(Keys.BACK_SPACE);
		}
		dashboardPage.username.sendKeys("new_username");
		
	}

	@When("User clicks the Update button")
	public void user_clicks_the_update_button() {
	    // Write code here that turns the phrase above into concrete actions
	    dashboardPage.updateBtn.click();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("User's username is updated on header")
	public void user_s_username_is_updated_on_header() {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals("Account Updated", dashboardPage.accountUpdated.getText());
		
	}

}
