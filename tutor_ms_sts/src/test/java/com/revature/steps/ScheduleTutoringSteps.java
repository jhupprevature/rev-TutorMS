package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.revature.pages.HomePage;
import com.revature.runners.ScheduleTutoringRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScheduleTutoringSteps {

	public static HomePage homepage = ScheduleTutoringRunner.homePage;
	public static WebDriver driver = ScheduleTutoringRunner.driver;

	@Given("User is on Scheduling page")
	public void user_is_on_scheduling_page() {
		driver.get("http://localhost:4200/scheduling");

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Search for Tutors")
	public void user_clicks_search_for_tutors() {
		homepage.searchBar.click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("Student inputs {string} criteria")
	public void student_inputs_criteria(String string) {
		homepage.searchBar.sendKeys("Law");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("A tutor matching criteria is displayed.")
	public void a_tutor_matching_criteria_is_displayed() {
		assertEquals("Law", homepage.shownTutor.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks on a tutor")
	public void user_clicks_on_a_tutor() {
		homepage.shownTutor.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tutors schedule is displayed")
	public void tutors_schedule_is_displayed() {
		assertEquals("Schedule:", homepage.shownSchedule.getText());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@When("User clicks Schedule Tutoring Session")
	public void user_clicks_schedule_tutoring_session() {
		homepage.scheduleSessionBtn.click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("Tutoring session is created")
	public void tutoring_session_is_created() {
		assertEquals("Scheduled Successfully!", homepage.successText.getText());

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
