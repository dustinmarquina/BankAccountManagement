package BankAccountManagement;

public class Account  {
	protected String password, fullName, accountNumber, phoneNumber;
	protected double balance;
	
	
	
	public Account() {
		this.balance = 0.0f;
	}

	public Account(String accountNumber, String phoneNumber, String password, String fullName) {
		this.accountNumber = accountNumber;
		this.password = password;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
	}
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void widthdraw(double amount) {
		this.balance -= amount;
	}
	
}
