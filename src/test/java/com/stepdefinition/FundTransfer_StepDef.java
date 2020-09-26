package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pagemanager.PageObjectManager;
import com.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundTransfer_StepDef {
	
	PageObjectManager page_object_manager;
	HomePage homepage;
	String balancebeforetransfer;
	String balanceaftertransfer;
	double actualTransferAmount;
	
	private ScenarioContext context;
	
	public FundTransfer_StepDef(ScenarioContext context) {
		
		this.context = context;
		
		
	}
	
	@When("User initiate the fund transfer")
	public void user_initiate_the_fund_transfer() {
		
		//homepage = page_object_manager.getHome_page();
		homepage = context.getpageObjectManagerValue().getHome_page();
		homepage.getLstSavings().get(0).click();
		homepage.getLstViewSavings().get(0).click();
		System.out.println(
				"Account Holder Name :" + homepage.getLstTextUser().get(0).getText());
		balancebeforetransfer = homepage.getLstUserBalance().get(0).getText();
		System.out.println("Account Before Fund Transfer " + balancebeforetransfer);
		homepage.getLstTransfer().get(0).click();
		homepage.getLstBetweenAccount().get(0).click();
		Assert.assertTrue("Fund Transfer Assert", homepage.getLstConfirmText().get(0)
				.getText().equals("Transfer Between Accounts"));
		System.out.println("Fund transfer page is verified Succesffuly");
		
	}
	
	@When("User inputs the {string}, {string} and {string} to complete  the fund transfer")
	public void user_inputs_the_and_to_complete_the_fund_transfer(String senderAcc, String receiverACC, String amount) {
		Select dropdownsender = new Select(context.getpageObjectManagerValue().getFundtransfer_page().getLstSender().get(0));
		dropdownsender.selectByValue(senderAcc);
		Select dropdownreceiver = new Select(context.getpageObjectManagerValue().getFundtransfer_page().getLstReceiver().get(0));
		dropdownreceiver.selectByValue(receiverACC);
		context.getpageObjectManagerValue().getFundtransfer_page().getLstAmount().get(0).sendKeys(amount);
		context.getpageObjectManagerValue().getFundtransfer_page().getLstSubmitButton().get(2).click();
		context.getpageObjectManagerValue().getTransaction_page().getLstButton().get(0).click();

		balanceaftertransfer = context.getpageObjectManagerValue().getTransaction_page().getLstUserBalance().get(0).getText();
		System.out.println("Account After Fund Transfer " + balanceaftertransfer);

		String substring1 = balanceaftertransfer.substring(10);
		double balanceafter = Double.parseDouble(substring1);

		String substring = balancebeforetransfer.substring(10);
		double balancebefore = Double.parseDouble(substring);
		System.out.println(balanceafter);
		System.out.println(balancebefore);
		actualTransferAmount = balancebefore - balanceafter;
		String actualAmount = Double.toString(actualTransferAmount);
		System.out.println(actualAmount);
		System.out.println("Expected Transfer Amount : " + amount);
		System.out.println("Acutal Transfer Amount : " + actualTransferAmount);
		Assert.assertTrue("Compare actual and expected transfer account", amount.equals(actualAmount));
		System.out.println("Expected and Acutal is successfully compared");
	}

	@Then("Verify user completes the fund transfer successfully")
	public void verify_user_completes_the_fund_transfer_successfully_and_log_out_the_application()
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) context.getWebDriverValue();
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");		
				
		System.out.println("\n\t\tTransaction statement for fund transfer\n");
		int size = context.getpageObjectManagerValue().getTransaction_page().getTextHeading().size();
		for (int i = 0; i < size; i++) {
			System.out.print(context.getpageObjectManagerValue().getTransaction_page().getTextHeading().get(i).getText() + "\t\t\t\t");
		}
		System.out.println();
		WebElement txtData = context.getpageObjectManagerValue().getTransaction_page().getTextRow().get(1);
		List<WebElement> txt = txtData.findElements(By.tagName("td"));
		for (WebElement webElement : txt) {
			System.out.print(webElement.getText() + "\t\t");
		}
		System.out.println();
	
	}


}
