package com.karthik.ATMSystem.model;

public class Account
{
	private String accountHolderName;
	private String accountNumber;
	private Card card;
	private double balance;

	public Account(String accountHolderName, String accountNumber, Card card, double balance)
	{
		this.accountHolderName = accountHolderName;
		this.accountNumber = accountNumber;
		this.card = card;
		this.balance = balance;
	}

	public String getAccountHolderName()
	{
		return accountHolderName;
	}

	public String getAccountNumber()
	{
		return accountNumber;
	}

	public Card getCard()
	{
		return card;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}
}
