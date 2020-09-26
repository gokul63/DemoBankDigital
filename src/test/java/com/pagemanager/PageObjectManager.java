package com.pagemanager;

import org.openqa.selenium.WebDriver;

import com.pages.DepositPage;
import com.pages.FundTransferPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.Logout;
import com.pages.SavingsPage;
import com.pages.TransactionPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage login_page;
	private HomePage home_page;
	private FundTransferPage fundtransfer_page;
	private TransactionPage transaction_page;
	private DepositPage deposit_page;
	private SavingsPage savings_page;
	private Logout logout;
	
	public PageObjectManager(WebDriver driver) {
		
		this.driver = driver;
	}

	public LoginPage getLogin_page() {
		return (login_page == null) ? login_page = new LoginPage(driver) : login_page;
	}

	public HomePage getHome_page() {
		return (home_page == null) ? home_page = new HomePage(driver) : home_page;
	}

	public FundTransferPage getFundtransfer_page() {
		return (fundtransfer_page == null) ? fundtransfer_page = new FundTransferPage(driver) : fundtransfer_page;
	}

	public TransactionPage getTransaction_page() {
		return (transaction_page == null) ? transaction_page = new TransactionPage(driver) : transaction_page;
	}
	
	public DepositPage getDeposit_page() {
		return (deposit_page == null) ? deposit_page = new DepositPage(driver) : deposit_page;
	}
	public SavingsPage getSavings_page() {
		return (savings_page == null) ? savings_page = new SavingsPage(driver) : savings_page;
	}
	public Logout getLogout() {
        return (logout == null) ? logout = new Logout(driver) : logout;
    }
	
	
	
	
	

}
