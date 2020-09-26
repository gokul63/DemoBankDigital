package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pagemanager.PageObjectManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class SavingsAccountCreation_StepDef {
	
	PageObjectManager page_object_manager;
	
	private ScenarioContext context;
	
	public SavingsAccountCreation_StepDef(ScenarioContext context) {
		
		this.context = context;
		
	}
	
	@And("User initiate the saving bank account opening")
	public void user_initiate_the_saving_bank_account_opening() {
		try {
			context.getpageObjectManagerValue().getSavings_page().getSavingsMenu().get(0).click();
			context.getpageObjectManagerValue().getSavings_page().getNewsavings().click();
			 Assert.assertTrue("Savings Account creation Page",
					 context.getpageObjectManagerValue().getSavings_page()
			 .getNewsavingsheading().getText().equals("New Savings Account"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@And("User inputs the {string}, {string} to complete the savings account opening")
	public void user_inputs_the_and_type_of_account_to_complete_the_account_opening(String accname, String amount) {

		try {

			context.getpageObjectManagerValue().getSavings_page().getAccountType().click();
			context.getpageObjectManagerValue().getSavings_page().getAccountOwnership().click();
			context.getpageObjectManagerValue().getSavings_page().getAccountName().sendKeys(accname);
			context.getpageObjectManagerValue().getSavings_page().getOpenBalance().sendKeys(amount);
			context.getpageObjectManagerValue().getSavings_page().getCreateAccount().click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("User can able to view the newly created account with {string} successfully")
	public void verify_account_creation(String accname) {
		try {
			context.getpageObjectManagerValue().getSavings_page().getSavingsMenu().get(0).click();
			context.getpageObjectManagerValue().getSavings_page().getViewAc().click();
			List<WebElement> aclist = context.getpageObjectManagerValue().getSavings_page().getAccountList();
			String accountname = null;
			for (int i = 0; i < aclist.size(); i++) {
				accountname = aclist.get(i).getText();
				if (accountname.contains(accname)) {
					System.out.println(accountname);
					Assert.assertTrue(accountname, accountname.contains(accname));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
