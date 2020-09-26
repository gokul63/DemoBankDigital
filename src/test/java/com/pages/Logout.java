package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
	
	WebDriver driver;

	public Logout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
	private List<WebElement> initiateLogout;
	
	public List<WebElement> getInitiateLogout() {
		return initiateLogout;
	}

	public List<WebElement> getLogoutClick() {
		return logoutClick;
	}

	public List<WebElement> getLogoutVP() {
		return logoutVP;
	}
	
	@FindBy(xpath = "//*[@id=\'header\']/div/div[2]/div[1]/div/a[3]")
	private List<WebElement> logoutClick;
	
	@FindBy(xpath = "//span[@class='badge badge-pill badge-success']")
	private List<WebElement> logoutVP;
}
