package com.karthik.ATMSystem.state;

import com.karthik.ATMSystem.service.ATMSystem;

public class PinValidatedState implements ATMState
{
	ATMSystem atm;

	public PinValidatedState(ATMSystem atm)
	{
		this.atm = atm;
	}

	@Override
	public void insertCard(String cardNo)
	{
		System.out.println("Card already inserted !!! Cannot insert another one !!!");
	}

	@Override
	public void insertPin(String pin)
	{
		System.out.println("Pin already validated !!!");
	}

	@Override
	public void checkAccountBalance()
	{
		System.out.println("Your account balance is: " + atm.getAuthenticatedAccount().getBalance());
	}

	@Override
	public void changePin(String oldPin, String newPin)
	{
		if (oldPin.equals(atm.getAuthenticatedAccount().getCard().getPin()))
		{
			atm.getBank().updatePin(atm.getAuthenticatedAccount(), newPin);
			System.out.println("Pin changed successfully !!!");
			atm.getState().ejectCard();
		}
		else
		{
			System.out.println("Old pin incorrect !!! Please try again !!!");
			atm.getState().ejectCard();
		}
	}

	@Override
	public void withdrawMoney(double amount)
	{
		double accountBalance = atm.getAuthenticatedAccount().getBalance();
		if (amount > accountBalance)
		{
			System.out.println("Transaction failed !!! Insufficient funds in account !!!");
		}
		else
		{
			if (amount > atm.getAtmBalance())
			{
				System.out.println("Transaction failed !!! Insufficient funds in ATM !!!");
			}
			else
			{
				atm.decreaseAtmBalance(amount);
				atm.getBank().updateBalance(atm.getAuthenticatedAccount(), accountBalance - amount);
				System.out.println("Transaction successful !!! Please collect the money !!!");
			}
		}
		atm.getState().checkAccountBalance();
		atm.getState().ejectCard();
	}

	@Override
	public void depositMoney(double amount)
	{
		double accountBalance = atm.getAuthenticatedAccount().getBalance();

		atm.increaseAtmBalance(amount);
		atm.getBank().updateBalance(atm.getAuthenticatedAccount(), accountBalance + amount);
		System.out.println("Transaction successful !!! Money Deposited !!!");
		atm.getState().checkAccountBalance();
		atm.getState().ejectCard();
	}

	@Override
	public void ejectCard()
	{
		atm.setState(atm.getTransactionCompleteState());
		atm.getState().ejectCard();
	}

}
