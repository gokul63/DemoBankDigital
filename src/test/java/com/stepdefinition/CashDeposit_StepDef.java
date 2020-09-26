package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CashDeposit_StepDef {
	
	public static WebDriver driver;
	PageObjectManager page_object_manager;
	String iBalance;
	
	private ScenarioContext context;
	
	public CashDeposit_StepDef(ScenarioContext context) {
		
		this.context = context;
		
	}
	
	@When("User enters the new  {string} and new{string} to log in to application")
	public void user_enters_the_new_and_new_to_log_in_to_application(String txtUserName, String txtPassword) {
		
		context.getpageObjectManagerValue().getSavings_page().getSavingsMenu().get(0).click();
		context.getpageObjectManagerValue().getSavings_page().getSavingsPage().get(0).click();
		iBalance = context.getpageObjectManagerValue().getSavings_page().getFirstBalance().get(0).getText();
	}

	@When("User initiates the deposit into account")
	public void user_initiates_the_deposit_into_account() {
		context.getpageObjectManagerValue().getDeposit_page().getTransfersPage().get(0).click();
		context.getpageObjectManagerValue().getDeposit_page().getDepositPage().get(0).click();
		Assert.assertTrue("Deposit Page Assertion",
				context.getpageObjectManagerValue().getDeposit_page().getTransfersVP().get(0).getText().equals("Deposit into Account"));
		System.out.println("Deposit Page is verified successfully");

	}

	@When("User inputs the {string} and {string} to complete the deposit")
	public void user_inputs_the_data_to_complete_the_deposit(String accountForDeposit, String depositAmount) {
		Select account = new Select(context.getpageObjectManagerValue().getDeposit_page().getDepositAccount().get(0));
		account.selectByValue(accountForDeposit);
		context.getpageObjectManagerValue().getDeposit_page().getDepositAmount().get(0).sendKeys(depositAmount);
		context.getpageObjectManagerValue().getDeposit_page().getSubmitButton().get(0).click();

	}

	@Then("Verify user completes the deposit successfully with deposit amount {string}")
	public void verify_user_completes_the_deposit_successfully(String depositAmount) {
		String substr1 = iBalance.substring(1, 6);
        double beforeamt = Double.parseDouble(substr1);
        System.out.println("balance before deposit : " + beforeamt);
        double depositamt = Double.parseDouble(depositAmount);
        String fBalance = context.getpageObjectManagerValue().getDeposit_page().getFinalBalance().get(0).getText();
        String substr2 = fBalance.substring(1, 6);
        double finalamt = Double.parseDouble(substr2);
        System.out.println("balance after deposit : " + finalamt);
        Assert.assertEquals("Deposit Transfer success Assertion", (beforeamt + depositamt), finalamt, 0.0);
        System.out.println("Deposit Page is verified successfully");
	}


}
