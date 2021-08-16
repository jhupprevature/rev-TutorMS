package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
public WebDriver driver;
	
	@FindBy(id = "mt-2")
	public WebElement registrationTitle;
	
//	@FindBy(id = "invalidLogin")
//	public WebElement invalidLoginMessage;
	
	@FindBy(id = "inputFirstName")
	public WebElement inputFirstName;
	
	@FindBy(id = "inputLastName")
	public WebElement inputLastName;
	
	@FindBy(id = "inputEmail")
	public WebElement inputEmail;
	
	@FindBy(id = "inputTelephone")
	public WebElement inputTelephone;
	
	@FindBy(id = "inputPassword")
	public WebElement inputPassword;
	
	@FindBy(id="inputGroupSelect01")
	public WebElement accountTypeDropdown;
	
	@FindBy(className = "btn-primary")
	public WebElement submitBtn;
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

}
