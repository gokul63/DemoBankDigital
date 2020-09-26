package com.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPage {
	
	
	WebDriver driver;
	public FundTransferPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}


	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLstSender() {
		return lstSender;
	}

	public WebElement getLstReceiver() {
		return lstReceiver;
	}

	public WebElement getLstAmount() {
		return lstAmount;
	}

	public WebElement getLstSubmitButton() {
		return lstSubmitButton;
	}


	@FindBy(id="fromAccount")
	private WebElement lstSender;
	
	@FindBy(id="toAccount")
	private WebElement lstReceiver;
	
	@FindBy(id="amount")
	private WebElement lstAmount;
	
	@FindBy(xpath ="//button[text()=' Submit']")
	private WebElement lstSubmitButton;
}
