package com.karthik.ATMSystem.state;

import com.karthik.ATMSystem.service.ATMSystem;

public class TransactionCompleteState implements ATMState
{
	ATMSystem atm;

	public TransactionCompleteState(ATMSystem atm)
	{
		this.atm = atm;
	}

	@Override
	public void insertCard(String cardNo)
	{
		System.out.println("Transaction completed !!!");
	}

	@Override
	public void checkAccountBalance()
	{
		System.out.println("Transaction completed !!!");
	}

	@Override
	public void insertPin(String pin)
	{
		System.out.println("Transaction completed !!!");
	}

	@Override
	public void changePin(String oldPin, String newPin)
	{
		System.out.println("Transaction completed !!!");
	}

	@Override
	public void withdrawMoney(double amount)
	{
		System.out.println("Transaction completed !!!");
	}

	@Override
	public void depositMoney(double amount)
	{
		System.out.println("Transaction completed !!!");
	}

	@Override
	public void ejectCard()
	{
		System.out.println("Ejecting card...");
		atm.setInsertedCard(null);
		atm.setAuthenticatedAccount(null);
		atm.setState(atm.getIdleState());
		System.out.println("Transaction completed !!! Card Ejected Successfully !!!");
	}

}
