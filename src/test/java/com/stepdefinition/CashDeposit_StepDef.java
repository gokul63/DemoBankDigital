package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.pagemanager.PageObjectManager;

import ExcelData.ExcelData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CashDeposit_StepDef extends ExcelData {
	
	public static WebDriver driver;
	PageObjectManager page_object_manager;
	String iBalance;
	String userName;
	String userPassword;
	String userDepositAccount;
	String userDepositAmount;
	
	private ScenarioContext context;
	
	public CashDeposit_StepDef(ScenarioContext context) {
		
		this.context = context;
		
	}
	
	@When("User gets {string} to perform  deposit into account")
	public void user_gets_to_perform_deposit_into_account(String testCaseId) throws Exception {
		
		System.out.println("****Executing Cash Deposit Scenario****");
		userName = retriveData().get(testCaseId).get("UserName");
		userPassword = retriveData().get(testCaseId).get("Password");
		userDepositAccount = retriveData().get(testCaseId).get("AccountForDeposit");
		userDepositAmount = retriveData().get(testCaseId).get("DepositAmount");
		context.setUserName(userName);
		context.setUserPassword(userPassword);
	}
	

	@When("User initiates the deposit into account")
	public void user_initiates_the_deposit_into_account() {
		context.getpageObjectManagerValue().getSavings_page().getSavingsMenu().click();
		context.getpageObjectManagerValue().getSavings_page().getSavingsPage().click();
		iBalance = context.getpageObjectManagerValue().getSavings_page().getFirstBalance().getText();
		context.getpageObjectManagerValue().getDeposit_page().getTransfersPage().click();
		context.getpageObjectManagerValue().getDeposit_page().getDepositPage().click();
		Assert.assertTrue("Deposit Page Assertion",
				context.getpageObjectManagerValue().getDeposit_page().getTransfersVP().getText().equals("Deposit into Account"));
		System.out.println("Deposit Page is verified successfully");

	}

	@When("User inputs the accountForDeposit and depositAmount to complete the deposit")
	public void user_inputs_the_accountForDeposit_and_depositAmount_to_complete_the_deposit() {
		Select account = new Select(context.getpageObjectManagerValue().getDeposit_page().getDepositAccount());
		account.selectByValue(userDepositAccount.split("-")[1]);
		context.getpageObjectManagerValue().getDeposit_page().getDepositAmount().sendKeys(userDepositAmount);
		context.getpageObjectManagerValue().getDeposit_page().getSubmitButton().click();

	}

	@Then("Verify user completes the deposit successfully with deposit amount depositAmount")
	public void verify_user_completes_the_deposit_successfully_with_deposit_amount_depositAmount() {
		String substr1 = iBalance.substring(1, 6);
        double beforeamt = Double.parseDouble(substr1);
        System.out.println("balance before deposit : " + beforeamt);
        double depositamt = Double.parseDouble(userDepositAmount);
        String fBalance = context.getpageObjectManagerValue().getDeposit_page().getFinalBalance().getText();
        String substr2 = fBalance.substring(1, 6);
        double finalamt = Double.parseDouble(substr2);
        System.out.println("balance after deposit : " + finalamt);
        Assert.assertEquals("Deposit Transfer success Assertion", (beforeamt + depositamt), finalamt, 0.0);
        System.out.println("Deposit Page is verified successfully");
	}


}
