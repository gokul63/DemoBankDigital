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
		page_object_manager.getLogin_page().loginPageAssertVerify("Sign Up Here");
		System.out.println("Login page is verifed Successfully");
		context.setWebDriverValue(driver);

	}
	
	@When("User enters the userName and password to log in to application")
	public void user_enters_the_userName_and_password_to_log_in_to_application() {
		page_object_manager.getLogin_page().performLogin(context.getUserName(),context.getUserPassword());
		Assert.assertTrue("Home Page Assert",
				page_object_manager.getHome_page().getWelcomeText().getText().contains("Welcome"));
		System.out.println("Home page is verified Successfully");
		context.setpageObjectManagerValue(page_object_manager);
		
	}
	
	@Then("User log out the application")
	public void user_log_out_the_application() {
		context.getpageObjectManagerValue().getLogout().getInitiateLogout().get(0).click();
		context.getpageObjectManagerValue().getLogout().getLogoutClick().get(0).click();
		Assert.assertTrue("Logout Assert:",
				page_object_manager.getLogout().getLogoutVP().get(0).getText().equalsIgnoreCase("success"));
		System.out.println("Logout successful");

	}



}
