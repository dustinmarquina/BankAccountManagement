package BankAccountManagement;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
public class ShowAction1 {
	static Scanner sc = new Scanner(System.in);
	static Account ac = new Account();
	static Account ac1 = new Account("020804","0774567890","giathinh","123");
	private static ArrayList<Account> arrayList = new ArrayList<Account>();
	public static void showBank() {
		System.out.println("BANK LIST: ");
		System.out.println("1. VIETCOMBANK (VCB)");
		System.out.println("2. VIETTINBANK (ICBV)");
		System.out.println("3. TECHCOMBANK (TCB)");
		System.out.println("4. MBBANK (MB)");
		System.out.print("Choose your Bank (Enter 1-4): ");
		int opt = sc.nextInt();
		System.out.println();
		while (opt<1||opt>4) {
			System.out.println("INVALID NUMBER !!!");
			System.out.print("Please enter again (1-4): ");
			opt = sc.nextInt();
		}
		switch (opt) {
		case 1: 
			System.out.println("-------------WELCOME TO VIETCOMBANK-------------");
			break;
		case 2: 
			System.out.println("-------------WELCOME TO VIETTINBANK-------------");
			 break;
		case 3: 
			System.out.println("-------------WELCOME TO TECHCOMBANK-------------");
			 break;
		case 4: 
			System.out.println("----------------WELCOME TO MBBANK---------------");
			break;
		}
		System.out.println();
		chooseAction();
	
		
	}
	//-----------------chooseAction--------------
	public static void chooseAction() {
		 Scanner sc = new Scanner(System.in);
			System.out.println("Choose your action: ");
			System.out.println("1. Log in ");
			System.out.println("2. Sign up ");
			System.out.println("3. Back");
			System.out.print("Enter (1-3): ");
			int choose = sc.nextInt();
			System.out.println();
			while (choose<1||choose >3) {
				System.out.println("INVALID NUMBER !!!");
				System.out.print("Please enter again (1-3): ");
				choose = sc.nextInt();
			}
			switch (choose) {
			case 1: login();break;
			case 2: signUp(); break;
			case 3: showBank();break;
			}
			}
	public static void signUp() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Full name: ");
		String fullName = sc.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = sc.next();
		System.out.print("Account Number: ");
		String accountNumber = sc.next();
		System.out.print("Password: ");
		String pw = sc.next();
		ac = new Account(accountNumber, phoneNumber,pw, fullName);
		arrayList.add(ac);
		System.out.println();
		System.out.println("Sign up successful");
		System.out.println();
		chooseAction();
	}
	
	public static void login() {
		System.out.print("Account number: ");
		String accountNumber = sc.next();
		System.out.print("Password: ");
		String password = sc.next();
		if (findExistedAccount(password,accountNumber)) {
			System.out.println();
			System.out.println("Log in Successful");
			System.out.println();
			menuBar(accountNumber);
		}
		else{
			System.out.println("Your password was incorrect!!!");
			System.out.println();
			backOrNext();
		}
		System.out.println();
		menuBar(null);
	}
		
	public static void backOrNext() {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Try again");
		System.out.println("2. Have not sign up yet? Sign up");
		System.out.println("Enter 1-2: ");
		int opt = sc.nextInt();
		switch (opt) {
		case 1: login(); break;
		case 2: signUp();break;
		}
	}
	
	public static void menuBar(String accountNumber) {
		System.out.println("Choose your action: ");
		System.out.println("1. Recharge");
		System.out.println("2. Transfer ");
		System.out.println("3. Withdraw");
		System.out.println("4. Log out");
		System.out.print("Enter (1-3): ");
		int opt = sc.nextInt();
		System.out.println();
		switch (opt) {
		case 1: {
			System.out.println("Latest Balance: "+findExistedAccount1(accountNumber).getBalance());
			System.out.print("Enter amount: ");
			int amount = sc.nextInt();
			if (amount > 0) {
				System.out.println("Updated Balance Successful");
				System.out.println();
				findExistedAccount1(accountNumber).deposit(amount);
				System.out.print("Latest Balance: "+findExistedAccount1(accountNumber).getBalance());
				System.out.println();menuBar(accountNumber);
				}break;
		}
		case 2: {
			if (findExistedAccount1(accountNumber).getBalance()==0) {
				System.out.println("No money in your account !!!");
				System.out.println("Please recharge more");
				sc.nextLine();
				menuBar(accountNumber);
			}else {
			System.out.println("Current Balance: "+findExistedAccount1(accountNumber).getBalance());
			System.out.println("Enter transfer account number: ");
			String accountNumber1 = sc.next();
			if (findExistedAccount1(accountNumber1)!=null) {
				System.out.print("Enter transfer amount: ");
				int amount = sc.nextInt();
				if (amount <= findExistedAccount1(accountNumber).getBalance()) {
				findExistedAccount1(accountNumber).widthdraw(amount);
				findExistedAccount1(accountNumber1).deposit(amount);
				System.out.println("Updated Balance Successful");
				System.out.println();
				System.out.println("Latest Balance: "+findExistedAccount1(accountNumber).getBalance());
				System.out.println("Transfer Successful");
				menuBar(accountNumber);
					}
				else System.out.print("Amount transfer exceeds the current Balance");
			}
			}break;
		}
		case 3: {
			if (findExistedAccount1(accountNumber).getBalance()==0) {
				System.out.println("No money in your account !!!");
				System.out.println("Please recharge more");
				sc.nextLine();
				menuBar(accountNumber);
			}else {
			System.out.println("Current Balance: "+findExistedAccount1(accountNumber).getBalance());
			System.out.print("Enter withdraw amount: ");
			int amount = sc.nextInt();
			if (amount <= findExistedAccount1(accountNumber).getBalance()) {
				findExistedAccount1(accountNumber).widthdraw(amount);
			System.out.println("Updated Balance Successful");
			System.out.println();
			System.out.println("Latest Balance: "+findExistedAccount1(accountNumber).getBalance());
			System.out.println();
			menuBar(accountNumber);
				}
			else System.out.print("Amount withdraw exceeds the current Balance");
			}break;
		}
		case 4: chooseAction(); break;
		}
	}
	public static boolean findExistedAccount(String password, String accountNumber) {
		for (Account a : arrayList) {
			if (a.getAccountNumber().equalsIgnoreCase(accountNumber)&&a.getPassword().equals(password))return true;
		}return false;
	}
	public static Account findExistedAccount1(String accountNumber) {
		for (Account a : arrayList) {
			if (a.getAccountNumber().equalsIgnoreCase(accountNumber))return a;
		}return null;
	}
	}
	

