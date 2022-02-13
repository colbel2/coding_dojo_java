package com.belmar.bankaccount;

public class BankAccount {

		public double checkingBalance;
		public double savingBalance;
		public long accountNumber;
		
		public static Integer numberOfAccounts;
		public static double totalBalance;
		
		public BankAccount() {
			this(0.0,0.0, BankAccount.generateAccountNumber());
		}
		//this works and creates a 10 digit account number somehow
				public static long generateAccountNumber() {
					long accountNumber = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
					return accountNumber;
				}
		
		public BankAccount(double checkingBalance, double savingBalance, long accountNumber) {
			this.checkingBalance = checkingBalance;
			this.savingBalance = savingBalance;
			this.accountNumber = accountNumber;
			numberOfAccounts += 1;
		}
		
		public double getCheckingBalance() {
			return checkingBalance;
		}
		
		public double getSavingBalance() {
			return savingBalance;
		}
		
		public long getAccountNumber() {
			return accountNumber;
		}
		
		public void makeDeposit(String account, double amount) {
			if (account == "checking") {
				this.checkingBalance += amount;
				totalBalance += amount;
				System.out.println("Deposited to Checking Account");
			}else if (account =="saving") {
				this.savingBalance += amount;
				totalBalance+= amount;
				System.out.println("Deposited to Saving Account");
			}else {
				System.out.println("Please select an account");
			}
		}
		
		public void makeWithdrawal(String account, double amount) {
			if (account == "checking") {
				this.checkingBalance -= amount;
				totalBalance -= amount;
				System.out.println("Withdrew From Checking Account");
			}else if (account =="saving") {
				this.savingBalance -= amount;
				totalBalance-= amount;
				System.out.println("Withdrew from Saving Account");
			}else {
				System.out.println("Please select an account");
			}
		}
		public String displayAccountBalance() {
			return String.format("Remaining balance: \nChecking: $%s\n Savings: $%s", this.checkingBalance,this.savingBalance);
		}
		public static void displayTotalBalance() {
			System.out.println(totalBalance);
		}
		
		
}
