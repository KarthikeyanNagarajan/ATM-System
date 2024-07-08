package com.karthik.ATMSystem.service;

import com.karthik.ATMSystem.model.Account;
import com.karthik.ATMSystem.model.Card;

public class MainClass
{

	public static void main(String[] args)
	{
		Card card1 = new Card("1111 0001", "1111");
		Card card2 = new Card("1111 0002", "2222");

		Account account1 = new Account("Karthik-1", "AccKart001", card1, 50010.98);
		Account account2 = new Account("Karthik-2", "AccKart002", card2, 10000.50);

		Bank bank = Bank.getInstance();
		bank.addAccount(account1);
		bank.addAccount(account2);

		ATMSystem atmSystem = ATMSystem.getInstance(100000.00);
		atmSystem.insertCard("1111 0002");
		atmSystem.checkAccountBalance();	
		atmSystem.insertPin("2222");
		atmSystem.checkAccountBalance();	
		atmSystem.withdrawMoney(100.25);	
	}

}
