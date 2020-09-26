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

	public List<WebElement> getLstTransfer() {
		return lstTransfer;
	}

	public List<WebElement> getLstBetweenAccount() {
		return lstBetweenAccount;
	}

	public List<WebElement> getLstConfirmText() {
		return lstConfirmText;
	}

	public List<WebElement> getLstSavings() {
		return lstSavings;
	}

	public List<WebElement> getLstViewSavings() {
		return lstViewSavings;
	}

	public List<WebElement> getLstTextUser() {
		return lstTextUser;
	}

	public List<WebElement> getLstUserBalance() {
		return lstUserBalance;
	}

	public List<WebElement> getLstUserLogo() {
		return lstUserLogo;
	}

	public List<WebElement> getLstLogout() {
		return lstLogout;
	}

	@FindBy(linkText = "Transfer")
	private List<WebElement> lstTransfer;

	@FindBy(linkText = "Between Accounts")
	private List<WebElement> lstBetweenAccount;

	@FindBy(xpath = "//strong[@class='card-title text-white']")
	private List<WebElement> lstConfirmText;

	@FindBy(linkText = "Savings")
	private List<WebElement> lstSavings;

	@FindBy(linkText = "View Savings")
	private List<WebElement> lstViewSavings;

	@FindBy(xpath = "//div[text()='gok']")
	private List<WebElement> lstTextUser;

	@FindBy(xpath = "//div[contains(text(),'Balance')]")
	private List<WebElement> lstUserBalance;

	@FindBy(xpath = "//img[@class='user-avatar rounded-circle']")
	private List<WebElement> lstUserLogo;

	@FindBy(linkText = "Logout")
	private List<WebElement> lstLogout;
}
