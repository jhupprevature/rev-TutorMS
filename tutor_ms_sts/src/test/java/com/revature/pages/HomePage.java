package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

// -----Beginning of Dashboard/Profile Page elements----

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[2]")
	public WebElement dashboard;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-dashboard/div/h1")
	public WebElement dashboardTitle;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-header/mat-toolbar/mat-toolbar-row/div[1]/ul/li/button/span[1]")
	public WebElement topRightUser;

	@FindBy(xpath = "//*[@id=\"mat-menu-panel-0\"]/div/div/button[1]")
	public WebElement profile;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-profile/div/div[1]")
	public WebElement profileTitle;

// ------End of Dashboard/Profile Page elements----

// -----Beginning of Calendar Page elements----

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[3]")
	public WebElement calendar;

	@FindBy(xpath = "//*[@id=\"calender\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[3]/td[2]/div")
	public WebElement chosenDate;

	@FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[2]/div/div/div/div[1]/input[1]")
	public WebElement titleSearch;

	@FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[2]/div/div/div/div[1]/input[2]")
	public WebElement colorSearch;

	@FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[2]/div/button")
	public WebElement submitBtn;

	@FindBy(xpath = "//*[@id=\"myModal\"]/div/div/div[1]/button")
	public WebElement xBtn;

	@FindBy(xpath = "//*[@id=\"isCheckBox\"]")
	public WebElement deleteCheckbox;

	@FindBy(xpath = "//*[@id=\"calender\"]/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[2]/td[1]/div/div[2]/div[1]/a/div[1]/div/div/div")
	public WebElement chosenEvent;

// ------End of Calendar Page elements----

// ------Beginning of Scheduling Page elements-------

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[4]")
	public WebElement scheduling;

	@FindBy(id = "inputCriteria")
	public WebElement searchBar;

	@FindBy(xpath = "//*[@id=\"datatableexample\"]/tbody/tr/td[1]")
	public WebElement shownTutor;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-scheduling/div/div[2]/div[1]/div/span[3]/b")
	public WebElement shownSchedule;

	@FindBy(xpath = "//*[@id=\"scheduleBtn\"]")
	public WebElement scheduleSessionBtn;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-scheduling/div/div[2]/div[1]/span/b")
	public WebElement successText;

//---End of Scheduling Page elements----

// ------Beginning of Login Page elements-------

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[4]")
	public WebElement login;
	
	@FindBy(className = "mat-h1")
	public WebElement dashboardTitle;
	
	@FindBy(id = "registerBtn")
	public WebElement registerBtn;

	@FindBy(id = "logout")
	public WebElement logout;
	
	@FindBy(id = "menuBtn")
	public WebElement menuBtn;
	
	@FindBy(id = "accountType")
	public WebElement getAccountType;
	

	@FindBy(xpath = "//*[@id=\"username\"]")
	public WebElement searchUsername;

	@FindBy(xpath = "//*[@id=\"password\"]")
	public WebElement searchPassword;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer-content/app-login/div/div[2]/div/div/div/div[3]/button")
	public WebElement loginBtn;

//---End of Login Page elements----

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickDashboard() {
		dashboard.click();
	}

	public void clickCalendar() {
		calendar.click();
	}

	public void clickScheduling() {
		scheduling.click();
	}

	public void clickLogin() {
		login.click();
	}
}
