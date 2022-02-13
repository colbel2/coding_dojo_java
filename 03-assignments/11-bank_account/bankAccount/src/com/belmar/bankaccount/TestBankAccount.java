package com.belmar.bankaccount;

public class TestBankAccount {

		public static void main(String[] args) {
			BankAccount account1 = new BankAccount();
			BankAccount account2 = new BankAccount();
			
			
			
			account1.makeDeposit("checking",10000);
			
			account1.makeDeposit("saving",50);
			
			account2.makeDeposit("checking",736);
			
			account2.makeDeposit("saving",1245);
			
			account2.makeDeposit("checking",0215);
			
			account1.makeDeposit("saving",99999);
			
			account1.makeDeposit("checing", 50);
			
			account1.makeWithdrawal("saving",50);
			
			System.out.println(account1.displayAccountBalance());
			
			System.out.println(account2.displayAccountBalance());
			
			BankAccount.displayTotalBalance();
			
		}
}
