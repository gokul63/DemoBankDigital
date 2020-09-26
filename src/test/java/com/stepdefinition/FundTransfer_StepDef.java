package com.stepdefinition;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pagemanager.PageObjectManager;
import com.pages.HomePage;

import ExcelData.ExcelData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FundTransfer_StepDef extends ExcelData {

	PageObjectManager page_object_manager;
	HomePage homepage;
	String balancebeforetransfer;
	String balanceaftertransfer;
	double actualTransferAmount;
	String userName;
	String userPassword;
	String senderAccount;
	String receiverAccount;
	String transferAmount;
	String userDepositAccount;
	String userDepositAmount;

	private ScenarioContext context;

	public FundTransfer_StepDef(ScenarioContext context) {

		this.context = context;

	}

	@When("User gets {string} to perform fundtransfer")
	public void user_gets_to_perform_fundtransfer(String testCaseId) throws Exception {
		userName = retriveData().get(testCaseId).get("UserName");
		userPassword = retriveData().get(testCaseId).get("Password");
		senderAccount = retriveData().get(testCaseId).get("SenderAccount");
		receiverAccount = retriveData().get(testCaseId).get("ReceiverAccount");
		transferAmount = retriveData().get(testCaseId).get("TransferAmount");
		context.setUserName(userName);
		context.setUserPassword(userPassword);
	}

	@When("User initiate the fund transfer")
	public void user_initiate_the_fund_transfer() {

		// homepage = page_object_manager.getHome_page();
		homepage = context.getpageObjectManagerValue().getHome_page();
		homepage.getLstSavings().click();
		homepage.getLstViewSavings().click();
		System.out.println("Account Holder Name :" + homepage.getLstTextUser().getText());
		balancebeforetransfer = homepage.getLstUserBalance().getText();
		System.out.println("Account Before Fund Transfer " + balancebeforetransfer);
		homepage.getLstTransfer().click();
		homepage.getLstBetweenAccount().click();
		Assert.assertTrue("Fund Transfer Assert",
				homepage.getLstConfirmText().getText().equals("Transfer Between Accounts"));
		System.out.println("Fund transfer page is verified Succesffuly");

	}

	@When("User inputs the senderAccount, receiverAccount and amount to complete  the fund transfer")
	public void user_inputs_the_senderAccount_receiverAccount_and_amount_to_complete_the_fund_transfer() {
		Select dropdownsender = new Select(
				context.getpageObjectManagerValue().getFundtransfer_page().getLstSender());
		dropdownsender.selectByValue(senderAccount.split("-")[1]);
		Select dropdownreceiver = new Select(
				context.getpageObjectManagerValue().getFundtransfer_page().getLstReceiver());
		dropdownreceiver.selectByValue(receiverAccount.split("-")[1]);
		System.out.println(transferAmount);
		context.getpageObjectManagerValue().getFundtransfer_page().getLstAmount().sendKeys(transferAmount);
		context.getpageObjectManagerValue().getFundtransfer_page().getLstSubmitButton().click();
		context.getpageObjectManagerValue().getTransaction_page().getLstButton().click();

		balanceaftertransfer = context.getpageObjectManagerValue().getTransaction_page().getLstUserBalance().getText();
		System.out.println("Account After Fund Transfer " + balanceaftertransfer);

		String substring1 = balanceaftertransfer.substring(10);
		double balanceafter = Double.parseDouble(substring1);

		String substring = balancebeforetransfer.substring(10);
		double balancebefore = Double.parseDouble(substring);
		System.out.println(balanceafter);
		System.out.println(balancebefore);
		actualTransferAmount = balancebefore - balanceafter;
		String actualAmount =String.valueOf((long)actualTransferAmount);
		System.out.println(actualAmount);
		System.out.println("Expected Transfer Amount : " + transferAmount);
		System.out.println("Acutal Transfer Amount : " + String.valueOf((long)actualTransferAmount));
		Assert.assertTrue("Compare actual and expected transfer account", transferAmount.equals(actualAmount));
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
			System.out.print(context.getpageObjectManagerValue().getTransaction_page().getTextHeading().get(i).getText()
					+ "\t\t\t\t");
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
