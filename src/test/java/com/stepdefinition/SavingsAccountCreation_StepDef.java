package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pagemanager.PageObjectManager;

import ExcelData.ExcelData;
import io.cucumber.java.en.And;

import io.cucumber.java.en.When;


public class SavingsAccountCreation_StepDef extends ExcelData {
	
	PageObjectManager page_object_manager;
	
	private ScenarioContext context;
	
	String userName;
	String userPassword;
	String userNewSavingsAccount;
	String userInitailDepositAmount;
	public SavingsAccountCreation_StepDef(ScenarioContext context) {
		
		this.context = context;
		
	}
	
	@When("User gets {string} to perform  savings account opening")
	public void user_gets_to_perform_savings_account_opening(String testCaseId) throws Exception {
		userName = retriveData().get(testCaseId).get("UserName");
		userPassword = retriveData().get(testCaseId).get("Password");
		userNewSavingsAccount = retriveData().get(testCaseId).get("NewAccountName");
		userInitailDepositAmount = retriveData().get(testCaseId).get("IntialDepositAmount");
		context.setUserName(userName);
		context.setUserPassword(userPassword);
	}
	
	@And("User initiate the saving bank account opening")
	public void user_initiate_the_saving_bank_account_opening() {
		try {
			context.getpageObjectManagerValue().getSavings_page().getSavingsMenu().click();
			context.getpageObjectManagerValue().getSavings_page().getNewSavings().click();
			 Assert.assertTrue("Savings Account creation Page",
					 context.getpageObjectManagerValue().getSavings_page()
			 .getNewSavingsHeading().getText().equals("New Savings Account"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User inputs the AccountName, DepositAmount to complete the savings account opening")
	public void user_inputs_the_AccountName_DepositAmount_to_complete_the_savings_account_opening() {

		try {

			context.getpageObjectManagerValue().getSavings_page().getAccountType().click();
			context.getpageObjectManagerValue().getSavings_page().getAccountOwnership().click();
			context.getpageObjectManagerValue().getSavings_page().getAccountName().sendKeys(userNewSavingsAccount);
			context.getpageObjectManagerValue().getSavings_page().getOpenBal().sendKeys(userInitailDepositAmount);
			context.getpageObjectManagerValue().getSavings_page().getSavingSubmit().click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User can able to view the newly created account with AccountName successfully")
	public void user_can_able_to_view_the_newly_created_account_with_AccountName_successfully() {
		try {
			context.getpageObjectManagerValue().getSavings_page().getSavingsMenu().click();
			context.getpageObjectManagerValue().getSavings_page().getViewSavingAcc().click();
			List<WebElement> aclist = context.getpageObjectManagerValue().getSavings_page().getAccountList();
			String accountname = null;
			for (int i = 0; i < aclist.size(); i++) {
				accountname = aclist.get(i).getText();
				if (accountname.contains(userNewSavingsAccount)) {
					System.out.println(accountname);
					Assert.assertTrue(accountname, accountname.contains(userNewSavingsAccount));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
