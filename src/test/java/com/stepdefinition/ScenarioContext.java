package com.stepdefinition;

import org.openqa.selenium.WebDriver;

import com.pagemanager.PageObjectManager;

public class ScenarioContext {
	
	private PageObjectManager pageObjectManager;
	private WebDriver driver;
	
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
	
	


}
