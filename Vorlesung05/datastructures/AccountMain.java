package datastructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AccountMain {

	public static void main(String[] args) {
		boolean tmp = false;

		HashSet<Account> accounts = new HashSet<Account>();
		accounts.add(new Account("Spiderman", 113));
		accounts.add(new Account("Superman", 114));
		accounts.add(new Account("Chuck Norris", 0));
		accounts.add(new Account("Tetrisplayer87", 124));
		accounts.add(new Account("JavaUser1", 153));
		accounts.add(new Account("Dev4Live", 1433));
		accounts.add(new Account("Zev99", 1457));

		Scanner input = new Scanner(System.in);
		System.out.println("Enter username: ");
		String valName = input.nextLine();
		System.out.println("Enter phone: ");
		int valPhone = input.nextInt();
		input.close();

		Account newUser = new Account(valName, valPhone);
		
		//TODO du kannst fragen if(accounts.contains(newUser)) {
		for (Account account : accounts) {
			if (newUser.equals(account)) {
				System.out.println("User already exists!");
				tmp = false;
				//TODO das return an dieser stelle ist unschön
				return;
			} else {
				tmp = true;
			}
		}
		
		if(tmp) {
			accounts.add(newUser);
		}

		for (Account account : accounts) {
			System.out.println(account.getUsername() + " " + account.getPhone());
		}
	}

}
