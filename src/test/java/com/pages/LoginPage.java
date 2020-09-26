package com.pages;




import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private  WebElement TextUserName;
	
	@FindBy(id = "password")
	private  WebElement TextPassword;
	
	@FindBy(id = "submit")
	private  WebElement LoginButton;
	
	@FindBy(linkText="Sign Up Here")
	private WebElement ConfirmText;
	

	
	public void performLogin(String userName, String userPassword) {
		System.out.println(userName);
		System.out.println(userPassword);
	TextUserName.sendKeys(userName);
	TextPassword.sendKeys(userPassword);
	LoginButton.click();
	}
	
	public void loginPageAssertVerify(String text)
	{
		Assert.assertTrue("Login Page Assert",
				ConfirmText.getText().equals(text));
	}
	
	
	}
	

