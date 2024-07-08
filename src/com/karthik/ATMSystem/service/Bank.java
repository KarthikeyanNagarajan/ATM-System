package com.karthik.ATMSystem.service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import com.karthik.ATMSystem.model.Account;
import com.karthik.ATMSystem.model.Card;

public class Bank
{
	private Set<Account> accounts;
	private Set<String> cardNos;
	private static Bank bank;

	public static Bank getInstance()
	{
		if (bank == null)
			bank = new Bank();
		return bank;
	}

	private Bank()
	{
		accounts = new LinkedHashSet<>();
		cardNos = new LinkedHashSet<>();
	}

	public void updatePin(Account account, String pin)
	{
		accounts.remove(account);
		account.getCard().setPin(pin);
		accounts.add(account);
	}

	public void updateBalance(Account account, double balance)
	{
		accounts.remove(account);
		account.setBalance(balance);
		accounts.add(account);
	}

	public void addAccount(Account account)
	{
		accounts.add(account);
		cardNos.add(account.getCard().getCardNumber());
	}

	public Optional<Account> getAccount(Card card)
	{
		return accounts.stream().filter(account -> account.getCard().equals(card)).findFirst();
	}

	public boolean isCardValid(String cardNo)
	{
		return cardNos.contains(cardNo);
	}
}
