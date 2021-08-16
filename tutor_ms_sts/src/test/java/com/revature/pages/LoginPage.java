package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(id = "username")
	public WebElement usernameInput;
	
	@FindBy(id = "password")
	public WebElement passwordInput;
	
	@FindBy(className = "btn-primary")
	public WebElement submitBtn;
	
	@FindBy(id = "invalidLogin")
	public WebElement invalidLoginMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

}
