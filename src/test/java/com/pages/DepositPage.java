package com.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
	
	WebDriver driver;

	public DepositPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a")
	private List<WebElement> transfersPage;

	@FindBy(linkText = "Deposit")
	private List<WebElement> depositPage;

	@FindBy(id = "id")
	private List<WebElement> depositAccount;

	@FindBy(id = "amount")
	private List<WebElement> depositAmount;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	private List<WebElement> submitButton;

	@FindBy(xpath = "//*[@id='right-panel']/div[2]/div/div/div/div/div/strong")
	private List<WebElement> transfersVP;
	
	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[1]/td[5]")
	private List<WebElement> finalBalance;

	public List<WebElement> getFinalBalance() {
		return finalBalance;
	}

	public List<WebElement> getTransfersPage() {
		return transfersPage;
	}

	public List<WebElement> getDepositPage() {
		return depositPage;
	}

	public List<WebElement> getDepositAccount() {
		return depositAccount;
	}

	public List<WebElement> getDepositAmount() {
		return depositAmount;
	}

	public List<WebElement> getSubmitButton() {
		return submitButton;
	}

	public List<WebElement> getTransfersVP() {
		return transfersVP;
	}


}
