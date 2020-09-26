package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebCommonSteps {
	
	WebDriver driver;
	PageObjectManager page_object_manager;
	
	private ScenarioContext context;
	
	public WebCommonSteps(ScenarioContext context) {
		
		this.context = context;
		
	}
	
	@Given("Launch the digital bank application {string} in browser")
	public void launch_the_digital_bank_application_in_browser(String url) throws Throwable {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		page_object_manager = new PageObjectManager(driver);
		Assert.assertTrue("Login Page Assert",
				page_object_manager.getLogin_page().getLstConfirmText().get(0).getText().equals("Sign Up Here"));
		System.out.println("Login page is verifed Successfully");
		context.setWebDriverValue(driver);

	}
	
	@When("User enters the {string} and {string} to log in to application")
	public void user_enters_the_and_to_log_in_to_application(String txtUserName, String txtPassword) {
		page_object_manager.getLogin_page().performLogin(txtUserName,txtPassword);
//		Assert.assertTrue("Home Page Assert",
//				page_object_manager.getLogin_page().getLstWelcomeText().get(1).getText().contains("Welcome"));
		System.out.println("Home page is verified Successfully");
		context.setpageObjectManagerValue(page_object_manager);
		
	}
	
	@Then("User logs out of the application")
	public void user_logs_out_of_the_application() {
		context.getpageObjectManagerValue().getLogout().getInitiateLogout().get(0).click();
		context.getpageObjectManagerValue().getLogout().getLogoutClick().get(0).click();
		Assert.assertTrue("Logout Assert:",
				page_object_manager.getLogout().getLogoutVP().get(0).getText().equalsIgnoreCase("success"));
		System.out.println("Logout successful");

	}



}
