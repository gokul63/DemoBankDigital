package com.pages;


import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getLstTextUserName() {
		return lstTextUserName;
	}

	public WebElement getLstTextPassword() {
		return lstTextPassword;
	}

	public WebElement getLstLoginButton() {
		return lstLoginButton;
	}

	public List<WebElement> getLstConfirmText() {
		return lstConfirmText;
	}
	
	

	public List<WebElement> getLstWelcomeText() {
		return lstWelcomeText;
	}



	@FindBy(id = "username")
	private  WebElement lstTextUserName;
	
	@FindBy(id = "password")
	private  WebElement lstTextPassword;
	
	@FindBy(id = "submit")
	private  WebElement lstLoginButton;
	
	@FindBy(linkText="Sign Up Here")
	private List<WebElement> lstConfirmText;
	
	@FindBy(xpath ="//li[@class='active']")
	private  List<WebElement> lstWelcomeText;
	
	public void performLogin(String userName, String password) {
	lstTextUserName.sendKeys(userName);
	lstTextPassword.sendKeys(password);
	lstLoginButton.click();
	}
	}
	
	

