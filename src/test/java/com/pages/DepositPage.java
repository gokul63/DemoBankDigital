package com.pages;



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
	
	

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getTransfersPage() {
		return transfersPage;
	}

	public WebElement getDepositPage() {
		return depositPage;
	}

	public WebElement getDepositAccount() {
		return depositAccount;
	}

	public WebElement getDepositAmount() {
		return depositAmount;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public WebElement getTransfersVP() {
		return transfersVP;
	}

	public WebElement getFinalBalance() {
		return finalBalance;
	}



	@FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a")
	private WebElement transfersPage;

	@FindBy(linkText = "Deposit")
	private WebElement depositPage;

	@FindBy(id = "id")
	private WebElement depositAccount;

	@FindBy(id = "amount")
	private WebElement depositAmount;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
	private WebElement submitButton;

	@FindBy(xpath = "//*[@id='right-panel']/div[2]/div/div/div/div/div/strong")
	private WebElement transfersVP;
	
	@FindBy(xpath = "//table[@id='transactionTable']/tbody/tr[1]/td[5]")
	private WebElement finalBalance;

	


}
