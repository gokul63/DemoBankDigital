package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pagemanager.PageObjectManager;

public class ScenarioContext {
	
	private PageObjectManager pageObjectManager;
	private WebDriver driver;
	private String userName;
	private String userPassword;
	
	public PageObjectManager getpageObjectManagerValue() {
		return pageObjectManager;
	}
	
	public void setpageObjectManagerValue(PageObjectManager pageObjectManager) {
		this.pageObjectManager = pageObjectManager;
	}	
	
	public WebDriver getWebDriverValue() {
		return driver;
	}
	
	public void setWebDriverValue(WebDriver driver) {
		this.driver = driver;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void setPageObjectManager(PageObjectManager pageObjectManager) {
		this.pageObjectManager = pageObjectManager;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}	
	
	
	
	


}
