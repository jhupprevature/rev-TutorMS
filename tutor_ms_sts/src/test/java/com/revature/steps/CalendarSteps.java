package com.revature.steps;

import org.openqa.selenium.WebDriver;

import com.revature.pages.HomePage;
import com.revature.runners.CalendarRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalendarSteps {

	public static HomePage homepage = CalendarRunner.homePage;
	public static WebDriver driver = CalendarRunner.driver;

	@Given("User is on the Calendar tab")
	public void user_is_on_the_calendar_tab() {
		driver.get("http://localhost:4200/calendar");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks on a date")
	public void user_clicks_on_a_date() {
		homepage.chosenDate.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks searchbar to enter title")
	public void user_clicks_searchbar_to_enter_title() {
		homepage.titleSearch.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User enters {string} for title")
	public void user_enters_for_title(String string) {
		homepage.titleSearch.sendKeys("Project 2");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks searchbar to enter a color")
	public void user_clicks_searchbar_to_enter_a_color() {
		homepage.colorSearch.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User enters {string} for color")
	public void user_enters_for_color(String string) {
		homepage.colorSearch.sendKeys("red");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks submit")
	public void user_clicks_submit() {
		homepage.submitBtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks the X button")
	public void user_clicks_the_x_button() {
		homepage.xBtn.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should see event on Calendar")
	public void user_should_see_event_on_calendar() {
		driver.get("http://localhost:4200/calendar");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks on checkbox for deletion")
	public void user_clicks_on_checkbox_for_deletion() {
		homepage.deleteCheckbox.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks on an event")
	public void user_clicks_on_an_event() {
		homepage.chosenEvent.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should not see event on Calendar")
	public void user_should_not_see_event_on_calendar() {
		driver.get("http://localhost:4200/calendar");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
