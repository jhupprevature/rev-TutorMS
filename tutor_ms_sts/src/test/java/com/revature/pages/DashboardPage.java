package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
public WebDriver driver;
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(id = "firstName")
	public WebElement firstName;
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "updateBtn")
	public WebElement updateBtn;
	
	@FindBy(id = "menuBtn")
	public WebElement menuBtn;
	
	@FindBy(id = "accountUpdated")
	public WebElement accountUpdated;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
