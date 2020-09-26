package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLstTransfer() {
		return lstTransfer;
	}

	public WebElement getLstBetweenAccount() {
		return lstBetweenAccount;
	}

	public WebElement getLstConfirmText() {
		return lstConfirmText;
	}

	public WebElement getLstSavings() {
		return lstSavings;
	}

	public WebElement getLstViewSavings() {
		return lstViewSavings;
	}

	public WebElement getLstTextUser() {
		return lstTextUser;
	}

	public WebElement getLstUserBalance() {
		return lstUserBalance;
	}

	public WebElement getLstUserLogo() {
		return lstUserLogo;
	}

	public WebElement getLstLogout() {
		return lstLogout;
	}

	public WebElement getWelcomeText() {
		return WelcomeText;
	}




	@FindBy(linkText = "Transfer")
	private WebElement lstTransfer;

	@FindBy(linkText = "Between Accounts")
	private WebElement lstBetweenAccount;

	@FindBy(xpath = "//strong[@class='card-title text-white']")
	private WebElement lstConfirmText;

	@FindBy(linkText = "Savings")
	private WebElement lstSavings;

	@FindBy(linkText = "View Savings")
	private WebElement lstViewSavings;

	@FindBy(xpath = "//div[text()='gok']")
	private WebElement lstTextUser;

	@FindBy(xpath = "//div[contains(text(),'Balance')]")
	private WebElement lstUserBalance;

	@FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
	private WebElement lstUserLogo;

	@FindBy(linkText = "Logout")
	private WebElement lstLogout;
	
	@FindBy(xpath = "//li[contains(text(),'Welcome')]")
	private WebElement WelcomeText;
}
