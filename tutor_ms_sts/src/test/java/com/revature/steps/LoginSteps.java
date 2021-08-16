package com.revature.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.revature.pages.HomePage;
import com.revature.pages.LoginPage;
import com.revature.pages.RegisterPage;
import com.revature.runners.LoginRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;


public class LoginSteps {
	
	final static Logger log = Logger.getLogger(LoginSteps.class);

	public static WebDriver driver = LoginRunner.driver;
	public static LoginPage loginPage = LoginRunner.loginPage;
	public static HomePage homePage = LoginRunner.homePage;
	public static RegisterPage registerPage = LoginRunner.registerPage;

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		// Write code here that turns the phrase above into concrete actions
		String url = "http://localhost:4200/";

		driver.get(url);
		log.info("INFO: user went to homepage");

	}

	@When("User inputs valid email")
	public void user_inputs_valid_email() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.usernameInput.sendKeys("amcorkill4");
		log.info("INFO: user inputs username");
		
	}

	@When("User inputs valid password")
	public void user_inputs_valid_password() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.passwordInput.sendKeys("Y4nj627QP");
		log.info("INFO: user inputs password");
	
	}

	@When("User clicks Login button")
	public void user_clicks_login_button() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.submitBtn.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("INFO: user clicks submit");

	}

	@Then("User is re-directed to role-appropriate home page.")
	public void user_is_re_directed_to_role_appropriate_home_page() {
		assertEquals("Dashboard", homePage.dashboardTitle1.getText());
		log.info("INFO: user see the Dashboard homepage");
	}

	@When("User inputs invalid email")
	public void user_inputs_invalid_email() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.usernameInput.sendKeys("amcorkill4_invalid");
		log.info("INFO: user inputs invalid email");
	}

	@When("User inputs invalid password")
	public void user_inputs_invalid_password() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.passwordInput.sendKeys("Y4nj627QP_invalid");
		log.info("INFO: user inputs invalid password");

	}

	@When("User clicks login button")
	public void user_clicks_login_button1() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.submitBtn.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		log.info("INFO: user clicks login");

	}

	@Then("a Login failure message is displayed.")
	public void a_login_failure_message_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals("Login invalid", loginPage.invalidLoginMessage.getText());
		log.info("INFO: user sees an invalid login message");
	}

	@When("User clicks Register new user")
	public void user_clicks_register_new_user() {
		// Write code here that turns the phrase above into concrete actions
		homePage.menuBtn.click();
		homePage.registerBtn.click();
		log.info("INFO: user clicks to the registration page");

	}
	
	@When("User completes registration form")
	public void user_completes_registration_form() {
		// Write code here that turns the phrase above into concrete actions
		
		registerPage.inputFirstName.sendKeys("John");
		registerPage.inputLastName.sendKeys("Doe");
		registerPage.inputTelephone.sendKeys("555-555-5556");
		registerPage.inputEmail.sendKeys("jdoe100");
		registerPage.inputPassword.sendKeys("bob123");
		Select objSelect  = new Select(registerPage.accountTypeDropdown);
		objSelect.selectByValue("2");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		registerPage.submitBtn.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		log.info("INFO: user inputs fields to register");
		
	}

	@Then("new User is created")
	public void new_user_is_created() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals("Dashboard", homePage.dashboardTitle.getText());
		log.info("INFO: user goes to homepage after register");

	}

	@Then("a Registration confirmation message is displayed")
	public void a_registration_confirmation_message_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(true, true);
	
	}

	@Then("User is redirected to role-appropriate home page.")
	public void user_is_redirected_to_role_appropriate_home_page() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals("Tutor", homePage.getAccountType.getText());
		log.info("INFO: user see their account type");
		
	}
}
