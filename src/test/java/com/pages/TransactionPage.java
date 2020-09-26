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

	public List<WebElement> getTextHeading() {
		return textHeading;
	}

	public List<WebElement> getTextRow() {
		return textRow;
	}

	public List<WebElement> getLstTextUser() {
		return lstTextUser;
	}

	public List<WebElement> getLstUserBalance() {
		return lstUserBalance;
	}

	public List<WebElement> getLstButton() {
		return lstButton;
	}

	public List<WebElement> getLstScroll() {
		return lstScroll;
	}

	@FindBy(tagName = "th")
	private List<WebElement> textHeading;

	@FindBy(tagName = "tr")
	private List<WebElement> textRow;

	@FindBy(xpath = "//div[text()='gok']")
	private List<WebElement> lstTextUser;

	@FindBy(xpath = "//div[contains(text(),'Balance')]")
	private List<WebElement> lstUserBalance;

	@FindBy(xpath = "//span[@class='switch-handle']")
	private List<WebElement> lstButton;

	@FindBy(linkText = "Next")
	private List<WebElement> lstScroll;

}
