package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[1]")
	public WebElement home;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[2]")
	public WebElement dashboard;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[3]")
	public WebElement calendar;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[4]")
	public WebElement scheduling;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[5]")
	public WebElement summary;

	@FindBy(xpath = "/html/body/app-root/mat-drawer-container/mat-drawer/div/app-sidenav/mat-nav-list/a[6]")
	public WebElement login;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickHome() {
		home.click();
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

	public void clickSummary() {
		summary.click();
	}

	public void clickLogin() {
		login.click();
	}
}
