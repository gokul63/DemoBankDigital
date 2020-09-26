package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TransactionPage {
	
	WebDriver driver;

	public TransactionPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(tagName = "th")
	private List<WebElement> textHeading;

	@FindBy(tagName = "tr")
	private List<WebElement> textRow;

	@FindBy(xpath = "//div[text()='gok']")
	private WebElement lstTextUser;

	@FindBy(xpath = "//div[contains(text(),'Balance')]")
	private WebElement lstUserBalance;

	@FindBy(xpath = "//span[@class='switch-handle']")
	private WebElement lstButton;

	@FindBy(linkText = "Next")
	private WebElement lstScroll;

	public WebDriver getDriver() {
		return driver;
	}

	public List<WebElement> getTextHeading() {
		return textHeading;
	}

	public List<WebElement> getTextRow() {
		return textRow;
	}

	public WebElement getLstTextUser() {
		return lstTextUser;
	}

	public WebElement getLstUserBalance() {
		return lstUserBalance;
	}

	public WebElement getLstButton() {
		return lstButton;
	}

	public WebElement getLstScroll() {
		return lstScroll;
	}

}
