package com.pages;



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
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getInitiateLogout() {
		return initiateLogout;
	}

	public WebElement getLogoutClick() {
		return logoutClick;
	}

	public WebElement getLogoutVP() {
		return logoutVP;
	}



	@FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
	private WebElement initiateLogout;
	
	@FindBy(xpath = "//*[@id=\'header\']/div/div[2]/div[1]/div/a[3]")
	private WebElement logoutClick;
	
	@FindBy(xpath = "//span[@class='badge badge-pill badge-success']")
	private WebElement logoutVP;
}
